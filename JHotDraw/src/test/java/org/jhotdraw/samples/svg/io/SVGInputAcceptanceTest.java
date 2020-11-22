/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Peder
 */
public class SVGInputAcceptanceTest extends ScenarioTest<GivenSVGInputFormat, WhenIGiveSomeSVGData, ThenIHaveAListOfFigures>{
    
    @Test
    public void testSvgInput(){
        given().svg_format();
        when().i_give_data("<?xml version=\"1.0\" encoding=\"UTF-8\"?><svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.2\" baseProfile=\"tiny\"><defs/><line x1=\"195\" y1=\"148\" x2=\"233\" y2=\"381\" fill=\"none\" stroke=\"#000\"/><line x1=\"110\" y1=\"168\" x2=\"278\" y2=\"124\" fill=\"none\" stroke=\"#000\"/><line x1=\"367\" y1=\"105\" x2=\"440\" y2=\"289\" fill=\"none\" stroke=\"#000\"/><line x1=\"442\" y1=\"71\" x2=\"367\" y2=\"105\" fill=\"none\" stroke=\"#000\"/><line x1=\"505\" y1=\"129\" x2=\"405\" y2=\"189\" fill=\"none\" stroke=\"#000\"/><line x1=\"572\" y1=\"225\" x2=\"440\" y2=\"285\" fill=\"none\" stroke=\"#000\"/><path fill=\"none\" stroke=\"#000\" d=\"M 752 50 C 738.17487 47.97681 722.4923 44.74567 710.1 51.2 696.1362 58.47279 686.3971 78.40614 689.7 93.8 692.22504 105.568405 703.795 113.48771 712.5 121.8 720.0137 128.97469 726.6839 137.00856 733.2 145.1 747.1101 162.37302 750.80975 188.18602 747.4 210.1 745.02264 225.37897 737.9268 241.63408 725.7 251.1 721.2431 254.5505 715.57605 256.06873 710.4 258.3 700.1932 262.69995 690.13336 267.43332 680 272\"/><line x1=\"954\" y1=\"70\" x2=\"936\" y2=\"285\" fill=\"none\" stroke=\"#000\"/><line x1=\"851\" y1=\"62\" x2=\"1043\" y2=\"78\" fill=\"none\" stroke=\"#000\"/></svg>");
        then().i_have_a_list_of_figures();
    }
    
}
