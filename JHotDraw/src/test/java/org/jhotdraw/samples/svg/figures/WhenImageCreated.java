package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNull;

public class WhenImageCreated extends Stage<WhenImageCreated> {
    @ExpectedScenarioState
    SVGImageFigure svgImageFigure;
    @ExpectedScenarioState
    File file;

    public WhenImageCreated whenImageCreated(){

        assertNull(svgImageFigure.getImageData());
        assertNull(svgImageFigure.getBufferedImage());

        try {
            svgImageFigure.loadImage(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.self();
    }

}
