/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.Figure;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Peder
 */
public class WhenIGiveSomeSVGData extends Stage<WhenIGiveSomeSVGData> {
    
    @ExpectedScenarioState
    protected SVGInputFormat component;
    
    @ScenarioState
    LinkedList<Figure> figures;
    public WhenIGiveSomeSVGData i_give_data(String svgData){
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(svgData.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WhenIGiveSomeSVGData.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean replace = false;
        Drawing drawingMock = mock(Drawing.class);
        ArgumentCaptor<LinkedList<Figure>> valueCapture = ArgumentCaptor.forClass(LinkedList.class);
        try {
            component.read(in, drawingMock, replace);
        } catch (IOException ex) {
            Logger.getLogger(WhenIGiveSomeSVGData.class.getName()).log(Level.SEVERE, null, ex);
        }
        verify(drawingMock).addAll(valueCapture.capture());
        figures = valueCapture.getValue();
        return self();
    }
}
