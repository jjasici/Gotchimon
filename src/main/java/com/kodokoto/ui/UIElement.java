package com.kodokoto.ui;

import java.awt.Graphics;

import com.kodokoto.gotchimon.Visible;
import com.kodokoto.graphics.Bounds;

import java.awt.event.MouseEvent;

// base class for UI elements

public abstract class UIElement implements Visible
{

    protected float x, y;
    protected float width, height;
    protected boolean hovering = false;
    protected Bounds bounds; // bounds of the element

    public UIElement(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Bounds(this, 0, -15, width, height);
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public abstract void onClick();


    // if the mouse moves, check if it is hovering over any UI elements

    public void onMouseMoved(MouseEvent e)
    {
        if (bounds.contains(e.getX(), e.getY()))
        {
            hovering = true;
        }
        else
        {
            hovering = false;
        }
    }

    // if the mouse is released and the mouse is hovering over the UI element 
    // trigger the onClick method

    public void onMouseRelease(MouseEvent e)
    {

        if (hovering)
        {
            onClick();
        }
    }

    // Getters and Setters

    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

    public Bounds getBounds() {
        return bounds;
    }

}


