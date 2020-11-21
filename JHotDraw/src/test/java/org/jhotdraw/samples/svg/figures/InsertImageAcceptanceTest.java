package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.impl.Scenario;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class InsertImageAcceptanceTest extends ScenarioTest<GivenInsertImageButtonPressed, WhenImageCreated, ThenImageFigureCreated> {


    @Test
    public void testIfImageCreated() {
        given().givenInsertImageButtonPressed();
        when().whenImageCreated();
        then().thenImageFigureCreated();

    }
}
