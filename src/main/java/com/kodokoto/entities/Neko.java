package com.kodokoto.entities;

import java.awt.Graphics;

import com.kodokoto.graphics.Animation;
import com.kodokoto.graphics.Assets;

public class Neko extends Gotchimon {

    private int ANIMATION_SPEED = 50;
    // class for cat pet
    
    public Neko(float x, float y) {
        super(x, y, 100, 100, 100);

        // default stats

        hunger = 0;
        happiness = 0;
        health = 50;

        // animation assets

        anim = new Animation(ANIMATION_SPEED);

    }

    @Override
    public void render(Graphics graphics) {

        // render current animation frame based on direction

        switch (direction)
        {
            case 1:
                graphics.drawImage(anim.getCurrentFrame(Assets.nekoUp), (int) x, (int) y, null);
                break;
            case 2:
                graphics.drawImage(anim.getCurrentFrame(Assets.nekoDown), (int) x, (int) y, null);
                break;
            case 3:
                graphics.drawImage(anim.getCurrentFrame(Assets.nekoLeft), (int) x, (int) y, null);
                break;
            case 4:
                graphics.drawImage(anim.getCurrentFrame(Assets.nekoRight), (int) x, (int) y, null);
                break;
            default:
                graphics.drawImage(Assets.nekoDown.get(0), (int) x, (int) y, null);
                break;
        }
    }
}
    
