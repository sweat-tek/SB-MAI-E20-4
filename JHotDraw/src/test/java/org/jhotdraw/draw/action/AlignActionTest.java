/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Set;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.action.AlignAction.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlignActionTest {

    private ArrayList<Figure> figures;

    private DefaultDrawingEditor editor;
    private DrawingView view;

    @Before
    public void setUp() {
        LineFigure vert1 = new LineFigure();
        vert1.setBounds(new Point2D.Double(1, 1), new Point2D.Double(1, 3));

        LineFigure vert2 = new LineFigure();
        vert2.setBounds(new Point2D.Double(3, 2), new Point2D.Double(3, 4));

        LineFigure hor1 = new LineFigure();
        hor1.setBounds(new Point2D.Double(1, 1), new Point2D.Double(3, 1));

        LineFigure hor2 = new LineFigure();
        hor2.setBounds(new Point2D.Double(2, 3), new Point2D.Double(4, 3));

        figures = new ArrayList<>();
        figures.add(vert1);
        figures.add(vert2);
        figures.add(hor1);
        figures.add(hor2);

        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        view.getDrawing().addAll(figures);
        view.selectAll();
        editor.setActiveView(view);
    }

    public Rectangle2D align(AlignAction action) {
        Set<Figure> figures = action.getView().getSelectedFigures();
        Rectangle2D.Double bounds = null;
        for (Figure f : figures) {
            if (bounds == null) {
                bounds = f.getBounds();
            } else {
                bounds.add(f.getBounds());
            }
        }
        action.alignFigures(figures, bounds);
        return bounds;
    }

    private double getX(Figure f) {
        return f.getBounds().x;
    }

    private double getY(Figure f) {
        return f.getBounds().y;
    }

    public DefaultDrawingEditor getEditor() {
        return this.editor;
    }

    @Test
    public void testNorth() {
        Rectangle2D bounds = align(new North(editor));
        figures.forEach(f -> {
            assertEquals(getY(f), bounds.getMinY(), 0);
        });
    }

    @Test
    public void testEast() {
        Rectangle2D bounds = align(new East(editor));
        figures.forEach(f -> {
            assertEquals(f.getBounds().getMaxX(), bounds.getMaxX(), 0);
        });
    }

    @Test
    public void testSouth() {
        Rectangle2D bounds = align(new South(editor));
        figures.forEach(f -> {
            assertEquals(f.getBounds().getMaxY(), bounds.getMaxY(), 0);
        });
    }

    @Test
    public void testWest() {
        Rectangle2D bounds = align(new West(editor));
        figures.forEach(f -> {
            assertEquals(getX(f), bounds.getMinX(), 0);
        });
    }

    @Test
    public void testVertical() {
        Rectangle2D bounds = align(new Vertical(editor));
        figures.forEach(f -> {
            assertEquals(f.getBounds().getCenterY(), bounds.getCenterY(), 0);
        });
    }

    @Test
    public void testHorizontal() {
        Rectangle2D bounds = align(new Horizontal(editor));
        figures.forEach(f -> {
            assertEquals(f.getBounds().getCenterX(), bounds.getCenterX(), 0);
        });
    }
}
