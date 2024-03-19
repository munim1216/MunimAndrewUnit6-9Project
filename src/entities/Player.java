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
        if (keyH.isDKeyPressed()) {
            setWorldX(getWorldX() + getSpeed());
        }
        if (keyH.isAKeyPressed()) {
            setWorldX(getWorldX() - getSpeed());
        }
        if (keyH.isWKeyPressed()) {
            setWorldY(getWorldY() - getSpeed());
        }
        if (keyH.isSKeyPressed()) {
            setWorldY(getWorldY() + getSpeed());
        }

        if (keyH.isMovementKeyPressed()) {
            incrementActionLockCounter();
        }
    }
}
