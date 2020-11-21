package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.junit.Assert.assertNotNull;

public class ThenImageFigureCreated extends Stage<ThenImageFigureCreated> {

    @ExpectedScenarioState
    SVGImageFigure svgImageFigure;

    public ThenImageFigureCreated thenImageFigureCreated() {

        assertNotNull(svgImageFigure.getBufferedImage().getData());
        assertNotNull(svgImageFigure.getImageData());

        return this;
    }

}
