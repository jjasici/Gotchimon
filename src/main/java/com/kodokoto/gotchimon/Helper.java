package com.kodokoto.gotchimon;

import com.kodokoto.inputs.KeyboardInput;
import com.kodokoto.inputs.MouseInput;
import com.kodokoto.states.GameState;
import com.kodokoto.states.StateManager;

// helper class allows for easy access to state objects and inputs

public class Helper 
{
    private static Main game;

    public Helper(Main g) {
        game = g;
    }

    public static KeyboardInput getKeyInput() {
        return game.keyboardInput;
    }

    public static MouseInput getMouseInput() {
        return game.mouseInput;
    }

    public static GameState getGameState() {
        return (GameState) StateManager.GAME_STATE.getValue();
    }
    
}
