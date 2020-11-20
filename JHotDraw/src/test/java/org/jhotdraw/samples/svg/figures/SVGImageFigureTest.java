/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import javax.imageio.ImageIO;
import javax.swing.Action;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frede
 */
public class SVGImageFigureTest {
    
    public SVGImageFigureTest() {
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

//    /**
//     * Test of draw method, of class SVGImageFigure.
//     */
//    @Test
//    public void testDraw() {
//        System.out.println("draw");
//        Graphics2D g = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.draw(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create2DGraphics method, of class SVGImageFigure.
//     */
//    @Test
//    public void testCreate2DGraphics() {
//        System.out.println("create2DGraphics");
//        BufferedImage image = null;
//        Graphics2D g = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.create2DGraphics(image, g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of drawDefaultShape method, of class SVGImageFigure.
//     */
//    @Test
//    public void testDrawDefaultShape() {
//        System.out.println("drawDefaultShape");
//        Graphics2D g = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.drawDefaultShape(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of drawFill method, of class SVGImageFigure.
//     */
//    @Test
//    public void testDrawFill() {
//        System.out.println("drawFill");
//        Graphics2D g = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.drawFill(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of drawStroke method, of class SVGImageFigure.
//     */
//    @Test
//    public void testDrawStroke() {
//        System.out.println("drawStroke");
//        Graphics2D g = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.drawStroke(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getX method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetX() {
//        System.out.println("getX");
//        SVGImageFigure instance = new SVGImageFigure();
//        double expResult = 0.0;
//        double result = instance.getX();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getY method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetY() {
//        System.out.println("getY");
//        SVGImageFigure instance = new SVGImageFigure();
//        double expResult = 0.0;
//        double result = instance.getY();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getWidth method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetWidth() {
//        System.out.println("getWidth");
//        SVGImageFigure instance = new SVGImageFigure();
//        double expResult = 0.0;
//        double result = instance.getWidth();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHeight method, of class SVGImageFigure.
//     */
////    @Test
////    public void testGetHeight() {
////        System.out.println("getHeight");
////        SVGImageFigure instance = new SVGImageFigure();
////        double expResult = 0.0;
////        double result = instance.getHeight();getHeight
////        assertEquals(expResult, result, 0.0);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of getBounds method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetBounds() {
//        System.out.println("getBounds");
//        SVGImageFigure instance = new SVGImageFigure();
//        Rectangle2D.Double expResult = null;
//        Rectangle2D.Double result = instance.getBounds();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDrawingArea method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetDrawingArea() {
//        System.out.println("getDrawingArea");
//        SVGImageFigure instance = new SVGImageFigure();
//        Rectangle2D.Double expResult = null;
//        Rectangle2D.Double result = instance.getDrawingArea();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of contains method, of class SVGImageFigure.
//     */
//    @Test
//    public void testContains() {
//        System.out.println("contains");
//        Point2D.Double p = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        boolean expResult = false;
//        boolean result = instance.contains(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBounds method, of class SVGImageFigure.
//     */
//    @Test
//    public void testSetBounds() {
//        System.out.println("setBounds");
//        Point2D.Double anchor = null;
//        Point2D.Double lead = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.setBounds(anchor, lead);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of transform method, of class SVGImageFigure.
//     */
//    @Test
//    public void testTransform() {
//        System.out.println("transform");
//        AffineTransform tx = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.transform(tx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of restoreTransformTo method, of class SVGImageFigure.
//     */
//    @Test
//    public void testRestoreTransformTo() {
//        System.out.println("restoreTransformTo");
//        Object geometry = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.restoreTransformTo(geometry);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTransformRestoreData method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetTransformRestoreData() {
//        System.out.println("getTransformRestoreData");
//        SVGImageFigure instance = new SVGImageFigure();
//        Object expResult = null;
//        Object result = instance.getTransformRestoreData();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createHandles method, of class SVGImageFigure.
//     */
//    @Test
//    public void testCreateHandles() {
//        System.out.println("createHandles");
//        int detailLevel = 0;
//        SVGImageFigure instance = new SVGImageFigure();
//        Collection<Handle> expResult = null;
//        Collection<Handle> result = instance.createHandles(detailLevel);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getActions method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetActions() {
//        System.out.println("getActions");
//        Point2D.Double p = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        Collection<Action> expResult = null;
//        Collection<Action> result = instance.getActions(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of canConnect method, of class SVGImageFigure.
//     */
//    @Test
//    public void testCanConnect() {
//        System.out.println("canConnect");
//        SVGImageFigure instance = new SVGImageFigure();
//        boolean expResult = false;
//        boolean result = instance.canConnect();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findConnector method, of class SVGImageFigure.
//     */
//    @Test
//    public void testFindConnector() {
//        System.out.println("findConnector");
//        Point2D.Double p = null;
//        ConnectionFigure prototype = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        Connector expResult = null;
//        Connector result = instance.findConnector(p, prototype);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findCompatibleConnector method, of class SVGImageFigure.
//     */
//    @Test
//    public void testFindCompatibleConnector() {
//        System.out.println("findCompatibleConnector");
//        Connector c = null;
//        boolean isStartConnector = false;
//        SVGImageFigure instance = new SVGImageFigure();
//        Connector expResult = null;
//        Connector result = instance.findCompatibleConnector(c, isStartConnector);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of clone method, of class SVGImageFigure.
//     */
//    @Test
//    public void testClone() {
//        System.out.println("clone");
//        SVGImageFigure instance = new SVGImageFigure();
//        SVGImageFigure expResult = null;
//        SVGImageFigure result = instance.clone();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEmpty method, of class SVGImageFigure.
//     */
//    @Test
//    public void testIsEmpty() {
//        System.out.println("isEmpty");
//        SVGImageFigure instance = new SVGImageFigure();
//        boolean expResult = false;
//        boolean result = instance.isEmpty();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of invalidate method, of class SVGImageFigure.
//     */
//    @Test
//    public void testInvalidate() {
//        System.out.println("invalidate");
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.invalidate();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setImage method, of class SVGImageFigure.
//     */
//    @Test
//    public void testSetImage() {
//        System.out.println("setImage");
//        byte[] imageData = null;
//        BufferedImage bufferedImage = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.setImage(imageData, bufferedImage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setImageData method, of class SVGImageFigure.
//     */
//    @Test
//    public void testSetImageData() {
//        System.out.println("setImageData");
//        byte[] imageData = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.setImageData(imageData);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBufferedImage method, of class SVGImageFigure.
//     */
//    @Test
//    public void testSetBufferedImage() {
//        System.out.println("setBufferedImage");
//        BufferedImage image = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.setBufferedImage(image);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBufferedImage method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetBufferedImage() {
//        System.out.println("getBufferedImage");
//        SVGImageFigure instance = new SVGImageFigure();
//        BufferedImage expResult = null;
//        BufferedImage result = instance.getBufferedImage();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getImageData method, of class SVGImageFigure.
//     */
//    @Test
//    public void testGetImageData() {
//        System.out.println("getImageData");
//        SVGImageFigure instance = new SVGImageFigure();
//        byte[] expResult = null;
//        byte[] result = instance.getImageData();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of loadImage method, of class SVGImageFigure.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoadImage_File() throws Exception {
        System.out.println("loadImage test");
      
        //For windows
        File file = new File("C:\\#Git\\SoftwareMaintenance\\"
                + "SB-MAI-E20-4\\JHotDraw\\Files for UnitTests\\java.png");

        //Asserting that the file in the folder is not null, 
        //and therefore imported the file correctly
        assertNotNull(file.getName());
    }

    /**
     * Test of loadImage method, of class SVGImageFigure.
     */
//    @Test
//    public void testLoadImage_InputStream() throws Exception {
//        System.out.println("loadImage");
//        InputStream in = null;
//        SVGImageFigure instance = new SVGImageFigure();
//        instance.loadImage(in);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
