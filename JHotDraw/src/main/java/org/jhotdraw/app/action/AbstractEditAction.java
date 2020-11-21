/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.util.Optional;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.app.JHotDrawFeatures;
import static org.jhotdraw.app.action.CopyAction.ID;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author madsfalken
 */
public abstract class AbstractEditAction extends AbstractAction {
    
    public AbstractEditAction(String ID) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
    
    public Component getComponent() {
        return Optional.ofNullable(KeyboardFocusManager.
                getCurrentKeyboardFocusManager().
                getPermanentFocusOwner()).map(focusOwner -> { return (Component) focusOwner; }).orElse(null);
    }
    
    public JComponent getJComponent(Component component) {
        return Optional.ofNullable(component).map(com -> { return (JComponent) com; }).orElse(null);
    }
    
    @FeatureEntryPoint(JHotDrawFeatures.BASIC_EDITING)
    protected final void onActionPerformed(ActionEvent event) {
        Component component = getComponent();
        if (component != null) {
            onActionPerformed(event, component);
        }
    }

    protected abstract void onActionPerformed(ActionEvent event, Component component);
}
