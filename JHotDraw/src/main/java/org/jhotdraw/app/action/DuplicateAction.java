/*
 * @(#)DuplicateAction.java  1.0  February 27, 2006
 *
 * Copyright (c) 1996-2006 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.app.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.beans.*;
import java.util.*;
import org.jhotdraw.util.*;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.app.JHotDrawFeatures;

/**
 * DuplicateAction.
 *
 * @author Werner Randelshofer.
 * @version 1.0 February 27, 2006 Created.
 */
public class DuplicateAction extends AbstractEditAction  {
    public final static String ID = "edit.duplicate";
    
    /** Creates a new instance. */
    public DuplicateAction() {
        super(ID);
    }

    @Override
    public void onActionPerformed(ActionEvent event, Component component) {
        Optional.ofNullable(component).ifPresent(focusOwner -> {
            if (focusOwner instanceof EditableComponent) {
                ((EditableComponent) focusOwner).duplicate();
            } else {
                focusOwner.getToolkit().beep();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.onActionPerformed(e);
    }

}
