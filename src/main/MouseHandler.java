package main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    private boolean pressed;
    private boolean inScreen;
    private boolean clicked;
    private GamePanel gp;
    private Point lastPoint;
    public MouseHandler(GamePanel gp) {
        this.gp = gp;
        lastPoint = new Point(0,0);
        inScreen = false;
    }
    public boolean isPressed() {
        return pressed;
    }

    public boolean isClicked() {
        if (clicked) {
            clicked = false;
            return true;
        }
        return false;
    }

    public Point getMouseLocation() {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        if (inScreen) {
            mouseLocation.translate(-gp.getLocationOnScreen().x, -gp.getLocationOnScreen().y);
            lastPoint = mouseLocation;
            return mouseLocation;
        } else {
            return lastPoint;
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
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
        inScreen = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        inScreen = false;
    }
}
