package main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    private boolean pressed;
    private GamePanel gp;
    private Point lastPoint;
    public MouseHandler(GamePanel gp) {
        this.gp = gp;
        lastPoint = new Point(0,0);
    }
    public boolean isPressed() {
        return pressed;
    }
    public Point getMouseLocation() {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        if (new Rectangle(gp.getLocationOnScreen().x, gp.getLocationOnScreen().y, gp.getWidth(), gp.getHeight()).contains(mouseLocation)) {
            mouseLocation.translate(-gp.getLocationOnScreen().x, -gp.getLocationOnScreen().y);
            lastPoint = mouseLocation;
            System.out.println("inside");
            return mouseLocation;
        } else {
            return lastPoint;
        }

        //return mouseLocation;
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
