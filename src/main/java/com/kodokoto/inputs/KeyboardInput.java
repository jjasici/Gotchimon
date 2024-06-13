package com.kodokoto.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.kodokoto.states.*;
import com.kodokoto.ui.UITextField;

public class KeyboardInput implements KeyListener {

    private boolean[] keys;
    public boolean w, a, s, d, up, down, left, right, space, enter, esc, number1, number2, number3, number4, number5;

    public KeyboardInput() {
        keys = new boolean[256];
    }

    // update the keys being pressed

    public void update()
    {
        w = keys[KeyEvent.VK_W];
        a = keys[KeyEvent.VK_A];
        s = keys[KeyEvent.VK_S];
        d = keys[KeyEvent.VK_D];
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        enter = keys[KeyEvent.VK_ENTER];
        esc = keys[KeyEvent.VK_ESCAPE];
        number1 = keys[KeyEvent.VK_1];
        number2 = keys[KeyEvent.VK_2];
        number3 = keys[KeyEvent.VK_3];
        number4 = keys[KeyEvent.VK_4];
        number5 = keys[KeyEvent.VK_5];
    }

    // if the current state, 

    @Override
    public void keyTyped(KeyEvent e) {

        // if the current state is the save menu, add the key typed to the text field

        if (State.getState()==StateManager.SAVE_MENU)
        {
            UITextField.addToText(e.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

        // if the current state is the save menu, and the user presses backspace, remove the last character from the text field

        if (State.getState()==StateManager.SAVE_MENU)
        {
            if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
            {
                UITextField.removeFromText();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

        // if the current state is the game state and the user presses escape, go to the main menu
        // else go to the game state

        if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            if (State.getState()==StateManager.GAME_STATE)
            {
                State.setState(StateManager.MAIN_MENU);
            } 
            else 
            {
                State.setState(StateManager.GAME_STATE);
            }
        }
    }
    
}
