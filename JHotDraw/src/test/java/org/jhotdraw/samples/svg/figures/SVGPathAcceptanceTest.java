/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Color;
import org.junit.Test;

/**
 *
 * @author Unbreakable
 */
public class SVGPathAcceptanceTest extends ScenarioTest<GivenDrawLineTool, WhenAttributeIsSetOnPathFigure, ThenLineIsDrawn> {

    @Test
    public void testDrawLine() {
        given().a_SVGPathFigure().and().a_stroke_Color(Color.yellow);
        when().setting_color_attribute_of_SVGPathFigure();
        then().SVGPathFigure_is_chosen_color();
    }
}
