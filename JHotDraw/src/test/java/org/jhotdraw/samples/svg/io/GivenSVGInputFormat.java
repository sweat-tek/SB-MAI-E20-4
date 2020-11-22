/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.mockito.Mockito;

/**
 *
 * @author Peder
 */
public class GivenSVGInputFormat extends Stage<GivenSVGInputFormat>{
    
    @ProvidedScenarioState
    protected SVGInputFormat component;
    
    public GivenSVGInputFormat svg_format(){
        component = Mockito.spy(SVGInputFormat.class);
        return self();
    }
}
