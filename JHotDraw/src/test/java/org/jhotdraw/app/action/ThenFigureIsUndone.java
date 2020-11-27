/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingView;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author frederikhelth
 */
public class ThenFigureIsUndone extends Stage<ThenFigureIsUndone> {

    @ExpectedScenarioState
    private DrawingView drawingView;

    public ThenFigureIsUndone figureIsUndone() {
        assertEquals(0,drawingView.getDrawing().getChildCount());
        return this;
    }
}
