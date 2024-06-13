package com.kodokoto.entities;

import java.awt.Graphics;

import com.kodokoto.graphics.Assets;

public class Computer extends Entity {


    
        public Computer(float x, float y) {
            super(x, y);
        }
    
        @Override
        public void update() {}
    
        @Override
        public void render(Graphics graphics) {

            // render computer tiles

            graphics.drawImage(Assets.compTopLeft, (int)x, (int)y, (int)width, (int)height, null);
            graphics.drawImage(Assets.compTopRight, (int)x + (int)width, (int)y, (int)width, (int)height, null);
            graphics.drawImage(Assets.compBottomLeft, (int)x, (int)y + (int)height, (int)width, (int)height, null);
            graphics.drawImage(Assets.compBottomRight, (int)x + (int)width, (int)y + (int)height, (int)width, (int)height, null);
        }
    
    
}
