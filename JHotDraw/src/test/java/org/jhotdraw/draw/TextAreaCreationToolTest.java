/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author jonas
 */
public class TextAreaCreationToolTest extends ScenarioTest<Given, When, Then> {
    
    public TextHolderFigure proto;
    public Graphics2D g;
    private Color rubberbandColor;
    private Figure CreatedFigure;
   
  

    public TextAreaCreationToolTest() {
       
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
     * Test of setRubberbandColor method, of class TextAreaCreationTool.
     * @param c
     */
    @Test
    public void testSetRubberbandColor() {
        System.out.println("setRubberbandColor");
        Color c = null;
        TextAreaCreationTool instance = null;
        instance.setRubberbandColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deactivate method, of class TextAreaCreationTool.
     */
    @Test
    public void testDeactivate() {
        System.out.println("deactivate");
        DrawingEditor editor = null;
        TextAreaCreationTool instance = null;
        instance.deactivate(editor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class TextAreaCreationTool.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        TextAreaCreationTool instance = null;
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creationFinished method, of class TextAreaCreationTool.
     */
    @Test
    public void testCreationFinished() {
        System.out.println("creationFinished");
        Figure createdFigure = null;
        TextAreaCreationTool instance = null;
        instance.creationFinished(createdFigure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class TextAreaCreationTool.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        TextAreaCreationTool instance = new TextAreaCreationTool(proto);
        Assert.assertNull(CreatedFigure);
        Assert.assertNull(rubberbandColor);
        instance.draw(g);
    }
        // TODO review the generated test code and remove the default call to fail.
 
    

    /**
     * Test of beginEdit method, of class TextAreaCreationTool.
     */
    @Test
    public void testBeginEdit() {
       TextHolderFigure textHolder = new SVGTextAreaFigure("HELLO");
        
        TextCreationTool instance = new TextCreationTool(textHolder);
        instance.editor = new DefaultDrawingEditor();
        DefaultDrawingView view = new DefaultDrawingView();
        instance.editor.setActiveView(view);
        
        instance.beginEdit(textHolder);
        Component component = view.getComponent(0);
        
        assertEquals(textHolder.getText(), ((JTextField)component).getText());

    }

    /**
     * Test of endEdit method, of class TextAreaCreationTool.
     */
    @Test
    public void testEndEdit() {
        System.out.println("endEdit");
        TextAreaCreationTool instance = null;
        instance.endEdit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TextAreaCreationTool.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent event = null;
        TextAreaCreationTool instance = null;
        instance.actionPerformed(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 
    
   
}
