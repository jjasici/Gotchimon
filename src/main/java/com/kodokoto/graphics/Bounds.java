package com.kodokoto.graphics;

import java.io.Serializable;

import com.kodokoto.gotchimon.Visible;

// bounds class for collision detection

public class Bounds implements Serializable {
    
    private float xOffset, yOffset, width, height;
    private Visible object;

    public Bounds(Visible object, float xOffset, float yOffset, float width, float height) {
        this.object = object;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return this.object.getX() + this.xOffset;
    }

    public float getY() {
        return this.object.getY() + this.yOffset;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean collides(Bounds e) {        
        return (this.getX() < e.getX() + e.getWidth() && this.getX() + width > e.getX() && this.getY() < e.getY() + e.getHeight() && this.getY() + height > e.getY());
    }

    public boolean contains(float x, float y) {
        return this.getX() < x && this.getX() + this.width > x && this.getY() < y && this.getY() + this.height > y;
    }

    // serialization id

    // private static final long serialVersionUID = -8790878859079079079L;
}
