package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean wKeyPressed, sKeyPressed, aKeyPressed, dKeyPressed; // movement keys
    private boolean fKeyPressed; // interact key
    private boolean upKeyPressed, downKeyPressed, leftKeyPressed, rightKeyPressed; // attack keys
    private boolean escKeyPressed;
    public KeyHandler(){}
    public boolean isUpKeyPressed() {
        return upKeyPressed;
    }

    public boolean isDownKeyPressed() {
        return downKeyPressed;
    }

    public boolean isLeftKeyPressed() {
        return leftKeyPressed;
    }

    public boolean isRightKeyPressed() {
        return rightKeyPressed;
    }

    public boolean isEscKeyPressed() {
        return escKeyPressed;
    }

    public boolean isWKeyPressed() {
        return wKeyPressed;
    }
    public boolean isAKeyPressed() {
        return aKeyPressed;
    }

    public boolean isDKeyPressed() {
        return dKeyPressed;
    }

    public boolean isSKeyPressed() {
        return sKeyPressed;
    }

    public boolean isFKeyPressed() {
        return fKeyPressed;
    }

    public boolean isMovementKeyPressed() {
        return wKeyPressed || sKeyPressed || aKeyPressed || dKeyPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W -> wKeyPressed = true;
            case KeyEvent.VK_S -> sKeyPressed = true;
            case KeyEvent.VK_A -> aKeyPressed = true;
            case KeyEvent.VK_D -> dKeyPressed = true;
            case KeyEvent.VK_F -> fKeyPressed = true;
            case KeyEvent.VK_UP -> upKeyPressed = true;
            case KeyEvent.VK_DOWN -> downKeyPressed = true;
            case KeyEvent.VK_LEFT -> leftKeyPressed = true;
            case KeyEvent.VK_RIGHT -> rightKeyPressed = true;
            case KeyEvent.VK_ESCAPE ->  escKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                wKeyPressed = false;
            }
            case KeyEvent.VK_S -> sKeyPressed = false;
            case KeyEvent.VK_A -> aKeyPressed = false;
            case KeyEvent.VK_D -> dKeyPressed = false;
            case KeyEvent.VK_UP -> upKeyPressed = false;
            case KeyEvent.VK_DOWN -> downKeyPressed = false;
            case KeyEvent.VK_LEFT -> leftKeyPressed = false;
            case KeyEvent.VK_RIGHT -> rightKeyPressed = false;
            case KeyEvent.VK_F -> fKeyPressed = false;
            case KeyEvent.VK_ESCAPE ->  escKeyPressed = false;
        }
    }
}
