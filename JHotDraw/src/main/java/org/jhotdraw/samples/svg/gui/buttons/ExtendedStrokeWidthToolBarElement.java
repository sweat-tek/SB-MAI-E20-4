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
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.text.JavaNumberFormatter;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 */
public class ExtendedStrokeWidthToolBarElement implements ToolBarElement {

    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        // Create stroke width field with popup slider
        JAttributeTextField<Double> strokeWidthField = new JAttributeTextField<Double>();
        strokeWidthField.setColumns(2);
        strokeWidthField.setToolTipText(labels.getString("attribute.strokeWidth.toolTipText"));
        strokeWidthField.setHorizontalAlignment(JAttributeTextField.LEFT);
        strokeWidthField.putClientProperty("Palette.Component.segmentPosition", "first");
        strokeWidthField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(strokeWidthField));
        strokeWidthField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 100d, 1d));
        new FigureAttributeEditorHandler<Double>(STROKE_WIDTH, strokeWidthField, editor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(strokeWidthField, gbc);

        JPopupButton strokeWidthPopupButton = new JPopupButton();
        JAttributeSlider strokeWidthSlider = new JAttributeSlider(
                JSlider.VERTICAL, 0, 50, 1);
        strokeWidthSlider.setUI((SliderUI) PaletteSliderUI.createUI(strokeWidthSlider));
        strokeWidthPopupButton.add(strokeWidthSlider);
        labels.configureToolBarButton(strokeWidthPopupButton, "attribute.strokeWidth");
        strokeWidthPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(strokeWidthPopupButton));
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(strokeWidthPopupButton, gbc);
        new FigureAttributeEditorHandler<Double>(STROKE_WIDTH, strokeWidthSlider, editor);
    }
}
