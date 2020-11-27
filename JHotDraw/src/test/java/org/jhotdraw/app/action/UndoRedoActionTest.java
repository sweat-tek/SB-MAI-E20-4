/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextField;
import org.jhotdraw.app.AbstractView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.undo.CompositeEdit;
import org.jhotdraw.undo.UndoRedoManager;
import org.jhotdraw.util.ResourceBundleUtil;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author frederikhelth
 */
public class UndoRedoActionTest {
    
    private UndoAction undoAction;
    private DefaultDrawing defaultDrawing;
    private BezierFigure bezierFigure;
    
    @Mock
    private Application app;
    
    public UndoRedoActionTest() {
    }
   
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        undoAction = new UndoAction(app);
                
        defaultDrawing = new DefaultDrawing();
        bezierFigure = new BezierFigure();
        // Add 3 figures to DefaultDrawing
        defaultDrawing.add(bezierFigure);
        defaultDrawing.add(bezierFigure);
        defaultDrawing.add(bezierFigure);
        
        assertEquals(3, defaultDrawing.getChildCount());
        
    }
    
    //Removes a figure at latest index, and remove one more.
    @Test
    public void undoTest() {
        
        int latestIndex = defaultDrawing.getChildren().lastIndexOf(bezierFigure);
        BezierFigure latest = (BezierFigure) defaultDrawing.getChild(latestIndex);
        defaultDrawing.remove(latest);
        assertEquals(2, defaultDrawing.getChildCount());

        BezierFigure currentFigure = (BezierFigure) defaultDrawing.getChild(latestIndex - 1);
        defaultDrawing.remove(currentFigure);
        
        assertEquals(1, defaultDrawing.getChildCount());
    }
    
    
    // Removes a figure and adds the figure again.
    @Test
    public void redoTest() {
        
        int latestIndex = defaultDrawing.getChildren().lastIndexOf(bezierFigure);
        BezierFigure latestFigure = (BezierFigure) defaultDrawing.getChild(latestIndex);
        defaultDrawing.remove(latestFigure);
        
        assertEquals(2, defaultDrawing.getChildCount());
        defaultDrawing.add(latestFigure);
        
        assertEquals(3, defaultDrawing.getChildCount());
    }
    
    @After
    public void tearDown() {
        bezierFigure = null;
        defaultDrawing = null;
    }
    
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        CopyAction instance = new CopyAction();
        instance.actionPerformed(e);
    }
    
    
    
    /*
    ** First redo test using Mock.
    */
    @Test
    public void firstRedoTest() throws InterruptedException{
        
        JTextField component = new JTextField("Hello is it me you're looking for?");
        component.grabFocus();
        component.selectAll();
        
        ActionEvent Copyevent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.copy");
        CopyAction instance = new CopyAction();
        instance.actionPerformed(Copyevent);
        
        component.setCaretPosition(component.getText().length());
        ActionEvent pasteEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.paste");
        PasteAction pasteAction = new PasteAction();
        pasteAction.actionPerformed(pasteEvent);
        System.out.println(component.getText());
        
        Application app = mock(Application.class);
        AbstractView view = mock(AbstractView.class);
        
        when(app.getActiveView()).thenReturn(view);
        
        ActionEvent undoEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.undo");
        UndoAction undoAction = new UndoAction(app);
        undoAction.actionPerformed(undoEvent);
        
        
        System.out.println(component.getText());
        assertEquals(component.getText(), "Hello is it me you're looking for?");
    }
    
    
}
