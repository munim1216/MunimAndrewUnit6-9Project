package entities;

import java.awt.image.BufferedImage;
import main.KeyHandler;

public class Player extends GameCharacter {
    private KeyHandler keyH;
    public Player(int worldX, int worldY, String name, int rectangleX, int rectangleY, EntityType type, int speed, BufferedImage animations, int health, int damage, KeyHandler /* test parameter */ keyH) {
        super(worldX, worldY, name, rectangleX, rectangleY, type, speed, animations, health, damage);
        this.keyH = keyH;
    }

    public void process() {
        if (keyH.isRightKeyPressed()) {
            setWorldX(getWorldX() + getSpeed());
            incrementActionLockCounter();
        }
        if (keyH.isLeftKeyPressed()) {
            setWorldX(getWorldX() - getSpeed());
            incrementActionLockCounter();
        }
        if (keyH.isUpKeyPressed()) {
            setWorldY(getWorldY() - getSpeed());
            incrementActionLockCounter();
        }
        if (keyH.isDownKeyPressed()) {
            setWorldY(getWorldY() + getSpeed());
            incrementActionLockCounter();
        }
    }
}
