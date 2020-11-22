/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.buttons;

import javax.swing.JPanel;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 * 
 * This could have been implemented with a composite pattern, however I decided
 * against it, in order to more strongly define that a toolbar is a collection
 * of buttons. It should be quite straight forward to refactor to composite,
 * should the demand ever rise.
 */
public class CompositeToolBarElement implements ToolBarElement {

    public CompositeToolBarElement (ToolBarElement... buttons) {
        this.buttons = buttons;
    }
    
    private ToolBarElement[] buttons;

    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        for (ToolBarElement butt : buttons) {
            butt.AddTo(editor, panel, labels);
        }
    }

}
