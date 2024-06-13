package com.kodokoto.inputs;

import com.kodokoto.entities.Gotchimon;
import java.io.*;
import java.util.ArrayList;

public class FileIO 
{

    // returns a string array of file names from a specified path

    public static String[] getFiles(String path)
    {
        File folder = new File(path);
        String[] files = folder.list();
        System.out.println(files);
        return files;
    }


    // takes in a path string and returns a deserialized arrayList of Gotchimon objects   

    public static ArrayList<Gotchimon> load(String path)
    {
        ArrayList<Gotchimon> gotchimons = new ArrayList<Gotchimon>();
        try
        {
            FileInputStream fileIn = new FileInputStream("./out/saves/" + path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gotchimons = (ArrayList<Gotchimon>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException c)
        {
            c.printStackTrace();
            return null;
        }
        return gotchimons;
    }

    // takes in a path string and an arrayList of Gotchimon objects and serializes them to the specified path

    public static void save(String path, ArrayList<Gotchimon> gotchimons)
    {
        try
        {
            // if the file doesn not exist, create it   

            FileOutputStream fileOut = new FileOutputStream("./out/saves/" + path + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gotchimons);
            out.close();
            fileOut.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }

}
