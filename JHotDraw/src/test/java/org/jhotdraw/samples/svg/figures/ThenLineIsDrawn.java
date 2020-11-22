/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;

/**
 *
 * @author Unbreakable
 */
public class ThenLineIsDrawn extends Stage<ThenLineIsDrawn> {
    
    @ExpectedScenarioState
    SVGPathFigure svgPathFigure;
    
    @ExpectedScenarioState
    Color color;
    
    public ThenLineIsDrawn SVGPathFigure_is_chosen_color(){
        assert svgPathFigure.getAttribute(AttributeKeys.STROKE_COLOR).equals(color);
        return self();
    }
}
