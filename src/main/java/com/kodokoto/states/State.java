package com.kodokoto.states;

import java.awt.Graphics;
import java.util.ArrayList;

import com.kodokoto.ui.UIElement;
// this is the base class for all states

public abstract class State 
{

    // the current state dictates what is rendered and updated

    public static State currentState = null;
    public static Enum<StateManager> currentStateEnum = null;

    public abstract void update();

    public abstract void render(Graphics graphics);

    public abstract ArrayList<UIElement> getUiElements();

    // getters and setters

    public static void setState(Enum<StateManager> state) {
        State.currentStateEnum = state;
        currentState = ((StateManager) state).getValue();
    }
    
    public static Enum<StateManager> getState() {
        return currentStateEnum;
    }

    public static State getStateValue()
    {
        return currentState;
    }

}
