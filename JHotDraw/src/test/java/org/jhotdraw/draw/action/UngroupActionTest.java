/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.event.ActionEvent;
import java.util.Collection;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathias
 */
public class UngroupActionTest {
    
    public UngroupActionTest() {
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
     * Test of actionPerformed method, of class UngroupAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        UngroupAction instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ungroupFigures method, of class UngroupAction.
     */
    @Test
    public void testUngroupFigures() {
        System.out.println("ungroupFigures");
        DrawingView view = null;
        CompositeFigure group = null;
        UngroupAction instance = null;
        Collection<Figure> expResult = null;
        Collection<Figure> result = instance.ungroupFigures(view, group);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
