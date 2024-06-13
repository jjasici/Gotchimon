package com.kodokoto.gotchimon;

import com.kodokoto.graphics.Bounds;

// any class that implements this must have the following getters

public interface Visible {
    public float getX();
    public float getY();
    public float getWidth();
    public float getHeight();
    public Bounds getBounds();
}
