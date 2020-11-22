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
 * @author jonas
 */
public class jGivenTest extends ScenarioTest<Given, When, Then> {
    
    @Test
    public void testTextAreaToolChanges(){
       given().a_drawing_view();
       when().I_click_on_the_drawing_view();
       then().I_can_see_textbox();
    }
}
