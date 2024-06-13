package com.kodokoto.ui;

import java.awt.Graphics;
import java.awt.Color;

import com.kodokoto.gotchimon.Helper;
import com.kodokoto.graphics.Text;
import com.kodokoto.states.GameState;


// UI stat display simply displays the stats of the current active pet

public class UIStatDisplay extends UIElement
{
    public UIStatDisplay(float x, float y, int width, int height) 
    {
        super(x, y, width, height);
    }

    @Override
    public void update() {}

    // render the stats

    @Override
    public void render(Graphics graphics) 
    {
        Text.drawString(graphics, "Health:",(int) x, (int) y, Color.red);
        Helper.getGameState();
        Text.drawString(graphics, GameState.getActivePet().getHealth() + "", (int) x + 100, (int) y, Color.white);
        Text.drawString(graphics, "Hunger:", (int) x + 170, (int) y, Color.green);
        Text.drawString(graphics, GameState.getActivePet().getHunger() + "", (int) x + 270, (int) y, Color.white);
        Text.drawString(graphics, "Happiness:", (int) x + 320, (int) y, Color.blue);
        Text.drawString(graphics, GameState.getActivePet().getHappiness() + "", (int) x + 460, (int) y, Color.white);
    }

    @Override
    public void onClick() {}

}
