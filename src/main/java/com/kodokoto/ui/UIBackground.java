package com.kodokoto.ui;

import java.awt.Color;
import java.awt.Graphics;


// UI backround is just a rectangle object

public class UIBackground extends UIElement {

    private Color color;

    public UIBackground(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }
    
    @Override
    public void update() {}

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect((int) x, (int)  y, (int) width, (int) height);
    }


    @Override
    public void onClick() {}

}

