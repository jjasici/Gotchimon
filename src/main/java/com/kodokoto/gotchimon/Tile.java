package com.kodokoto.gotchimon;

import java.awt.image.BufferedImage;

import com.kodokoto.graphics.Assets;
import com.kodokoto.graphics.Bounds;

import java.awt.Graphics;


public class Tile implements Visible 
{

    protected BufferedImage texture;
    protected final boolean solid;
    public static final int TILE_SIZE = Assets.ASSET_SIZE;
    public int x, y;
    private Bounds bounds;

    // base tile class

    public Tile(BufferedImage texture, boolean solid, int x, int y) 
    {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.solid = solid;
        this.bounds = new Bounds(this, 0, 0, TILE_SIZE, TILE_SIZE);
    }

    public void update() {}

    public boolean isSolid()
    {
        return solid;
    }

    // render the tile

    public void render(Graphics graphics)
    {
        graphics.drawImage(texture, x, y, TILE_SIZE, TILE_SIZE, null);
    }

    // getters and setters

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getWidth() {
        return TILE_SIZE;
    }

    @Override
    public float getHeight() {
        return TILE_SIZE;
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }
}
