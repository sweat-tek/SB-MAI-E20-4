/*
 * @(#)SelectAllAction.java  1.0  February 27, 2006
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
import java.awt.event.*;
import org.jhotdraw.app.JHotDrawFeatures;

/**
 * SelectAllAction.
 *
 * @author Werner Randelshofer.
 * @version 1.0 February 27, 2006 Created.
 */
public class SelectAllAction extends AbstractSelectionAction {
    public final static String ID = "edit.selectAll";
    
    /** Creates a new instance. */
    public SelectAllAction() {
        labels.configureAction(this, ID);
    }

    @FeatureEntryPoint(JHotDrawFeatures.AUTOMATIC_SELECTION)
    public void actionPerformed(ActionEvent evt) {
        selectAll();
    }
}
