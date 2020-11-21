/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;

/**
 *
 * @author madsfalken
 */
public class ThenICanCopyAndPaste extends Stage<ThenICanCopyAndPaste> {
    
    @ExpectedScenarioState    
    protected JTextField component;
    
    public ThenICanCopyAndPaste I_can_copy_and_paste() {
        Clipboard clipboard = Mockito.mock(Clipboard.class);
        Toolkit toolkit = Mockito.spy(Toolkit.class);
        Mockito.doCallRealMethod().when(clipboard).setContents(any(), any());
        Mockito.when(component.getToolkit()).thenReturn(toolkit);
        Mockito.when(component.getToolkit().getSystemClipboard()).thenReturn(clipboard);
        Transferable transferable = new StringSelection(component.getText());
        Mockito.when(component.getToolkit().getSystemClipboard().getContents(component)).thenReturn(transferable);

        ActionEvent Copyevent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.copy");
        CopyAction copyAction = new CopyAction();
        copyAction.onActionPerformed(Copyevent, component);
        
        component.setCaretPosition(component.getText().length());
        ActionEvent pasteEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.paste");
        PasteAction pasteAction = new PasteAction();
        pasteAction.onActionPerformed(pasteEvent, component);
        
        assertEquals(component.getText(), "Hello is it me you're looking for!Hello is it me you're looking for!");
        assert component.getText().length() > 34;
        
        return self();

    }
}
