package com.kodokoto.ui;

import java.awt.Graphics;

import com.kodokoto.graphics.Text;
import java.awt.Color;


// UI Header is a sinle line of text that does nothing when cicked or hovered

public class UIHeader extends UIElement
{

    private String text;

    public UIHeader(float x, float y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics graphics) {
        Text.drawString(graphics, text, (int) x, (int) y, Color.white);
    }

    @Override
    public void onClick() {}
    
}
