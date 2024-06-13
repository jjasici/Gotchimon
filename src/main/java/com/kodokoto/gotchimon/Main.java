package com.kodokoto.gotchimon;
import java.awt.image.BufferStrategy;

import com.kodokoto.graphics.Assets;
import com.kodokoto.graphics.Window;
import com.kodokoto.inputs.KeyboardInput;
import com.kodokoto.inputs.MouseInput;
import com.kodokoto.states.State;
import com.kodokoto.states.StateManager;

import java.awt.Graphics;

public class Main implements Runnable
{
    
    private Window window;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    
    public KeyboardInput keyboardInput;
    public MouseInput mouseInput;
    public Helper helper;

    public Main(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;

        // instantiate inputs

        keyboardInput = new KeyboardInput();
        mouseInput = new MouseInput();
    }

    private void init()
    {

        // instantiate window, and add input listeners
        this.window = new Window(title, width, height);
        window.getFrame().addKeyListener(keyboardInput);
        window.getFrame().addMouseListener(mouseInput);
        window.getFrame().addMouseMotionListener(mouseInput);
        window.getCanvas().addMouseListener(mouseInput);
        window.getCanvas().addMouseMotionListener(mouseInput);

        // initialize all assets, helper and states

        Assets.init();

        helper = new Helper(this);

        State.setState(StateManager.LOAD_MENU);
    }

    private void update()
    {
        keyboardInput.update();
        if (State.getStateValue() != null)
        {
            State.getStateValue().update(); 
        }
    }

    private void render()
    {
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        if (State.getStateValue() != null)
        {
            State.getStateValue().render(g); 
        }

        bs.show();
        g.dispose();
    }


    public void run()
    {

        init();

        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double difference = 0;
        long currentTime;
        long lastTime = System.nanoTime();

        // this is the main game loop

        while(running)
        {
            currentTime = System.nanoTime();
            difference += (currentTime - lastTime) / timePerUpdate;
            lastTime = currentTime;

            if (difference >= 1)
            {
                update();
                render();
                difference--;
            }
        }
        stop();
    }

    // starts the game loop

    public synchronized void start()
    {
        if (running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    // stops the game loop

    public synchronized void stop()
    {
        if (!running)
        {
            return;
        }
        running = false;
        try 
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
