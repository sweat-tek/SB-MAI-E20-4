/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;



/**
 *
 * @author Patrick
 */

public class SelectAllActionTest {
    
    DefaultDrawingView dv;
    LineFigure lf;
    BezierFigure bf;
    
    public SelectAllActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dv = new DefaultDrawingView();
        dv.setDrawing(new QuadTreeDrawing());
        
        lf = new LineFigure();
        bf = new BezierFigure();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class SelectAllAction.
     */
    @Test
    public void testActionPerformed() {
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(dv);
            
            dv.getDrawing().add(lf);
            dv.getDrawing().add(bf);

            ActionEvent evt = new ActionEvent(dv, ActionEvent.ACTION_PERFORMED, "edit.selectAll");
            SelectAllAction instance = new SelectAllAction();
            instance.actionPerformed(evt);

            System.out.println(dv.getSelectedFigures().size());
            assert dv.getSelectedFigures().size() > 0;
            assertEquals(2, dv.getSelectionCount());
        }   
    }
}