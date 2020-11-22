/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import java.util.LinkedList;
import org.jhotdraw.draw.Figure;

/**
 *
 * @author Peder
 */
public class ThenIHaveAListOfFigures extends Stage<ThenIHaveAListOfFigures> {
    @ExpectedScenarioState
    protected SVGInputFormat component;
    
    @ScenarioState
    LinkedList<Figure> figures;
    
    public ThenIHaveAListOfFigures i_have_a_list_of_figures(){
        
        for(Figure f : figures){
            assert f instanceof Figure;
        }
        return self();
    }
}
