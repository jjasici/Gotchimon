package com.kodokoto.ui;

import java.awt.Graphics;
import java.awt.Color;

import com.kodokoto.graphics.Text;

// UI Text Button is text that acts as a button

public class UITextButton extends UIElement
{

    private String text;
    private Clickable clickAction;

    public UITextButton(float x, float y, int width, int height, String text, Clickable clickAction) {
        super(x, y, width, height);
        this.text = text;
        this.clickAction = clickAction;
    }

    @Override
    public void update() {}

    // if the mouse is hovering over the button, change the color

    @Override
    public void render(Graphics graphics) {
        if (hovering)
        {
            Text.drawString(graphics, text, (int) x, (int) y, Color.yellow);
        }
        else
        {
            Text.drawString(graphics, text, (int) x, (int) y, Color.white);
        }
    }

    @Override
    public void onClick() 
    {
        this.clickAction.onClick();
    }

}
