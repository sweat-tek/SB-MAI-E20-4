/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Patrick
 */
class ThenAllSelected extends Stage<ThenAllSelected> {
    
    @ExpectedScenarioState
    private DefaultDrawingView dv;
    
    ThenAllSelected allAreSelected() {
        
        assertEquals(2, dv.getSelectionCount());
        return this;
    }
}
