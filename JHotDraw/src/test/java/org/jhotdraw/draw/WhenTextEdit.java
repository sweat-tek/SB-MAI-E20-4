/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

/**
 *
 * @author birke
 */
public class WhenTextEdit extends Stage<WhenTextEdit> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    protected TextEditingTool tool;
    @ProvidedScenarioState
    protected TextHolderFigure newText;
    
    @ExpectedScenarioState
    protected DrawingView defaultDrawingView;
    
    
    public WhenTextEdit edit() {
        newText = new SVGTextFigure("New");

        tool.beginEdit(newText);
        
        return this;
    }
}
