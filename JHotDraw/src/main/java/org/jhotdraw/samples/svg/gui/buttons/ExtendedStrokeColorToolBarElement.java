/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.buttons;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jhotdraw.draw.AttributeKey;
import static org.jhotdraw.draw.AttributeKeys.STROKE_COLOR;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.STROKE_GRADIENT;
import org.jhotdraw.text.ColorFormatter;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 */
public class ExtendedStrokeColorToolBarElement implements ToolBarElement {

    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
// Stroke color field and button
        Map<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
        STROKE_GRADIENT.set(defaultAttributes, null);
        JAttributeTextField<Color> colorField = new JAttributeTextField<Color>();
        colorField.setColumns(7);
        colorField.setToolTipText(labels.getString("attribute.strokeColor.toolTipText"));
        colorField.putClientProperty("Palette.Component.segmentPosition", "first");
        colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
        colorField.setFormatterFactory(ColorFormatter.createFormatterFactory());
        colorField.setHorizontalAlignment(JTextField.LEFT);
        new FigureAttributeEditorHandler<Color>(STROKE_COLOR, defaultAttributes, colorField, editor, true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(colorField, gbc);
        AbstractButton btn = ButtonFactory.createSelectionColorButton(editor,
                STROKE_COLOR, ButtonFactory.HSV_COLORS, ButtonFactory.HSV_COLORS_COLUMN_COUNT,
                "attribute.strokeColor", labels, defaultAttributes, new Rectangle(3, 3, 10, 10));
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        ((JPopupButton) btn).setAction(null, null);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(btn, gbc);
    }

}
