package com.kodokoto.gotchimon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;

import com.kodokoto.graphics.Assets;

public class Room 
{
    
    private int width, height;
    private static ArrayList<ArrayList<Tile>> tiles;

    public Room(String map) 
    {
        tiles = parseMap(map);
        width = tiles.get(0).size();
        height = tiles.size();
    }

    public void update() {}

    // render the room

    public void render(Graphics graphics)
    {
        for (int y = 0; y < height; y++) 
        {
            for (int x = 0; x < width; x++) 
            {
                getTile(x, y).render(graphics);
            }
        }
    }

    public static ArrayList<ArrayList<Tile>> getTiles()
    {
        return tiles;
    }

    // get the tile at the specified coordinates

    public Tile getTile(int x, int y)
    {
        return tiles.get(y).get(x);
    }

    // parse the map file and return a 2d array of tiles

    private static ArrayList<ArrayList<Tile>> parseMap(String map)
    {
        ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(map));
            String tileData = reader.readLine();
            int i = 0;
            while (tileData != null) 
            {
                tiles.add(new ArrayList<Tile>());
                ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(tileData.split(" ")));
                for (int j = 0; j < tokens.size(); j++) 
                {
                    tiles.get(i).add(new Tile(Assets.tiles.get(tokens.get(j).substring(0, 3)), tokens.get(j).substring(3, 4).equals("1"), j * Tile.TILE_SIZE, i * Tile.TILE_SIZE));
                }                
                i++;
                tileData = reader.readLine();
            }
            reader.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return tiles;
    }
}
