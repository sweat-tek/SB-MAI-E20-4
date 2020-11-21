/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author birke
 */
public class GivenTextFigure extends Stage<GivenTextFigure> {
    @ProvidedScenarioState
    private TextEditingTool tool;  
    
    private DefaultDrawingEditor defaultDrawingEditor;
    private SVGTextFigure textHolder;
    private DefaultDrawingView defaultDrawingView;

    private int x = 50;
    private int y = 50;
    private Drawing drawing;

    public GivenTextFigure aTextField() {
        MockSetup();
        tool.mousePressed(getMouseEvent(x,y));
        return this;
    }
    
    private void MockSetup() {
        textHolder = new SVGTextFigure("HELLO");

        tool = new TextEditingTool(textHolder);
        
        defaultDrawingEditor = Mockito.mock(DefaultDrawingEditor.class);
        defaultDrawingView = Mockito.mock(DefaultDrawingView.class);
        drawing = Mockito.mock(DefaultDrawing.class);
        
        Mockito.when(defaultDrawingEditor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingEditor.findView(defaultDrawingView)).thenReturn(defaultDrawingView);      
        Mockito.when(defaultDrawingView.drawingToView(any(Rectangle2D.Double.class))).thenReturn(new Rectangle(x, y, 10, 10));
        Mockito.when(defaultDrawingView.drawingToView(any(Point2D.Double.class))).thenReturn(new Point(x, y));
        Mockito.when(defaultDrawingView.getDrawing()).thenReturn(drawing);
        Mockito.when(defaultDrawingView.getComponent()).thenReturn(defaultDrawingView);
        tool.activate(defaultDrawingEditor);
        Mockito.when(tool.getDrawing()).thenReturn(drawing);
        Mockito.when(tool.getView()).thenReturn(defaultDrawingView);
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
