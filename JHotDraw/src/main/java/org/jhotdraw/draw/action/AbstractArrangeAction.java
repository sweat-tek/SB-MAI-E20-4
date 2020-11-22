/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import static org.jhotdraw.draw.action.BringToFrontAction.ID;

/**
 *
 * @author itsmebenpax
 */
public abstract class AbstractArrangeAction extends AbstractSelectedAction {

    public AbstractArrangeAction(DrawingEditor editor) {
        super(editor);
    }
    
    protected void bringToFront(DrawingView view, Collection<Figure> figures) {
        Drawing drawing = view.getDrawing();
        Iterator i = drawing.sort(figures).iterator();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            drawing.bringToFront(figure);
        }
    }
    
    protected void sendToBack(DrawingView view, Collection figures) {
        Iterator i = figures.iterator();
        Drawing drawing = view.getDrawing();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            drawing.sendToBack(figure);
        }
    }
    
    protected void setUndoRedoAction(
            DrawingView view, LinkedList<Figure> figures,
            Runnable undo, Runnable redo
    ) {
        
        fireUndoableEditHappened(new AbstractUndoableEdit() {
            
            @Override
            public String getPresentationName() {
                return labels.getTextProperty(ID);
            }
            
            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                redo.run();
            }
            
            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                undo.run();
                
            }
            
        });
    }
    
}
