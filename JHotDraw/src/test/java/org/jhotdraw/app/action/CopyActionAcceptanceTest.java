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
 * @author madsfalken
 */
public class CopyActionAcceptanceTest extends ScenarioTest<GivenSomeText, WhenISelectSomeText, ThenICanCopy> {
    
    @Test
    public void Baasic_editing_copy() {
        given().some_text("Hello is it me you're looking for!");
        when().I_select_some_text();
        then().I_can_copy();
    }

}
