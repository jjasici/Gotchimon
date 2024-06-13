package com.kodokoto.graphics;

import java.awt.Graphics;

import java.awt.Color;

public class Text {

    // class for text

    public static void drawString(Graphics graphics, String text, int x, int y, Color color) {
        graphics.setColor(color);
        graphics.setFont(Assets.font);
        graphics.drawString(text, x, y);
    }

}
