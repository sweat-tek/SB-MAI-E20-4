/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author jonas
 */
public class When extends Stage<When> {

    @ProvidedScenarioState
    protected TextAreaCreationTool textAreaTool;
    protected FloatingTextArea textarea;
    protected TextHolderFigure textfigure;

    @ExpectedScenarioState
    protected DefaultDrawingView defaultDrawingView;

    public When I_click_on_the_drawing_view() {
        textAreaTool = new TextAreaCreationTool(new SVGTextAreaFigure());
        textAreaTool.setRubberbandColor(Color.BLACK);
        textAreaTool.setToolDoneAfterCreation(true);
        DefaultDrawingEditor editor = mock(DefaultDrawingEditor.class);
        Mockito.when(editor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(editor.findView(any())).thenReturn(defaultDrawingView);
        textAreaTool.editor = editor;
        textAreaTool.mousePressed(getMouseEvent(10, 10));
        return self();
    }

    private MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEventMock = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEventMock.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEventMock.getX()).thenReturn(x);
        Mockito.when(mouseEventMock.getY()).thenReturn(y);
        Mockito.when(mouseEventMock.getSource()).thenReturn(defaultDrawingView);
        //Mockito.when(defaultDrawingView.viewToDrawing(new Point(x,y))).thenReturn(new Point2D.Double(x,y));
        return mouseEventMock;
    }
}
