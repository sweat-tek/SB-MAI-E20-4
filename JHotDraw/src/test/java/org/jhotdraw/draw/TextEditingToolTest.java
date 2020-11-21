/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author birke
 */
public class TextEditingToolTest {
    private DefaultDrawingView defaultDrawingView;
    private DefaultDrawingEditor defaultDrawingEditor;
    private Drawing drawing;
    private TextEditingTool tool;
    private int x = 50;
    private int y = 50;
    private SVGTextFigure textHolder;
    
    public TextEditingToolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    private void MockSetup() {
        textHolder = new SVGTextFigure("HELLO");

        tool = new TextEditingTool(textHolder);
        
        defaultDrawingEditor = Mockito.mock(DefaultDrawingEditor.class);
        defaultDrawingView = Mockito.mock(DefaultDrawingView.class);
        drawing = Mockito.mock(DefaultDrawing.class);
        
        Mockito.when(defaultDrawingEditor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingEditor.findView(defaultDrawingView)).thenReturn(defaultDrawingView);      
        when(defaultDrawingView.drawingToView(any(Rectangle2D.Double.class))).thenReturn(new Rectangle(x, y, 10, 10));
        when(defaultDrawingView.drawingToView(any(Point2D.Double.class))).thenReturn(new Point(x, y));

        Mockito.when(defaultDrawingView.getDrawing()).thenReturn(drawing);
        Mockito.when(defaultDrawingView.getComponent()).thenReturn(defaultDrawingView);
        tool.activate(defaultDrawingEditor);
        Mockito.when(tool.getDrawing()).thenReturn(drawing);
        Mockito.when(tool.getView()).thenReturn(defaultDrawingView);
    }
    
    /**
     * Test of beginEdit and endEdit method, of class TextEditingTool.
     */
    @Test
    public void testEdit() {
        MockSetup();
        
        TextHolderFigure newText = new SVGTextFigure("New");

        givenMousePressed();
        
        tool.beginEdit(newText);
 
        assertEquals(tool.getTypingTarget().getText(), newText.getText());
        assertTrue(true);
    }
    
    private void givenMousePressed() {
        tool.mousePressed(getMouseEvent(x, y));
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
