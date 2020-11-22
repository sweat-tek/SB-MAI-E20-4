/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.buttons;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 */
public class StrokeDashesToolBarElement implements ToolBarElement {

    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        AbstractButton btn = ButtonFactory.createStrokeDashesButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 3, 0, 0);
        panel.add(btn, gbc);
    }

}
