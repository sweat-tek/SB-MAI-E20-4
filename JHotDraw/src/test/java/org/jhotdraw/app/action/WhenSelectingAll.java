/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import org.jhotdraw.draw.DefaultDrawingView;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

/**
 *
 * @author Patrick
 */
class WhenSelectingAll extends Stage<WhenSelectingAll>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DefaultDrawingView dv;
    
    WhenSelectingAll selectingAll() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            Mockito.when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(dv);
            
            ActionEvent evt = new ActionEvent(dv, ActionEvent.ACTION_PERFORMED, "edit.clearSelection");
            SelectAllAction instance = new SelectAllAction();
            instance.actionPerformed(evt);
        }
        return this;
    }
}
