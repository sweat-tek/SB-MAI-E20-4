/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;

import static org.junit.Assert.assertFalse;

/**
 *
 * @author frederikhelth
 */
class WhenOnUndo extends Stage<WhenOnUndo>{
    
    @ExpectedScenarioState
    private DrawingView drawingView;
    @ExpectedScenarioState
    private BezierFigure bezierFigure;
    @ExpectedScenarioState
    private DrawingEditor drawingEditor;
    @ProvidedScenarioState
    private BezierTool bezierTool;

    @BeforeStage
    public void before() {
        bezierTool = new BezierTool(bezierFigure);
        bezierTool.activate(drawingEditor);
    }
    
    // Made fireUndoEvent public
    public WhenOnUndo undoFigure() {
        bezierTool.fireUndoEvent(bezierFigure, drawingView);
        assertFalse(drawingView.getDrawing().contains(bezierFigure));
        return this;
    }
    
}