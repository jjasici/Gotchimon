package com.kodokoto.states;

import java.awt.Graphics;
import java.util.ArrayList;

import com.kodokoto.entities.Computer;
import com.kodokoto.entities.Gotchimon;
import com.kodokoto.entities.Player;
import com.kodokoto.gotchimon.App;
import com.kodokoto.gotchimon.Helper;
import com.kodokoto.gotchimon.Room;
import com.kodokoto.graphics.Assets;
import com.kodokoto.inputs.FileIO;
import com.kodokoto.ui.Clickable;
import com.kodokoto.ui.UIElement;
import com.kodokoto.ui.UITextButton;


// GameState is the state that is used when the user is playing the game

public class GameState extends State
{

    private Room room;
    private Player player;
    private static Computer computer;
    public static Gotchimon activePet;
    public static ArrayList<UIElement> uiElements = new ArrayList<UIElement>()
    {{
        add(new UITextButton(Assets.ASSET_SIZE*4 + 32 + 8, App.resolution-30, 45, 15, "menu", new Clickable() {
            
                // when the user clicks on the button, change the state to the main menu state
    
                @Override
                public void onClick() {
                    State.setState(StateManager.MAIN_MENU);
                }
        }));
    }};

    private static ArrayList<Gotchimon> pets;

    // initialize the player, computer and room

    public GameState() 
    {
        this.player = new Player(Helper.getKeyInput(), App.resolution/2, App.resolution/2);
        room = new Room("./out/maps/room.txt");
        computer = new Computer(Assets.ASSET_SIZE*6, Assets.ASSET_SIZE*2);
        pets = new ArrayList<Gotchimon>();
    }

    // render the room, computer, the player and any pets that have been added to the room

    public void render(Graphics graphics)
    {
        room.render(graphics);
        computer.render(graphics);
        player.render(graphics);
        uiElements.get(0).render(graphics);
        for (Gotchimon pet : pets) 
        {
            pet.render(graphics);
        }
    };

    public void update()
    {
        // if the user has pressed the space key 
        // and the player is colliding with the computer
        // then change the state to the computer menu

        uiElements.get(0).update();


        if (Helper.getKeyInput().space && player.colliding(computer))
        {
            State.setState(StateManager.COMPUTER_MENU);
        } 

        // if the user has pressed the space key
        // get a pet that is colliding with the player
        // and set the active pet to that pet
        // then change the state to the pet menu

        else if (Helper.getKeyInput().space)
        {
            Gotchimon pet = getCollidingPet();
            if (pet != null)
            {
                activePet = pet;
                State.setState(StateManager.INTERACTION_MENU);
            }
        }

        // update the player and any pets that have been added to the room

        player.update();
        for (Gotchimon pet : pets)
        {
            pet.update();
        }
    };

    public static void load(String path)
    {
        pets = FileIO.load(path);
    }

    public static void save(String path)
    {
        FileIO.save(path, pets);
    }


    // getters and setters

    public static ArrayList<Gotchimon> getPets() 
    {
        return pets;
    }

    public static Gotchimon getActivePet()
    {
        return activePet;
    }

    // rertun the first pet that is colliding with the player

    public Gotchimon getCollidingPet() 
    {
        for (Gotchimon p : pets) 
        {
            if (this.player.colliding(p)) 
            {
                return p;
            }
        }
        return null;
    }

    public void addPet(Gotchimon pet) 
    {
        pets.add(pet);
    }

    public ArrayList<UIElement> getUiElements()
    {
        return uiElements;
    }

    public static void resetPets()
    {
        pets = new ArrayList<Gotchimon>();
    }
}
