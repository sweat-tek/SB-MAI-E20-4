/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.Component;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DefaultDrawingViewTransferHandler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author madsfalken
 */
public class CopyActionTest {
    
    public CopyActionTest() {
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
     * Test of actionPerformed method, of class CopyAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        CopyAction instance = new CopyAction();
        instance.actionPerformed(e);
    }

    /**
     * Test of onActionPerformed method, of class CopyAction.
     */
    @Test
    public void testOnActionPerformed() {
        JTextField component = new JTextField("Hello is it me you're looking for?");
        component.grabFocus();
        component.selectAll();
        ActionEvent event = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.copy");
        CopyAction instance = new CopyAction();
        instance.onActionPerformed(event, component);
        
        component.setCaretPosition(component.getText().length());
        Transferable transferable = component.getToolkit().getSystemClipboard().getContents(component);
        component.getTransferHandler().importData(component, transferable);

        assertEquals(component.getText(), "Hello is it me you're looking for?Hello is it me you're looking for?");
    }
    
}
