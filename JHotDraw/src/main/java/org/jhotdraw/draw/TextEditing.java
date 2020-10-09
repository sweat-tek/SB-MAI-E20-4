/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author birke
 */
public class TextEditing {
    private UndoableEdit edit;

    public TextEditing() {

    }
    
    public AbstractUndoableEdit undoRedo(TextHolderFigure editedFigure, String oldText, String newText) {
        edit = new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getString("attribute.text.text");
            }

            @Override
            public void undo() {
                super.undo();
                editedFigure.willChange();
                editedFigure.setText(oldText);
                editedFigure.changed();
            }

            @Override
            public void redo() {
                super.redo();
                editedFigure.willChange();
                editedFigure.setText(newText);
                editedFigure.changed();
            }
        };
        return (AbstractUndoableEdit) this.edit;
    }
}
