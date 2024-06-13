package com.kodokoto.states;

import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;

import com.kodokoto.entities.Ahiru;
import com.kodokoto.entities.Neko;
import com.kodokoto.gotchimon.App;
import com.kodokoto.gotchimon.Helper;
import com.kodokoto.graphics.Assets;
import com.kodokoto.inputs.FileIO;
import com.kodokoto.items.Food;
import com.kodokoto.ui.Clickable;
import com.kodokoto.ui.UIBackground;
import com.kodokoto.ui.UIElement;
import com.kodokoto.ui.UIHeader;
import com.kodokoto.ui.UIStatDisplay;
import com.kodokoto.ui.UITextButton;
import com.kodokoto.ui.UITextField;

// enum wrapper for the different possible states

public enum StateManager 
{
    GAME_STATE (
        createGameState()
    ),
    
    COMPUTER_MENU (
        createComputerMenu()
    ),

    INTERACTION_MENU (
        createInteractionMenu()
    ),

    FOOD_MENU (
        createFoodMenu()
    ),

    LOAD_MENU (
        createLoadMenu()
    ),

    SAVE_MENU (
        createSaveMenu()
    ),

    MAIN_MENU (
        createMainMenu()
    ),

    HELP_MENU (
        createHelpMenu()
    );

    protected final static int MENU_Y_POS = 426;
    private State state;
    protected static final float SPAWN_X = App.resolution/2, SPAWN_Y = App.resolution/2;
    private static final int SIZE = 15;
    private static Random randomizer = new Random();


    private StateManager(State state)
    {        
        this.state = state;
    }

    protected void setValue(State newState) {
        this.state = newState;
    }

    public State getValue()
    {
        return this.state;
    }

    // main game state, responsible for updating and rendering the game loop
    private static GameState createGameState()
    {
        return new GameState();
    }

