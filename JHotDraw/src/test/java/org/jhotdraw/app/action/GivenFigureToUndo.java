/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author frederikhelth
 */
public class GivenFigureToUndo extends Stage<GivenFigureToUndo> {

    @ProvidedScenarioState
    private DrawingView drawingView;
    @ProvidedScenarioState
    private BezierFigure bezierFigure;
    @ProvidedScenarioState
    private DrawingEditor drawingEditor;

    @BeforeStage
    private void before() {
        
        bezierFigure = new BezierFigure();
        drawingEditor = new DefaultDrawingEditor();
        drawingView = new DefaultDrawingView();
        drawingView.setDrawing(new DefaultDrawing());
        drawingEditor.setActiveView(drawingView);
        
    }

    public GivenFigureToUndo anFigure() {
        drawingView.getDrawing().add(bezierFigure);
        assertTrue(drawingView.getDrawing().contains(bezierFigure));
        assertEquals(1, drawingView.getDrawing().getChildCount());
        return this;
    }
}