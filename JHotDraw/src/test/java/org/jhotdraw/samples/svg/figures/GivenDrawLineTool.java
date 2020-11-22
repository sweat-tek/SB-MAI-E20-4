/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import org.mockito.Mockito;

/**
 *
 * @author Unbreakable
 */
public class GivenDrawLineTool extends Stage<GivenDrawLineTool> {

    @ProvidedScenarioState
    protected SVGPathFigure component;
    
    @ProvidedScenarioState
    protected Color color;

    public GivenDrawLineTool a_SVGPathFigure() {
        component = Mockito.spy(SVGPathFigure.class);
        return self();
    }
    
    public GivenDrawLineTool a_stroke_Color(Color color){
        this.color = color;
        return self();
    }
}
