/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;

/**
 *
 * @author Unbreakable
 */
public class WhenAttributeIsSetOnPathFigure extends Stage<WhenAttributeIsSetOnPathFigure>{
    
    @ExpectedScenarioState
    SVGPathFigure svgPathFigure;
    
    @ExpectedScenarioState
    Color color;
    
    
    public WhenAttributeIsSetOnPathFigure setting_color_attribute_of_SVGPathFigure(){
        svgPathFigure.setAttribute(AttributeKeys.STROKE_COLOR, color);
        return self();
    }
}
