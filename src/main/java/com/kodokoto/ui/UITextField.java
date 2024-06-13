package com.kodokoto.ui;

import java.awt.Graphics;

import com.kodokoto.graphics.Text;

import java.awt.Color;

public class UITextField extends UIElement 
{
    // UI text field is just a text field object

    private static String text;
    private static int maxLength = 18;

    public UITextField(int x, int y, int width, int height) {
        super(x, y, width, height);
        text = "";
    }


    // render the awt textarea

    @Override
    public void render(Graphics graphics) {
        // graphics.drawRect((int) x, (int) y, (int) width, (int) height);
        Text.drawString(graphics, text, (int) x, (int) y, Color.white);
    }

    // update the text field

    @Override
    public void update() {}

    // on keyReleased event, update the text field

    public void onKeyReleased(char c) {
        if (text.length() < maxLength) {
            text += c;
        }
    }

    public static void addToText(char c)
    {
        if (text.length() < maxLength && Character.isLetter(c)) {
            text += c;
        }
    }

    public static void removeFromText()
    {
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }
    }

    public static String getText()
    {
        return text;
    }

    public static void resetText()
    {
        text = "";
    }

    @Override
    public void onClick() {}
    
}
