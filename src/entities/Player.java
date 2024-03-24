package entities;

import java.awt.image.BufferedImage;
import main.KeyHandler;

public class Player extends GameCharacter {
    private KeyHandler keyH;
    public Player(int worldX, int worldY, String name, int rectangleX, int rectangleY, EntityType type, int speed, BufferedImage animations, int health, int damage, KeyHandler /* test parameter */ keyH) {
        super(worldX, worldY, name, rectangleX, rectangleY, type, speed, animations, health, damage);
        this.keyH = keyH;
    }

    public void processInput() {
        int deltaX = 0;
        int deltaY = 0;
        if (keyH.isDKeyPressed()) {
            deltaX += getSpeed();
        }
        if (keyH.isAKeyPressed()) {
            deltaX -= getSpeed();
        }
        if (keyH.isWKeyPressed()) {
            deltaY -= getSpeed();
        }
        if (keyH.isSKeyPressed()) {
            deltaY += getSpeed();
        }

        if (deltaY > 0) {
            setDirection(Direction.DOWN);
        } else if (deltaY < 0) {
            setDirection(Direction.UP);
        } else if (deltaX < 0) {
            setDirection(Direction.LEFT);
        } else if (deltaX > 0) {
            setDirection(Direction.RIGHT);
        }

        if (keyH.isMovementKeyPressed()) {
            incrementActionLockCounter();
        }

        move(deltaX, deltaY);
    }
}
