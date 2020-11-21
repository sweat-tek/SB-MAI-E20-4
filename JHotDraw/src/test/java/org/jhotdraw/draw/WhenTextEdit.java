/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.mockito.Mockito;

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
    
    private MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEventMock = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEventMock.getPoint()).thenReturn(new Point(x,y));
        Mockito.when(mouseEventMock.getX()).thenReturn(x);
        Mockito.when(mouseEventMock.getY()).thenReturn(y);
        Mockito.when(mouseEventMock.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(x,y))).thenReturn(new Point2D.Double(x,y));
        return mouseEventMock;
    }
}
