/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Collection;
import javax.swing.Action;
import org.jhotdraw.draw.AttributeKeys;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Unbreakable
 */
public class SVGPathFigureTest {

    SVGPathFigure instance;

    public SVGPathFigureTest() {
    }

    @Before
    public void setUp() {
        instance = new SVGPathFigure();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getActions method, of class SVGPathFigure.
     */
    @Test
    public void testGetActions() {
        int expectedSize = 2;
        int newExpectedSize = 4;
        System.out.println("getActions");
        Point2D.Double p = new Point2D.Double(0, 0);
        Collection<Action> result = instance.getActions(p);
        assertFalse(result.isEmpty());
        assertEquals(expectedSize, result.size());
        //Assert that the number of actions increase when the transform attribute is set.
        instance.setAttribute(AttributeKeys.TRANSFORM, new AffineTransform());
        result = instance.getActions(p);
        assertEquals(newExpectedSize, result.size());
    }

    /**
     * Test of draw method, of class SVGPathFigure.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        instance.setAttribute(AttributeKeys.FILL_COLOR, Color.BLACK);
        Graphics2D g = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB).createGraphics(); //Probably a good idea to mock this out!
        instance.draw(g);
        assertEquals(instance.getAttribute(AttributeKeys.FILL_COLOR), g.getPaint());
    }
}
