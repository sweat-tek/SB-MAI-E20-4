/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        ActionEvent Copyevent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.copy");
        CopyAction instance = new CopyAction();
        instance.onActionPerformed(Copyevent, component);
        
        component.setCaretPosition(component.getText().length());
        ActionEvent pasteEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.paste");
        PasteAction pasteAction = new PasteAction();
        pasteAction.onActionPerformed(pasteEvent, component);
        
        assertEquals(component.getText(), "Hello is it me you're looking for?Hello is it me you're looking for?");
    }
    
}
