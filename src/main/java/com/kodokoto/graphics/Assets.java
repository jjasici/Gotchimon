package com.kodokoto.graphics;

import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import com.kodokoto.gotchimon.App;

public class Assets {

    public static final int ASSET_SIZE= App.resolution/10;

    private static final int PLAYER_Y_START = ASSET_SIZE * 8,
                             AHIRU_Y_START = ASSET_SIZE * 16,
                             NEKO_Y_START = ASSET_SIZE * 24;

    public static ArrayList<BufferedImage> player_down, player_left, player_right, player_up,
                                  ahiruUp, ahiruDown, ahiruLeft, ahiruRight,
                                  nekoLeft, nekoRight, nekoUp, nekoDown;

    public static BufferedImage compTopLeft, compTopRight, compBottomLeft, compBottomRight;
    public static HashMap<String, BufferedImage> tiles;

    public static Font font = new Font("Monospaced", Font.BOLD, 20);
    

    public static void init()
    {
        // load the sprite sheet

        SpriteSheet sheet = new SpriteSheet("/sprites/sheet.png");

        // tiles
        tiles = new HashMap<String, BufferedImage>() {{
            put("flr", sheet.getSprite(ASSET_SIZE*2, 0, ASSET_SIZE, ASSET_SIZE));            // floor
            put("bor", sheet.getSprite(ASSET_SIZE*3, 0, ASSET_SIZE, ASSET_SIZE));            // border
            put("dtl", sheet.getSprite(0, ASSET_SIZE, ASSET_SIZE, ASSET_SIZE));              // door top left
            put("dtm", sheet.getSprite(ASSET_SIZE, ASSET_SIZE, ASSET_SIZE, ASSET_SIZE));     // door top middle
            put("dtr", sheet.getSprite(ASSET_SIZE*2, ASSET_SIZE, ASSET_SIZE, ASSET_SIZE));   // door top right
            put("wlt", sheet.getSprite(ASSET_SIZE*3, ASSET_SIZE, ASSET_SIZE, ASSET_SIZE));   // wall top 
            put("dbl", sheet.getSprite(0, ASSET_SIZE*2, ASSET_SIZE, ASSET_SIZE));            // door bottom left
            put("dbm", sheet.getSprite(ASSET_SIZE, ASSET_SIZE*2, ASSET_SIZE, ASSET_SIZE));   // door bottom middle
            put("dbr", sheet.getSprite(ASSET_SIZE*2, ASSET_SIZE*2, ASSET_SIZE, ASSET_SIZE)); // door bottom right
            put("wlb", sheet.getSprite(ASSET_SIZE*3, ASSET_SIZE*2, ASSET_SIZE, ASSET_SIZE)); // wall bottom
            put("wnt", sheet.getSprite(ASSET_SIZE*2, ASSET_SIZE*3, ASSET_SIZE, ASSET_SIZE)); // window top
            put("wnb", sheet.getSprite(ASSET_SIZE*2, ASSET_SIZE*4, ASSET_SIZE, ASSET_SIZE)); // window bottom
        }};

        // player sprites
        
        player_down = new ArrayList<BufferedImage>();
        player_left = new ArrayList<BufferedImage>();
        player_right = new ArrayList<BufferedImage>();
        player_up = new ArrayList<BufferedImage>();

        // ahiru sprites

        ahiruDown = new ArrayList<BufferedImage>();
        ahiruLeft = new ArrayList<BufferedImage>();
        ahiruRight = new ArrayList<BufferedImage>();
        ahiruUp = new ArrayList<BufferedImage>();

        // neko sprites

        nekoDown = new ArrayList<BufferedImage>();
        nekoLeft = new ArrayList<BufferedImage>();
        nekoRight = new ArrayList<BufferedImage>();
        nekoUp = new ArrayList<BufferedImage>();

        // get animations

        for (int i = 0; i<4; i++)
        {
            player_down.add(sheet.getSprite(ASSET_SIZE*i, PLAYER_Y_START,  ASSET_SIZE, ASSET_SIZE*2));
            player_left.add(sheet.getSprite( ASSET_SIZE*i, PLAYER_Y_START + (ASSET_SIZE*2), ASSET_SIZE, ASSET_SIZE*2));
            player_right.add(sheet.getSprite(ASSET_SIZE*i, PLAYER_Y_START + (ASSET_SIZE*4), ASSET_SIZE, ASSET_SIZE*2));
            player_up.add(sheet.getSprite(ASSET_SIZE*i, PLAYER_Y_START + (ASSET_SIZE*6), ASSET_SIZE, ASSET_SIZE*2));

            ahiruDown.add(sheet.getSprite(ASSET_SIZE*i, AHIRU_Y_START,  ASSET_SIZE, ASSET_SIZE*2));
            ahiruLeft.add(sheet.getSprite( ASSET_SIZE*i, AHIRU_Y_START + (ASSET_SIZE*2), ASSET_SIZE, ASSET_SIZE*2));
            ahiruRight.add(sheet.getSprite(ASSET_SIZE*i, AHIRU_Y_START + (ASSET_SIZE*4), ASSET_SIZE, ASSET_SIZE*2));
            ahiruUp.add(sheet.getSprite(ASSET_SIZE*i, AHIRU_Y_START + (ASSET_SIZE*6), ASSET_SIZE, ASSET_SIZE*2));

            nekoDown.add(sheet.getSprite(ASSET_SIZE*i, NEKO_Y_START,  ASSET_SIZE, ASSET_SIZE*2));
            nekoLeft.add(sheet.getSprite( ASSET_SIZE*i, NEKO_Y_START + (ASSET_SIZE*2), ASSET_SIZE, ASSET_SIZE*2));
            nekoRight.add(sheet.getSprite(ASSET_SIZE*i, NEKO_Y_START + (ASSET_SIZE*4), ASSET_SIZE, ASSET_SIZE*2));
            nekoUp.add(sheet.getSprite(ASSET_SIZE*i, NEKO_Y_START + (ASSET_SIZE*6), ASSET_SIZE, ASSET_SIZE*2));
        
        }

        // computer sprites

        compTopLeft = sheet.getSprite(0, ASSET_SIZE*3, ASSET_SIZE, ASSET_SIZE);
        compTopRight = sheet.getSprite(ASSET_SIZE, ASSET_SIZE*3, ASSET_SIZE, ASSET_SIZE);
        compBottomLeft = sheet.getSprite(0, ASSET_SIZE*4, ASSET_SIZE, ASSET_SIZE);
        compBottomRight = sheet.getSprite(ASSET_SIZE, ASSET_SIZE*4, ASSET_SIZE, ASSET_SIZE);
        
    }   
}
