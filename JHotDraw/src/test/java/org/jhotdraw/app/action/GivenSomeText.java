/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.JTextField;
import org.mockito.Mockito;

/**
 *
 * @author madsfalken
 */
public class GivenSomeText extends Stage<GivenSomeText> {
    
    @ProvidedScenarioState    
    protected JTextField component;
    
    public GivenSomeText some_text(String text) {
        component = Mockito.spy(JTextField.class);
        component.setText(text);
        return self();
    }

}
