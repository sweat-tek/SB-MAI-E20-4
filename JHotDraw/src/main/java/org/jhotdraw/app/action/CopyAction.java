/*
 * @(#)CopyAction.java  2.0  2007-04-13
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
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
import java.util.Optional;
import javax.swing.*;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.util.*;
/**
 * Copies the selected region and place its contents into the system clipboard.
 * Acts on the EditableComponent or JTextComponent which had the focus when
 * the ActionEvent was generated.
 *
 * @author Werner Randelshofer
 * @version 2.0 2007-04-13 Use javax.swing.TransferHandler instead of 
 * interface EditableComponent. 
 * <br>1.0 October 9, 2005 Created.
 */
public class CopyAction extends AbstractEditAction {
    public final static String ID = "edit.copy";
    
    /** Creates a new instance. */
    public CopyAction() {
        super(ID);
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        super.onActionPerformed(e);
    }

    @Override
    protected void onActionPerformed(ActionEvent event, Component focusOwner) {
        if (focusOwner != null && focusOwner instanceof JComponent) {
            JComponent component = (JComponent) focusOwner;
            component.getTransferHandler().exportToClipboard(
                    component,
                    component.getToolkit().getSystemClipboard(),
                    TransferHandler.COPY
                );
        }
    }
}
