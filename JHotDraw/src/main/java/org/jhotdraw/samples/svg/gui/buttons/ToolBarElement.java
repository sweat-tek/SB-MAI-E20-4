/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.buttons;

import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * @author Lomztein
 * 
 * This could probably be an interface instead, however I have recently been
 * trying not to over-abstract my code, as I have found that it often makes
 * it more difficult to make changes during development.
 */
public interface ToolBarElement {
    void AddTo (DrawingEditor editor, JPanel panel, ResourceBundleUtil labels);
}
