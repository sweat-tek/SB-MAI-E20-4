/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import javax.swing.AbstractAction;
import javax.swing.text.JTextComponent;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Patrick
 */
public abstract class AbstractSelectionAction extends AbstractAction {

    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
    EditableComponent ec = null;
    JTextComponent tc = null;
    
    protected void selectAll() {
        getFocusOwner();
        if (ec != null) {
            ec.selectAll();
        } else {
            tc.selectAll();
        }
    }
    
    protected void clearSelection() {
        getFocusOwner();
        if (ec != null) {
            ec.clearSelection();
        } else {
            tc.select(tc.getSelectionStart(), tc.getSelectionStart());
        }
    }

    public void getFocusOwner() {
        Component focusOwner = KeyboardFocusManager.
                getCurrentKeyboardFocusManager().
                getPermanentFocusOwner();

        if (focusOwner != null) {
            if (focusOwner instanceof EditableComponent) {
                ec = ((EditableComponent) focusOwner);
            } else if (focusOwner instanceof JTextComponent) {
                tc = ((JTextComponent) focusOwner);
            } else {
                focusOwner.getToolkit().beep();
            }
        }
    }
}
