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
        given().selectedFigures();
        when().alignNorth();
        then().figuresAlignedNorth();
    }

    @Test
    public void TestSouthAlign() {
        given().selectedFigures();
        when().alignSouth();
        then().figuresAlignedSouth();
    }

    @Test
    public void TestEastAlign() {
        given().selectedFigures();
        when().alignEast();
        then().figuresAlignedEast();
    }

    @Test
    public void TestWestAlign() {
        given().selectedFigures();
        when().alignWest();
        then().figuresAlignedWest();
    }

    @Test
    public void TestVerticalAlign() {
        given().selectedFigures();
        when().alignVertical();
        then().figuresAlignedVertical();
    }

    @Test
    public void TestHorizontalAlign() {
        given().selectedFigures();
        when().alignHorizontal();
        then().figuresAlignedHorizontal();
    }
}

class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    AlignActionTest test;
    @ProvidedScenarioState
    DefaultDrawingEditor editor;

    public GivenSomeState selectedFigures() {
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

    public WhenSomeAction alignNorth() {
        test.align(new North(editor));
        return self();
    }

    public WhenSomeAction alignSouth() {
        test.align(new South(editor));
        return self();
    }

    public WhenSomeAction alignEast() {
        test.align(new East(editor));
        return self();
    }

    public WhenSomeAction alignWest() {
        test.align(new West(editor));
        return self();
    }

    public WhenSomeAction alignVertical() {
        test.align(new Vertical(editor));
        return self();
    }

    public WhenSomeAction alignHorizontal() {
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

    public ThenSomeOutcome figuresAlignedVertical() {
        test.testVertical();
        return self();
    }

    public ThenSomeOutcome figuresAlignedHorizontal() {
        test.testHorizontal();
        return self();
    }
}
