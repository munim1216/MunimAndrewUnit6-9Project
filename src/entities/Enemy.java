package entities;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Character implements Processable{
    private static Random random = new Random();
    private int actionLockCounterv2;
    private int currentAngle;

    public Enemy(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, int speed, BufferedImage animations, int health, int damage) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, speed, animations, health, damage);
        actionLockCounterv2 = 0;
        currentAngle = 0;
    }

    @Override
    public void process() {
        if (actionLockCounterv2 > 4) {
            currentAngle = random.nextInt(361);
            actionLockCounterv2 = 0;
        } else {
            actionLockCounterv2++;
        }

        int deltaX = (int) (getSpeed() * Math.cos(currentAngle));
        int deltaY = (int) (getSpeed() * Math.sin(currentAngle));

        if (deltaY > 0) {
            setDirection(Direction.DOWN);
        } else if (deltaY < 0) {
            setDirection(Direction.UP);
        } else if (deltaX < 0) {
            setDirection(Direction.LEFT);
        } else if (deltaX > 0) {
            setDirection(Direction.RIGHT);
        }
        incrementActionLockCounter();

        translate(deltaX, deltaY);
    }

}
