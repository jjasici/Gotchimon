package com.kodokoto.entities;

import java.awt.Graphics;

import com.kodokoto.graphics.Animation;
import com.kodokoto.graphics.Assets;
import com.kodokoto.inputs.KeyboardInput;


public class Player extends Entity {

    public KeyboardInput input;
    private Animation anim;
    private int ANIMATION_SPEED = 100;

    // class for player

    public Player(KeyboardInput input, float x, float y) {
        super(x, y);
        this.input = input;
        anim = new Animation(ANIMATION_SPEED);
        height = Assets.ASSET_SIZE*2;
    }

    // update player position based on input

    @Override
    public void update() {
        if (input.w)
        {
            anim.update();
            y -= 5;
            if (isCollidingWithTiles())
            {
                y += 5;
            }
        }
        if (input.s)
        {
            anim.update();
            y += 5;
            if (isCollidingWithTiles())
            {
                y -= 5;
            }
        }
        if (input.a)
        {
            anim.update();
            x -= 5;
            if (isCollidingWithTiles())
            {
                x += 5;
            }
        }
        if (input.d)
        {
            anim.update();
            x += 5;
            if (isCollidingWithTiles())
            {
                x -= 5;
            }
        }
    }

    // render current animation frame based on direction

    @Override
    public void render(Graphics graphics) {
        if (input.w)
        {
            graphics.drawImage(anim.getCurrentFrame(Assets.player_up), (int) x, (int) y, width, height, null);
        }
        else if (input.a)
        {
            graphics.drawImage(anim.getCurrentFrame(Assets.player_left), (int) x, (int) y, width, height, null);
        }
        else if (input.d)
        {
            graphics.drawImage(anim.getCurrentFrame(Assets.player_right), (int) x, (int) y, width, height, null);
        }
        else
        {
            graphics.drawImage(anim.getCurrentFrame(Assets.player_down), (int) x, (int) y, width, height, null);
        }
    }
}
