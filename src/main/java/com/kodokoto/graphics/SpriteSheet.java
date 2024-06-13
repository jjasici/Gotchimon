package com.kodokoto.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Image;

// class for sprite sheets

public class SpriteSheet {
    
    private BufferedImage sheet;

    public SpriteSheet(String path)
    {
        this.sheet = loadImage(path);
    }

    // load the image from the path

    public static BufferedImage loadImage(String path)
    {
        try {
            return scaleImage(ImageIO.read((SpriteSheet.class.getResource(path))), Assets.ASSET_SIZE/16);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    // scale the image from 16x16 to the specified size

    private static BufferedImage scaleImage(BufferedImage image, int scale)
    {
        Image tmp = image.getScaledInstance(image.getWidth() * scale, image.getHeight() * scale, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(image.getWidth() * scale, image.getHeight() * scale, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    }

    // get the image from the specified coordinates

    public BufferedImage getSprite(int x, int y, int width, int height)
    {
        return sheet.getSubimage(x, y, width, height);
    }

}
