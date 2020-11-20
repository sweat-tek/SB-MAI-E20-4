/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author mathias
 */
public class GroupActionTest {
    
    public GroupActionTest() {
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

    /**
     * Test of updateEnabledState method, of class GroupAction.
     */
    @Test
    public void testUpdateEnabledState() {
        System.out.println("updateEnabledState");
        GroupAction instance = Mockito.mock(GroupAction.class);
        instance.updateEnabledState();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of canGroup method, of class GroupAction.
     */
    @Test
    public void testCanGroup() {
        System.out.println("canGroup");
        GroupAction instance = Mockito.mock(GroupAction.class);
        boolean expResult = false;
        boolean result = instance.canGroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of canUngroup method, of class GroupAction.
     */
    @Test
    public void testCanUngroup() {
        System.out.println("canUngroup");
        GroupAction instance = Mockito.mock(GroupAction.class);
        boolean expResult = false;
        boolean result = instance.canUngroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class GroupAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = Mockito.mock(java.awt.event.ActionEvent.class);
        GroupAction instance = Mockito.mock(GroupAction.class);
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of groupFigures method, of class GroupAction.
     */
    @Test
    public void testGroupFigures() {
        System.out.println("groupFigures");
        DrawingEditor editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();//Mockito.mock(DrawingView.class);
        editor.setActiveView(view);
        view.setDrawing(new QuadTreeDrawing());
        CompositeFigure group = new SVGGroupFigure();
        
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().addToSelection(f3);
        
        Set<Figure> expectedGroup = new HashSet<>(editor.getActiveView().getSelectedFigures());
        
        Collection<Figure> figures = new LinkedList<Figure>(editor.getActiveView().getSelectedFigures());
        System.out.println("figures: " + view.getDrawing().getChildren().toString());
        GroupAction instance = new GroupAction(editor); //Mockito.mock(GroupAction.class);
        instance.groupFigures(view, group, figures);
        //instance.getDrawing().getChildren();
        
        Collection<Figure> testFigures = view.getSelectedFigures();
        System.out.println("test: " + editor.getActiveView().getDrawing());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }

/*
        Figure ellipse = new SVGEllipseFigure(10, 10, 15, 20);
        Figure square = new SVGRectFigure(20, 17, 30, 30);
        Figure rect = new SVGRectFigure(0, 17, 20, 35);
        view.addToSelection(ellipse);
        view.addToSelection(square);
        view.addToSelection(rect);
 */
    
}
