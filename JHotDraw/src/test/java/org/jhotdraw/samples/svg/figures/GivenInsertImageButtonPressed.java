package org.jhotdraw.samples.svg.figures;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.io.File;

import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.ImageHolderFigure;
import org.jhotdraw.samples.svg.SVGCreateFromFileTool;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static com.tngtech.jgiven.impl.util.AssertionUtil.assertNotNull;

/**
 * @author frede
 */
public class GivenInsertImageButtonPressed extends Stage<GivenInsertImageButtonPressed>{
    @ProvidedScenarioState
    SVGImageFigure svgImageFigure;
    @ProvidedScenarioState
    SVGCreateFromFileTool createFromFileTool;
    @ProvidedScenarioState
    File file = new File("src\\FilesForUnitTests\\java.png");
    @ProvidedScenarioState
    DrawingEditor drawingEditor;



    public GivenInsertImageButtonPressed givenInsertImageButtonPressed() {
        initializeMockito();
        assertNotNull(createFromFileTool);
        assertNotNull(drawingEditor);
        createFromFileTool.activate(drawingEditor);
        return GivenInsertImageButtonPressed.this;
    }

    public void initializeMockito() {
        createFromFileTool = Mockito.mock(SVGCreateFromFileTool.class);
        drawingEditor = Mockito.mock(DefaultDrawingEditor.class);

        Mockito.doAnswer(invocationOnMock -> {
            svgImageFigure = new SVGImageFigure();
            return 0;
        }).when(createFromFileTool).activate(drawingEditor);

    }
}
