/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbars;

import javax.swing.JPanel;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.gui.GenericToolBar;
import org.jhotdraw.samples.svg.gui.buttons.CompositeToolBarElement;
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
 * The set up code is repeated from composite element tests. This may be
 * difficult to maintain and may be remedied by making use of test suites.
 */
public class GenericToolBarTest {

    private static CompositeToolBarElement element;
    private static JPanel panel;
    private static DrawingEditor editor;

    private static ResourceBundleUtil labels;
    private static GenericToolBar toolbar;

    public GenericToolBarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        toolbar = new GenericToolBar();
        toolbar.init("test", "testLabel", "org.jhotdraw.samples.svg.Labels", 1,
                new CompositeToolBarElement(),
                new CompositeToolBarElement(new MockToolBarElement("Element11"), new MockToolBarElement("Element12")),
                new CompositeToolBarElement(new MockToolBarElement("Element21"), new MockToolBarElement("Element22"), new MockToolBarElement("Element23"))
        );
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
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
    public void testStateSizes() {
        panel = (JPanel) toolbar.createComponent(0);
        assertTrue(panel.getComponentCount() == 0);

        panel = (JPanel) toolbar.createComponent(1);
        assertTrue(panel.getComponentCount() == 2);

        panel = (JPanel) toolbar.createComponent(2);
        assertTrue(panel.getComponentCount() == 3);
    }

    @Test
    public void testStateContents() {
        panel = (JPanel) toolbar.createComponent(1);
        assertTrue(panel.getComponent(0).getName().equals("Element11"));
        assertTrue(panel.getComponent(1).getName().equals("Element12"));

        panel = (JPanel) toolbar.createComponent(2);
        assertTrue(panel.getComponent(0).getName().equals("Element21"));
        assertTrue(panel.getComponent(1).getName().equals("Element22"));
        assertTrue(panel.getComponent(2).getName().equals("Element23"));
    }

    @Test
    public void testOutOfRangeState() {
        panel = (JPanel) toolbar.createComponent(3);
        assertTrue(panel.getComponentCount() == 0);
    }

    @Test
    public void testNegativeOutOfRangeState() {
        panel = (JPanel) toolbar.createComponent(-1);
        assertTrue(panel.getComponentCount() == 0);
    }
}
