package main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    private boolean pressed;
    private GamePanel gp;

    public MouseHandler(GamePanel gp) {
        this.gp = gp;
    }
    public boolean isPressed() {
        return pressed;
    }
    public Point getMouseLocation() {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        mouseLocation.translate(-gp.getLocationOnScreen().x, -gp.getLocationOnScreen().y);
        return mouseLocation;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
