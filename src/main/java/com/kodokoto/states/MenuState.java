

package com.kodokoto.states;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import com.kodokoto.gotchimon.App;
import com.kodokoto.ui.UIBackground;
import com.kodokoto.ui.UIElement;

// MenuState is the state that is used when the user is in the menu

public class MenuState extends State
{
    ArrayList<UIElement> UiElements;

    public MenuState(ArrayList<UIElement> UiElements)
    {
        this.UiElements = UiElements;

        // add the background to the menu to the top of the ArrayList
        // so that it is rendered first

        UiElements.add(0, new UIBackground(0, 2* App.resolution/3, App.resolution, App.resolution/3, Color.BLACK));
    }

    //

    @Override
    public void update() 
    {
        // if the user presses the escape key, then go to the game state
        // else update all UI Elements

        for (UIElement option : UiElements)
        {
            option.update();
        }
    }

    // render all UI Elements

    @Override
    public void render(Graphics graphics) {
        for (UIElement e : UiElements)
        {
            e.render(graphics);
        }
    }

    public ArrayList<UIElement> getUiElements()
    {
        return UiElements;
    }
}

