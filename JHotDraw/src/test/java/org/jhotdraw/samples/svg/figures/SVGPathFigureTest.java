/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import javax.swing.Action;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Unbreakable
 */
public class SVGPathFigureTest {
    
    public SVGPathFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class SVGPathFigure.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics2D g = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawFigure method, of class SVGPathFigure.
     */
    @Test
    public void testDrawFigure() {
        System.out.println("drawFigure");
        Graphics2D g = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.drawFigure(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawChildren method, of class SVGPathFigure.
     */
    @Test
    public void testDrawChildren() {
        System.out.println("drawChildren");
        Graphics2D g = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.drawChildren(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawFill method, of class SVGPathFigure.
     */
    @Test
    public void testDrawFill() {
        System.out.println("drawFill");
        Graphics2D g = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.drawFill(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawStroke method, of class SVGPathFigure.
     */
    @Test
    public void testDrawStroke() {
        System.out.println("drawStroke");
        Graphics2D g = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.drawStroke(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidate method, of class SVGPathFigure.
     */
    @Test
    public void testInvalidate() {
        System.out.println("invalidate");
        SVGPathFigure instance = new SVGPathFigure();
        instance.invalidate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class SVGPathFigure.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        SVGPathFigure instance = new SVGPathFigure();
        GeneralPath expResult = null;
        GeneralPath result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHitShape method, of class SVGPathFigure.
     */
    @Test
    public void testGetHitShape() {
        System.out.println("getHitShape");
        SVGPathFigure instance = new SVGPathFigure();
        Shape expResult = null;
        Shape result = instance.getHitShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrawingArea method, of class SVGPathFigure.
     */
    @Test
    public void testGetDrawingArea() {
        System.out.println("getDrawingArea");
        SVGPathFigure instance = new SVGPathFigure();
        Rectangle2D.Double expResult = null;
        Rectangle2D.Double result = instance.getDrawingArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class SVGPathFigure.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        DOMOutput out = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.write(out);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class SVGPathFigure.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        DOMInput in = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.read(in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class SVGPathFigure.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Point2D.Double point = null;
        SVGPathFigure instance = new SVGPathFigure();
        boolean expResult = false;
        boolean result = instance.contains(point);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBounds method, of class SVGPathFigure.
     */
    @Test
    public void testSetBounds() {
        System.out.println("setBounds");
        Point2D.Double anchor = null;
        Point2D.Double lead = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.setBounds(anchor, lead);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transform method, of class SVGPathFigure.
     */
    @Test
    public void testTransform() {
        System.out.println("transform");
        AffineTransform tx = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.transform(tx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restoreTransformTo method, of class SVGPathFigure.
     */
    @Test
    public void testRestoreTransformTo() {
        System.out.println("restoreTransformTo");
        Object geometry = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.restoreTransformTo(geometry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransformRestoreData method, of class SVGPathFigure.
     */
    @Test
    public void testGetTransformRestoreData() {
        System.out.println("getTransformRestoreData");
        SVGPathFigure instance = new SVGPathFigure();
        Object expResult = null;
        Object result = instance.getTransformRestoreData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttribute method, of class SVGPathFigure.
     */
    @Test
    public void testSetAttribute() {
        System.out.println("setAttribute");
        SVGPathFigure instance = new SVGPathFigure();
        //instance.setAttribute(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class SVGPathFigure.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SVGPathFigure instance = new SVGPathFigure();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createHandles method, of class SVGPathFigure.
     */
    @Test
    public void testCreateHandles() {
        System.out.println("createHandles");
        int detailLevel = 0;
        SVGPathFigure instance = new SVGPathFigure();
        Collection<Handle> expResult = null;
        Collection<Handle> result = instance.createHandles(detailLevel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActions method, of class SVGPathFigure.
     */
    @Test
    public void testGetActions() {
        System.out.println("getActions");
        Point2D.Double p = null;
        SVGPathFigure instance = new SVGPathFigure();
        Collection<Action> expResult = null;
        Collection<Action> result = instance.getActions(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canConnect method, of class SVGPathFigure.
     */
    @Test
    public void testCanConnect() {
        System.out.println("canConnect");
        SVGPathFigure instance = new SVGPathFigure();
        boolean expResult = false;
        boolean result = instance.canConnect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConnector method, of class SVGPathFigure.
     */
    @Test
    public void testFindConnector() {
        System.out.println("findConnector");
        Point2D.Double p = null;
        ConnectionFigure prototype = null;
        SVGPathFigure instance = new SVGPathFigure();
        Connector expResult = null;
        Connector result = instance.findConnector(p, prototype);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCompatibleConnector method, of class SVGPathFigure.
     */
    @Test
    public void testFindCompatibleConnector() {
        System.out.println("findCompatibleConnector");
        Connector c = null;
        boolean isStartConnector = false;
        SVGPathFigure instance = new SVGPathFigure();
        Connector expResult = null;
        Connector result = instance.findCompatibleConnector(c, isStartConnector);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleMouseClick method, of class SVGPathFigure.
     */
    @Test
    public void testHandleMouseClick() {
        System.out.println("handleMouseClick");
        Point2D.Double p = null;
        MouseEvent evt = null;
        DrawingView view = null;
        SVGPathFigure instance = new SVGPathFigure();
        boolean expResult = false;
        boolean result = instance.handleMouseClick(p, evt, view);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class SVGPathFigure.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int index = 0;
        Figure figure = null;
        SVGPathFigure instance = new SVGPathFigure();
        instance.add(index, figure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChild method, of class SVGPathFigure.
     */
    @Test
    public void testGetChild() {
        System.out.println("getChild");
        int index = 0;
        SVGPathFigure instance = new SVGPathFigure();
        SVGBezierFigure expResult = null;
        SVGBezierFigure result = instance.getChild(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class SVGPathFigure.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        SVGPathFigure instance = new SVGPathFigure();
        SVGPathFigure expResult = null;
        SVGPathFigure result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flattenTransform method, of class SVGPathFigure.
     */
    @Test
    public void testFlattenTransform() {
        System.out.println("flattenTransform");
        SVGPathFigure instance = new SVGPathFigure();
        instance.flattenTransform();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
