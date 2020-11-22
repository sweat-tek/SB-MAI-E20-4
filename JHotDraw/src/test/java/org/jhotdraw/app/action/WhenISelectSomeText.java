/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import javax.swing.JTextField;

/**
 *
 * @author madsfalken
 */
public class WhenISelectSomeText extends Stage<WhenISelectSomeText> {
    
    @ExpectedScenarioState    
    protected JTextField component;
    
    public WhenISelectSomeText I_select_some_text() {
        component.grabFocus();
        component.selectAll();
        return self();
    }
}
