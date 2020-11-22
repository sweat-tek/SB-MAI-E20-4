/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Component;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author jonas
 */
public class Then extends Stage<Then> {
    
    @ExpectedScenarioState
    protected DefaultDrawingView defaultDrawingView;
    
    public Then I_can_see_textbox() {
        Component component = defaultDrawingView.getComponent(0);
        assertThat(component).isNotNull();
        return self();
    }
}
