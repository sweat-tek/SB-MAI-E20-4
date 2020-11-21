/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author birke
 */
public class ThenTextEdited extends Stage<ThenTextEdited> {
    @ExpectedScenarioState
    protected TextEditingTool tool;
    @ExpectedScenarioState
    protected TextHolderFigure newText;

    
    public ThenTextEdited edited() {
        assertEquals(tool.getTypingTarget().getText(), newText.getText());
        assertTrue(tool != null);
        assertTrue(tool.getTypingTarget() != null);
        
        return this;
    }
}
