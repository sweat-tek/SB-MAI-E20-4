/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.buttons;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.plaf.SliderUI;
import static org.jhotdraw.draw.AttributeKeys.STROKE_WIDTH;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 */
public class StrokeWidthToolBarElement implements ToolBarElement {

    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        // Create stroke width popup slider
        JPopupButton strokeWidthPopupButton = new JPopupButton();
        JAttributeSlider strokeWidthSlider = new JAttributeSlider(
                JSlider.VERTICAL, 0, 50, 1);
        strokeWidthSlider.setUI((SliderUI) PaletteSliderUI.createUI(strokeWidthSlider));
        strokeWidthPopupButton.add(strokeWidthSlider);
        labels.configureToolBarButton(strokeWidthPopupButton, "attribute.strokeWidth");
        strokeWidthPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(strokeWidthPopupButton));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(strokeWidthPopupButton, gbc);
        new FigureAttributeEditorHandler<Double>(STROKE_WIDTH, strokeWidthSlider, editor);
    }

}
