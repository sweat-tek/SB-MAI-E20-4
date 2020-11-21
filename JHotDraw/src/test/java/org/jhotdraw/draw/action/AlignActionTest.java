/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.action.AlignAction.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

public class AlignActionTest {

    private LineFigure vert1;
    private LineFigure vert2;
    private LineFigure hor1;
    private LineFigure hor2;

    private ArrayList<Figure> verts;
    private ArrayList<Figure> hors;

    private DefaultDrawingEditor editor;
    private DrawingView view;

    @Before
    public void setUp() {
        vert1 = new LineFigure();
        vert1.setBounds(new Point2D.Double(1, 1), new Point2D.Double(1, 3));

        vert2 = new LineFigure();
        vert2.setBounds(new Point2D.Double(3, 2), new Point2D.Double(3, 4));

        verts = new ArrayList<>();
        verts.add(vert1);
        verts.add(vert2);

        hor1 = new LineFigure();
        hor1.setBounds(new Point2D.Double(1, 1), new Point2D.Double(3, 1));

        hor2 = new LineFigure();
        hor2.setBounds(new Point2D.Double(2, 3), new Point2D.Double(4, 3));

        hors = new ArrayList<>();
        hors.add(hor1);
        hors.add(hor2);

        editor = new DefaultDrawingEditor();
    }

    private void align(AlignAction action, Collection<Figure> figures) {
        Rectangle2D.Double bounds = null;
        AlignAction align = spy(action);
        doNothing().when(align).fireUndoableEditHappened(any(UndoableEdit.class));

        for (Figure f : figures) {
            if (bounds == null) {
                bounds = f.getBounds();
            } else {
                bounds.add(f.getBounds());
            }
        }
        align.alignFigures(figures, bounds);
    }

    private double getX(Figure f) {
        return f.getBounds().x;
    }

    private double getY(Figure f) {
        return f.getBounds().y;
    }

    private double biggest(double d1, double d2) {
        return Double.max(d1, d2);
    }

    private double smallest(double d1, double d2) {
        return Double.min(d1, d2);
    }

    @Test
    public void testNorth() {
        double north = smallest(getY(hor1), getY(hor2));
        assertNotEquals(getY(hor1), getY(hor2), 0);
        align(new North(editor), hors);
        assertEquals(getY(hor1), getY(hor2), 0);
        hors.forEach(f -> {
            assertEquals(getY(f), north, 0);
        });
    }

    @Test
    public void testEast() {
        double east = biggest(getX(vert1), getX(vert2));
        assertNotEquals(getX(vert1), getX(vert2), 0);
        align(new East(editor), verts);
        assertEquals(getX(vert1), getX(vert2), 0);
        verts.forEach(f -> {
            assertEquals(getX(f), east, 0);
        });
    }

    @Test
    public void testSouth() {
        double south = biggest(getY(hor1), getY(hor2));
        assertNotEquals(getY(hor1), getY(hor2), 0);
        align(new South(editor), hors);
        assertEquals(getY(hor1), getY(hor2), 0);
        hors.forEach(f -> {
            assertEquals(getY(hor1), south, 0);
        });
    }

    @Test
    public void testWest() {
        double west = smallest(getX(vert1), getX(vert2));
        assertNotEquals(getX(vert1), getX(vert2), 0);
        align(new West(editor), verts);
        assertEquals(getX(vert1), getX(vert2), 0);
        verts.forEach(f -> {
            assertEquals(getX(f), west, 0);
        });
    }

    @Test
    public void testVertical() {
        double mid = (getY(vert1) + getY(vert2)) / 2;
        assertNotEquals(getY(vert1), getY(vert2), 0);
        align(new Vertical(editor), verts);
        assertEquals(getY(vert1), getY(vert2), 0);
        verts.forEach(f -> {
            assertEquals(getY(f), mid, 0);
        });
    }

    @Test
    public void testHorizontal() {
        double mid = (getX(hor1) + getX(hor2)) / 2;
        assertNotEquals(getX(hor1), getX(hor2), 0);
        align(new Horizontal(editor), hors);
        assertEquals(getX(hor1), getX(hor2), 0);
        hors.forEach(f -> {
            assertEquals(getX(f), mid, 0);
        });
    }
}
