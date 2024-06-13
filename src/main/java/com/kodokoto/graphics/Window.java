package com.kodokoto.graphics;

import javax.swing.JFrame;
import java.awt.*;

public class Window {
    
    private JFrame window;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Window(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;

        createWindow();
    }

    // JFrame settings

    private void createWindow()
    {
        window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        window.add(canvas);
        window.pack();

    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame()
    {
        return window;
    }
}
