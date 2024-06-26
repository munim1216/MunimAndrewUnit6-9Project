package entities;

import main.KeyHandler;

public class Player extends Character implements Processable {
    private static KeyHandler keyH;
    public Player(int x, int y,
                  String name,
                  int hitboxX, int hitboxY,
                  int spriteX, int spriteY,
                  EntityType type,
                  int speed,
                  Sprite sprite,
                  int health,
                  int damage) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, speed, sprite, health, damage);
    }

    public static void setKeyH(KeyHandler keyH) {
        Player.keyH = keyH;
    }

    @Override
    public void process() {
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

        translate(deltaX, deltaY);
    }
}