    // menu state for the computer menu, used for spawning new pets
    private static MenuState createComputerMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{

                add(new UIHeader(Assets.ASSET_SIZE + 20, MENU_Y_POS + 40, SIZE, SIZE, "What pet do you want to add?"));
                
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 80, SIZE*4, SIZE, "Ahiru", new Clickable() {

                    // when the user clicks on the button, add an Ahiru to the room
                    // and change the state to the main game state

                    @Override
                    public void onClick() {
                        Helper.getGameState().addPet(new Ahiru(SPAWN_X, SPAWN_Y));
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 110, SIZE*3, SIZE, "Neko", new Clickable() {

                    @Override
                    public void onClick() {
                        Helper.getGameState().addPet(new Neko(SPAWN_X, SPAWN_Y));
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
            }} 
        ); 
    }

    // menu state for interacting with a pet
    private static MenuState createInteractionMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{
                add(new UIHeader(Assets.ASSET_SIZE + 20, MENU_Y_POS + 40, SIZE, SIZE, "What do you want to do?"));

                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 80, SIZE*3, SIZE, "Feed", new Clickable() {

                    // when the user clicks on the button, change the state to the food menu
                    @Override
                    public void onClick() {
                        State.setState(StateManager.FOOD_MENU);
                    }
                }));
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 100, SIZE*3, SIZE, "Play", new Clickable() {

                    // when the user clicks on the button, call the play method on the pet 
                    // and change the state to the main game state

                    @Override
                    public void onClick() {
                        GameState.getActivePet().play();
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
                add(new UIStatDisplay(Assets.ASSET_SIZE + 20, App.resolution - 60, SIZE, SIZE));
            }} 
        );
    }

    // menu state for loading a save file
    private static MenuState createFoodMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{
                add(new UIHeader(Assets.ASSET_SIZE + 20, MENU_Y_POS + 40, SIZE, SIZE, "What do you want to feed your pet?"));

                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 80, SIZE*6, SIZE, "Onigiri", new Clickable() {
                    @Override
                    public void onClick() {
                        GameState.getActivePet().feed(new Food(10, 10, -10));
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 100, SIZE*4, SIZE, "Ramen", new Clickable() {
                    @Override
                    public void onClick() {
                        GameState.getActivePet().feed(new Food(30, -10, 10));
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 120, SIZE*3, SIZE, "Sake", new Clickable() {
                    @Override
                    public void onClick() {
                        GameState.getActivePet().feed(new Food(-10, -20, 50));
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 140, SIZE*3, SIZE, "Nasu", new Clickable() {
                    @Override
                    public void onClick() {
                        GameState.getActivePet().feed(new Food(randomizer.nextInt(40) -20 , randomizer.nextInt(40) -20, randomizer.nextInt(40) -20));
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
                add(new UIStatDisplay(Assets.ASSET_SIZE + 20, App.resolution - 30, SIZE, SIZE));
            }} 
        );
    }

    // menu state for feeding a pet
    private static MenuState createLoadMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{

                add(new UIBackground(0, 0, App.resolution, App.resolution, Color.black));
                add(new UIHeader(Assets.ASSET_SIZE + 20, MENU_Y_POS, SIZE, SIZE, "What savefile would you like to load?"));
                int index = 0;

                // for each save file, add a button to the menu
                // when the user clicks on the button, load the save file and change the state to the main game state

                for (String s : FileIO.getFiles("./out/saves/"))
                {
                    add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 40 + (30*(index++)), SIZE*(s.length()-1), SIZE, s, new Clickable() {
                        @Override
                        public void onClick() {
                            GameState.load(s);
                            State.setState(StateManager.GAME_STATE);
                        }
                    }));
                };

                // button for new game

                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 40 + (30*(index++)), SIZE*7, SIZE, "New Game", new Clickable() {
                    @Override
                    public void onClick() {
                        System.out.println(StateManager.GAME_STATE.getValue());
                        StateManager.GAME_STATE.setValue(createGameState());
                        System.out.println(StateManager.GAME_STATE.getValue());
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
            }}
        );
    }

    // menu state for saving the current game state
    public static MenuState createSaveMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{
                add(new UIBackground(0, 0, App.resolution, App.resolution, Color.black));
                add(new UIHeader(Assets.ASSET_SIZE + 20, MENU_Y_POS, SIZE, SIZE, "What would you like to name your save file?"));
                add(new UITextField(Assets.ASSET_SIZE + 20, MENU_Y_POS + 30, SIZE, SIZE));
                add(new UITextButton(Assets.ASSET_SIZE + 20, MENU_Y_POS + 60, SIZE*7, SIZE, "save", new Clickable() {
                    @Override
                    public void onClick() {
                        GameState.save(UITextField.getText());
                        UITextField.resetText();
                        State.setState(StateManager.GAME_STATE);
                    }
                }));
            }}
        );
    }

    // menu state for the main menu
    public static MenuState createMainMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{
                add(new UIBackground(0, 0, App.resolution, App.resolution, Color.black));
                add(new UITextButton((App.resolution / 2) -20, 300, SIZE*3, SIZE, "help", new Clickable() {
                    @Override
                    public void onClick() {
                        State.setState(StateManager.HELP_MENU);
                    }
                }));
                add(new UITextButton((App.resolution / 2) -20, 340, SIZE*3, SIZE, "load", new Clickable() {
                    @Override
                    public void onClick() {                      
                        StateManager.LOAD_MENU.setValue(createLoadMenu()); 
                        State.setState(StateManager.LOAD_MENU);
                    }
                }));
                add(new UITextButton((App.resolution / 2) -20, 380, SIZE*3, SIZE, "save", new Clickable() {
                    @Override
                    public void onClick() {
                        State.setState(StateManager.SAVE_MENU);
                    }
                }));
                add(new UITextButton((App.resolution / 2) -20, 420, SIZE*3, SIZE, "exit", new Clickable() {
                    @Override
                    public void onClick() {
                        System.exit(0);
                    }
                }));
            }}
        );
    }

    // state for the help screen
    public static MenuState createHelpMenu()
    {
        return new MenuState(
            new ArrayList<UIElement>() {{
                add(new UIBackground(0, 0, App.resolution, App.resolution, Color.black));
                String[] instructions = {
                    "Hello, welcome to gotchimon",
                    "",
                    "Keyboard shortcuts",
                    "space - interact",
                    "w, a, s, d - move around",
                    "",
                    "To feed or play with a pet,",
                    "simply interract with them"    
                };

                for (int i = 0; i<instructions.length; i++)
                {
                    add(new UIHeader(Assets.ASSET_SIZE + 20, 220 + (30*i), SIZE, SIZE, instructions[i]));
                }
            }}
        );
    }
} 
