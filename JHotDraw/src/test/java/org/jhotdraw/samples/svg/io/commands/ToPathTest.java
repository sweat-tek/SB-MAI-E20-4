/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io.commands;

import java.awt.geom.Point2D;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.io.StreamPosTokenizer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peder
 */
public class ToPathTest {
    
    public ToPathTest() {
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
     * Test of relativeMoveto method, of class ToPath.
     */
    @Test
    public void testRelativeMoveto() throws Exception {
        System.out.println("relativeMoveto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeMoveto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteMoveto method, of class ToPath.
     */
    @Test
    public void testAbsoluteMoveto() throws Exception {
        System.out.println("absoluteMoveto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteMoveto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closePath method, of class ToPath.
     */
    @Test
    public void testClosePath() {
        System.out.println("closePath");
        Point2D.Double p = null;
        BezierPath path = null;
        ToPath.closePath(p, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteLineto method, of class ToPath.
     */
    @Test
    public void testAbsoluteLineto() throws Exception {
        System.out.println("absoluteLineto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteLineto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeLineto method, of class ToPath.
     */
    @Test
    public void testRelativeLineto() throws Exception {
        System.out.println("relativeLineto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeLineto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteHorizontalLineto method, of class ToPath.
     */
    @Test
    public void testAbsoluteHorizontalLineto() throws Exception {
        System.out.println("absoluteHorizontalLineto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteHorizontalLineto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeHorizontalLineto method, of class ToPath.
     */
    @Test
    public void testRelativeHorizontalLineto() throws Exception {
        System.out.println("relativeHorizontalLineto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeHorizontalLineto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteVerticalLineto method, of class ToPath.
     */
    @Test
    public void testAbsoluteVerticalLineto() throws Exception {
        System.out.println("absoluteVerticalLineto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteVerticalLineto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeVerticalLineto method, of class ToPath.
     */
    @Test
    public void testRelativeVerticalLineto() throws Exception {
        System.out.println("relativeVerticalLineto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeVerticalLineto(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeEllipticalArc method, of class ToPath.
     */
    @Test
    public void testRelativeEllipticalArc() throws Exception {
        System.out.println("relativeEllipticalArc");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeEllipticalArc(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteEllipticalArc method, of class ToPath.
     */
    @Test
    public void testAbsoluteEllipticalArc() throws Exception {
        System.out.println("absoluteEllipticalArc");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteEllipticalArc(streamTokenizer, str, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeShorthandQuadto method, of class ToPath.
     */
    @Test
    public void testRelativeShorthandQuadto() throws Exception {
        System.out.println("relativeShorthandQuadto");
        BezierPath path = null;
        Point2D.Double c1 = null;
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        char expResult = ' ';
        char result = ToPath.relativeShorthandQuadto(path, c1, streamTokenizer, str, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteShorthandQuadto method, of class ToPath.
     */
    @Test
    public void testAbsoluteShorthandQuadto() throws Exception {
        System.out.println("absoluteShorthandQuadto");
        BezierPath path = null;
        Point2D.Double c1 = null;
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double p = null;
        char expResult = ' ';
        char result = ToPath.absoluteShorthandQuadto(path, c1, streamTokenizer, str, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeQuadto method, of class ToPath.
     */
    @Test
    public void testRelativeQuadto() throws Exception {
        System.out.println("relativeQuadto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double c1 = null;
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeQuadto(streamTokenizer, str, c1, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteQuadto method, of class ToPath.
     */
    @Test
    public void testAbsoluteQuadto() throws Exception {
        System.out.println("absoluteQuadto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double c1 = null;
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteQuadto(streamTokenizer, str, c1, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeShorthandCurveto method, of class ToPath.
     */
    @Test
    public void testRelativeShorthandCurveto() throws Exception {
        System.out.println("relativeShorthandCurveto");
        BezierPath path = null;
        Point2D.Double c1 = null;
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double c2 = null;
        Point2D.Double p = null;
        char expResult = ' ';
        char result = ToPath.relativeShorthandCurveto(path, c1, streamTokenizer, str, c2, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteShorthandCurveto method, of class ToPath.
     */
    @Test
    public void testAbsoluteShorthandCurveto() throws Exception {
        System.out.println("absoluteShorthandCurveto");
        BezierPath path = null;
        Point2D.Double c1 = null;
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double c2 = null;
        Point2D.Double p = null;
        char expResult = ' ';
        char result = ToPath.absoluteShorthandCurveto(path, c1, streamTokenizer, str, c2, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativeCurveto method, of class ToPath.
     */
    @Test
    public void testRelativeCurveto() throws Exception {
        System.out.println("relativeCurveto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double c1 = null;
        Point2D.Double p = null;
        Point2D.Double c2 = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.relativeCurveto(streamTokenizer, str, c1, p, c2, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of absoluteCurveto method, of class ToPath.
     */
    @Test
    public void testAbsoluteCurveto() throws Exception {
        System.out.println("absoluteCurveto");
        StreamPosTokenizer streamTokenizer = null;
        String str = "";
        Point2D.Double c1 = null;
        Point2D.Double c2 = null;
        Point2D.Double p = null;
        BezierPath path = null;
        char expResult = ' ';
        char result = ToPath.absoluteCurveto(streamTokenizer, str, c1, c2, p, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
