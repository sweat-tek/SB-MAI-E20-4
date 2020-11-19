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
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.QuadTreeDrawing;

/**
 *
 * @author Patrick
 */
class GivenFigures extends Stage<GivenFigures> {
    
    @ProvidedScenarioState
    private DefaultDrawingView dv;
    
    @BeforeStage
    private void before() {
        dv = new DefaultDrawingView();
        dv.setDrawing(new QuadTreeDrawing());
    }
    
    GivenFigures figuresOnDrawing() {
        dv.getDrawing().add(new LineFigure());
        dv.getDrawing().add(new BezierFigure());
        return this;
    }
}
