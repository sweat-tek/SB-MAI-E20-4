/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author birke
 */
public class TextToolAcceptanceTest extends ScenarioTest<GivenTextFigure, WhenTextEdit, ThenTextEdited> {

    @Test
    public void isEditedTest() {
        given().aTextField();
        when().edit();
        then().edited();
    }
}
