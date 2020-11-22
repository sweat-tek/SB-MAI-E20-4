/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbars;

import javax.swing.JPanel;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.gui.buttons.CompositeToolBarElement;
import org.jhotdraw.samples.svg.gui.buttons.StrokeColorToolBarElement;
import org.jhotdraw.samples.svg.gui.buttons.ToolBarElement;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Lomztein
 * 
 * This class intends to test the CompositeToolBarElement class, to make sure
 * it does add the correct components to the panels, and the correct amount.
 */
public class CompositeToolBarElementTest {

    private static CompositeToolBarElement element;
    private static JPanel panel;
    private static DrawingEditor editor;

    private static ResourceBundleUtil labels;

    public CompositeToolBarElementTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        panel = new JPanel();
        labels = mock(ResourceBundleUtil.class);
        editor = new DefaultDrawingEditor();
    }

    @After
    public void tearDown() {
        element = null;
        panel = null;
        editor = null;
        // All should be cleaned up by GC, from what I can tell none of these are disposable
    }

    @Test
    public void testEmptyState() {
        element = new CompositeToolBarElement();
        element.AddTo(editor, panel, labels);
        assertTrue(panel.getComponentCount() == 0);
    }

    @Test
    public void testNonEmptyState() {
        panel = new JPanel();

        ToolBarElement color1 = new MockToolBarElement("");
        ToolBarElement color2 = new MockToolBarElement("");

        element = new CompositeToolBarElement(color1, color2);
        element.AddTo(editor, panel, labels);
        assertTrue(panel.getComponentCount() == 2);
    }

    @Test
    public void testCorrectLeafElement() {
        panel = new JPanel();

        ToolBarElement e0 = new MockToolBarElement("Element0");
        ToolBarElement e1 = new MockToolBarElement("Element1");

        element = new CompositeToolBarElement(e0, e1);
        element.AddTo(editor, panel, labels);

        assertTrue(panel.getComponent(0).getName().equals("Element0"));
        assertTrue(panel.getComponent(1).getName().equals("Element1"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
