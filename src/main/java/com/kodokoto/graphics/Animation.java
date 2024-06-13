package com.kodokoto.graphics;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Animation implements Serializable 
{
    private int animationSpeed, index;
    private double previousTime = 0;
    private double currentTime = 0;

    public Animation(int animationSpeed)
    {
        this.animationSpeed = animationSpeed;
        previousTime = System.currentTimeMillis();
    }

    // update the animation

    public void update()
    {

        currentTime += System.currentTimeMillis() - previousTime;
        previousTime = System.currentTimeMillis();

        // this keeps track of the animation animationSpeed

        if (currentTime > animationSpeed)
        {
            index++;
            currentTime = 0;

            // reset the animation

            if (index >= 4)
            {
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame(ArrayList<BufferedImage> frames)
    {
        return frames.get(index);
    }

    // serialization id

    private static final long serialVersionUID = 1L;
    
}
