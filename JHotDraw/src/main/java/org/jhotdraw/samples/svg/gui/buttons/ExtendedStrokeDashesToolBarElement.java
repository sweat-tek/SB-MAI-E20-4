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
import static org.jhotdraw.draw.AttributeKeys.STROKE_DASH_PHASE;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.text.JavaNumberFormatter;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 */
public class ExtendedStrokeDashesToolBarElement implements ToolBarElement {

    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        // Create dash offset field and dashes button
        JAttributeTextField<Double> dashOffsetField = new JAttributeTextField<Double>();
        dashOffsetField.setColumns(1);
        dashOffsetField.setToolTipText(labels.getString("attribute.strokeDashPhase.toolTipText"));
        dashOffsetField.setHorizontalAlignment(JAttributeTextField.LEFT);
        //dashOffsetField.putClientProperty("Palette.Component.segmentPosition", "first");
        dashOffsetField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(dashOffsetField));
        dashOffsetField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(-1000d, 1000d, 1d));
        new FigureAttributeEditorHandler<Double>(STROKE_DASH_PHASE, dashOffsetField, editor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 3, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panel.add(dashOffsetField, gbc);

        AbstractButton btn = ButtonFactory.createStrokeDashesButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 3, 0, 0);
        panel.add(btn, gbc);
    }

}
