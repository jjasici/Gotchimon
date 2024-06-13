package com.kodokoto.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.kodokoto.states.State;
import com.kodokoto.ui.UIElement;

public class MouseInput implements MouseListener, MouseMotionListener 
{

    public MouseInput() {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {

        // if the mouse moves, we need to check if it's hovering over any UI elements

        if (State.getStateValue() != null)
        {
            for (UIElement uiElement :  State.getStateValue().getUiElements())
            {
                uiElement.onMouseMoved(e);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        
        // if the mouse is released, we want to trigger the onMouseRelease method of every UIElement

        if (State.getStateValue() != null)
        {
            for (UIElement uiElement :  State.getStateValue().getUiElements())
            {
                uiElement.onMouseRelease(e);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
