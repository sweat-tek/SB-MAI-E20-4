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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.imageio.ImageIO;
import javax.swing.Action;

import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author frede
 */
public class SVGImageFigureTest {
    SVGImageFigure svgImageFigure;

    public SVGImageFigureTest() {
      svgImageFigure = new SVGImageFigure();
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
     * Test of loadImage method, of class SVGImageFigure.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testLoadImage_File() throws Exception {
        System.out.println("loadImage_File unitTest");
        File file = new File("src\\FilesForUnitTests\\java.png");
        svgImageFigure.loadImage(file);

        //Asserting that the imagedata in SVGImageFigure is not null,
        //and therefore read the file correctly
        assertNotNull(svgImageFigure.getImageData());
    }

    /**
     * Test of loadImage method, of class SVGImageFigure.
     */
    @Test
    public void testLoadImage_InputStream() throws Exception {

        System.out.println("loadImage_InputStream unitTest");
        File file = new File("src\\FilesForUnitTests\\java.png");
        InputStream inputStream = new FileInputStream(file);
        svgImageFigure.loadImage(inputStream);

        //Asserting that the BufferedImage is not null, 
        //and therefore read the data from the file correctly
        assertNotNull(svgImageFigure.getBufferedImage());
    }
}
