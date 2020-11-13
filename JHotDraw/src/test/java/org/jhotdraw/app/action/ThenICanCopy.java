/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author madsfalken
 */
public class ThenICanCopy extends Stage<ThenICanCopy> {
    
    @ExpectedScenarioState    
    protected JTextField component;
    
    public ThenICanCopy I_can_copy() {
        
        try {
            ActionEvent Copyevent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.copy");
            CopyAction copyAction = new CopyAction();
            copyAction.onActionPerformed(Copyevent, component);
            
            assertThat(component.getToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor)).isEqualTo("Hello is it me you're looking for!");
            
            return self();
        } catch (UnsupportedFlavorException | IOException ex) {
            Logger.getLogger(ThenICanCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return self();
    }
}
