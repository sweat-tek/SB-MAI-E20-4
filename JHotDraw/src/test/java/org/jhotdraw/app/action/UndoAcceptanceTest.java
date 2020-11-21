/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author frederikhelth
 */
public class UndoAcceptanceTest extends ScenarioTest<GivenFigureToUndo, WhenOnUndo, ThenFigureIsUndone>{
    
    @Test
    public void undoTest() {
        given().anFigure();
        when().undoFigure();
        then().figureIsUndone();
    }
    
}
