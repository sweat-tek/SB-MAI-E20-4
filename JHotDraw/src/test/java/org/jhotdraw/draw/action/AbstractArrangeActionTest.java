/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.util.ArrayList;
import java.util.List;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author BenPaxIndustries
 */
public class AbstractArrangeActionTest {
    
    // mocks
    @Mock DrawingView view;
    @Mock QuadTreeDrawing drawing;
    
    // test data
    Figure figure;
    List<Figure> selectedFigures, children;
    
    /**
     * Test of bringToFront method, of class AbstractArrangeAction.
     */
    @Test
    public void testBringToFront() {
        setup(true);
        
        AbstractArrangeAction instance = new BringToFrontAction(new DefaultDrawingEditor());
        
        assertEquals(children.get(0), figure);
        instance.bringToFront(view, children);
        assertEquals(children.get(children.size() - 1), figure);
        
        cleanUp();
    }

    /**
     * Test of sendToBack method, of class AbstractArrangeAction.
     */
    @Test
    public void testSendToBack() {
        setup(false);
        
        AbstractArrangeAction instance = new SendToBackAction(new DefaultDrawingEditor());
        
        assertEquals(children.get(children.size() - 1), figure);
        instance.sendToBack(view, children);
        assertEquals(children.get(0), figure);
        
        cleanUp();
    }
    
    private void addFigures(List<Figure> list, int num) {
        for (int i = 0; i < num; i++) {
            list.add(new SVGRectFigure());
        }
    }
    
    private void cleanUp() {
        view = null;
        drawing = null;
        figure = null;
        selectedFigures = null;
        children = null;
    }
    
    private void setup(boolean bringToFront) {
        declareMocks();
        createTestData(bringToFront);
        mockMethods();
    }
    
    private void declareMocks() {
        view = mock(DefaultDrawingView.class);
        drawing = mock(QuadTreeDrawing.class);
    }
    
    private void createTestData(boolean bringToFront) {
        figure = new SVGRectFigure();
        selectedFigures = new ArrayList<>();
        children = new ArrayList<>();
        
        addFigures(children, 5);
        
        if (bringToFront)
            children.add(0, figure);
        else
            children.add(figure);
        
        selectedFigures.add(figure);
        drawing.children = (ArrayList<Figure>) children;
    }
    
    private void mockMethods() {
        when(view.getDrawing()).thenReturn(drawing);
        when(drawing.sort(any())).thenReturn(selectedFigures);
        doCallRealMethod().when(drawing).bringToFront(figure);
        doCallRealMethod().when(drawing).sendToBack(figure);
    }
    
}
