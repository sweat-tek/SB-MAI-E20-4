/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
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
    /*@Test
    public void testActionPerformed() {
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            JTextField component = new JTextField("Hello is it me you're looking for?");
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(component);

            ActionEvent evt = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.selectAll");
            CopyAction instance = new CopyAction();
            instance.actionPerformed(evt);

            component.setCaretPosition(component.getText().length());
            ActionEvent pasteEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.paste");
            PasteAction pasteAction = new PasteAction();
            pasteAction.actionPerformed(pasteEvent);

            assertEquals(component.getText(), "Hello is it me you're looking for?Hello is it me you're looking for?");
        }
    }*/

    /**
     * Test of onActionPerformed method, of class CopyAction.
     */
    @Test
    public void testOnActionPerformed() {
        JTextField component = spy(JTextField.class);
        component.setText("Hello is it me you're looking for?");
        Clipboard clipboard = mock(Clipboard.class);
        Toolkit toolkit = spy(Toolkit.class);
        doCallRealMethod().when(clipboard).setContents(any(), any());
        when(component.getToolkit()).thenReturn(toolkit);
        when(component.getToolkit().getSystemClipboard()).thenReturn(clipboard);
        Transferable transferable = new StringSelection(component.getText());
        when(component.getToolkit().getSystemClipboard().getContents(component)).thenReturn(transferable);
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
        assert component.getText().length() > 34;
    }
    
}
