package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.junit.Test;

import org.jhotdraw.draw.action.AlignAction.*;

public class AlignActionAcceptanceTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    @Test
    public void TestNorthAlign() {
        given().someSelectedFigures();
        when().pressAlignNorth();
        then().figuresAlignedNorth();
    }

    @Test
    public void TestSouthAlign() {
        given().someSelectedFigures();
        when().pressAlignSouth();
        then().figuresAlignedSouth();
    }

    @Test
    public void TestEastAlign() {
        given().someSelectedFigures();
        when().pressAlignEast();
        then().figuresAlignedEast();
    }

    @Test
    public void TestWestAlign() {
        given().someSelectedFigures();
        when().pressAlignWest();
        then().figuresAlignedWest();
    }

    @Test
    public void TestVerticalAlign() {
        given().someSelectedFigures();
        when().pressAlignVertical();
        then().figuresAlignedVertically();
    }

    @Test
    public void TestHorizontalAlign() {
        given().someSelectedFigures();
        when().pressAlignHorizontal();
        then().figuresAlignedHorizontally();
    }
}

class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    AlignActionTest test;
    @ProvidedScenarioState
    DefaultDrawingEditor editor;

    public GivenSomeState someSelectedFigures() {
        test = new AlignActionTest();
        test.setUp();
        editor = test.getEditor();
        return self();
    }

}

class WhenSomeAction extends Stage<WhenSomeAction> {

    @ExpectedScenarioState
    AlignActionTest test;
    @ExpectedScenarioState
    DefaultDrawingEditor editor;

    public WhenSomeAction pressAlignNorth() {
        test.align(new North(editor));
        return self();
    }

    public WhenSomeAction pressAlignSouth() {
        test.align(new South(editor));
        return self();
    }

    public WhenSomeAction pressAlignEast() {
        test.align(new East(editor));
        return self();
    }

    public WhenSomeAction pressAlignWest() {
        test.align(new West(editor));
        return self();
    }

    public WhenSomeAction pressAlignVertical() {
        test.align(new Vertical(editor));
        return self();
    }

    public WhenSomeAction pressAlignHorizontal() {
        test.align(new Horizontal(editor));
        return self();
    }
}

class ThenSomeOutcome extends Stage<ThenSomeOutcome> {

    @ExpectedScenarioState
    AlignActionTest test;

    public ThenSomeOutcome figuresAlignedNorth() {
        test.testNorth();
        return self();
    }

    public ThenSomeOutcome figuresAlignedSouth() {
        test.testSouth();
        return self();
    }

    public ThenSomeOutcome figuresAlignedEast() {
        test.testEast();
        return self();
    }

    public ThenSomeOutcome figuresAlignedWest() {
        test.testWest();
        return self();
    }

    public ThenSomeOutcome figuresAlignedVertically() {
        test.testVertical();
        return self();
    }

    public ThenSomeOutcome figuresAlignedHorizontally() {
        test.testHorizontal();
        return self();
    }
}
