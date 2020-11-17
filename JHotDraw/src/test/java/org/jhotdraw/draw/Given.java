/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author jonas
 */
public class Given extends Stage<Given> {

    @ProvidedScenarioState
    protected DefaultDrawingView defaultDrawingView;  
    
    public Given a_drawing_view() {
        
        defaultDrawingView = new DefaultDrawingView();
        DefaultDrawing drawing = mock(DefaultDrawing.class);
        Mockito.when(drawing.findFigureInside(any())).thenReturn(new SVGTextAreaFigure());
        Mockito.when(drawing.getDrawingArea()).thenReturn(new Rectangle2D.Double(10,10,10,10));
        defaultDrawingView.setDrawing(drawing);
       
        return self();
    }
    
    
    
    
}

