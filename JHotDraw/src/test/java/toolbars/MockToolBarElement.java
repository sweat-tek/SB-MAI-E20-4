/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbars;

import javax.swing.JPanel;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.samples.svg.gui.buttons.ToolBarElement;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Lomztein
 */
public class MockToolBarElement implements ToolBarElement {

    private String name;
    
    public MockToolBarElement (String name) {
        this.name = name;
    }
    
    @Override
    public void AddTo(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        JPopupButton button = new JPopupButton ();
        button.setName(name);
        panel.add(button);
    }
    
}
