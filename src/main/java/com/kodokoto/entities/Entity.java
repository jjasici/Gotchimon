package com.kodokoto.entities;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import com.kodokoto.gotchimon.Room;
import com.kodokoto.gotchimon.Tile;
import com.kodokoto.gotchimon.Visible;
import com.kodokoto.graphics.Assets;
import com.kodokoto.graphics.Bounds;

// base class for all enitites

public abstract class Entity implements Visible, Serializable {
    
    protected float x, y;
    protected int width = Assets.ASSET_SIZE, height = Assets.ASSET_SIZE;
    protected boolean interacting = false;
    protected Gotchimon currentPet;
    protected Bounds bounds;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
        bounds = new Bounds(this, 0,Assets.ASSET_SIZE, Assets.ASSET_SIZE, Assets.ASSET_SIZE);
    }

    public abstract void update();

    public abstract void render(Graphics g);


    // checks if the entity is colliding with any other object that implements visible.
    // i.e another entity or a tile 

    public <E extends Visible> boolean colliding(E e) {
        return bounds.collides(e.getBounds());
    }

    public Bounds getBounds()
    {
        return this.bounds;
    }


    // checks if the entity is colliding with any tile that is solid (i.e. not walkable)

    protected boolean isCollidingWithTiles()
    {
        for (ArrayList<Tile> line : Room.getTiles())
        {
            for (Tile t : line)
            {
                if (t.isSolid() && colliding(t))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // getters and setters

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
    
}
