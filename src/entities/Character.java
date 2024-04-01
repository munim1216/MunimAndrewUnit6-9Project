package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Character extends Moveable {
    private BufferedImage[][] animations;
    private int spriteFrame; // the column in the 2d array of animations
    private int typeOfSprite; // the row in the 2d array of animations, each row a different type of sprite
    private int actionLockCounter;
    private int health;
    private int damage;
    private int iframes;
    private boolean isInvincible;
    private boolean hasDied;
    private int deathAnimationCounter;
    private boolean isDeathAnimationOver;
    private Direction lastDirection;
    private Direction direction;

    public Character(int x, int y,
                     String name,
                     int hitboxX, int hitboxY,
                     int spriteX, int spriteY,
                     EntityType type,
                     int speed,
                     BufferedImage animations,
                     int health,
                     int damage
    ) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, null, speed);
        this.animations = splitSpriteSheet(animations);
        this.health = health;
        this.damage = damage;
        direction = Direction.DOWN;
        lastDirection = direction;
        spriteFrame = 0;
        typeOfSprite = 0;
        actionLockCounter = 0;
        iframes = 0;
        isInvincible = false;
        hasDied = false;
        deathAnimationCounter = 0;
        isDeathAnimationOver = false;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getActionLockCounter() {
        return actionLockCounter;
    }

    public void incrementActionLockCounter() {
        actionLockCounter++;
    }

    public void draw(Graphics2D g2D) {
        switch (direction) {
            case DOWN -> typeOfSprite = 0;
            case RIGHT -> typeOfSprite = 1;
            case LEFT -> typeOfSprite = 2;
            case UP -> typeOfSprite = 3;
        }
        if (lastDirection != direction) {
            lastDirection = direction;
            spriteFrame = 0;
            actionLockCounter = 0;
        }
        if (actionLockCounter > 10) {
            spriteFrame++;
            spriteFrame %= animations[0].length;
            actionLockCounter = 0;
        }

        BufferedImage currentFrame = animations[typeOfSprite][spriteFrame];
        g2D.drawImage(currentFrame, getX(), getY(), getSpriteWidth(), getSpriteHeight(), null);
    }

    private BufferedImage[][] splitSpriteSheet(BufferedImage spriteSheet) {
        BufferedImage[][] animations = new BufferedImage[spriteSheet.getHeight() / 64][spriteSheet.getWidth() / 64];
        for (int row = 0; row < spriteSheet.getHeight() / 64; row++) { // number is 64 because for some reason each sprite is upscaled to that in my sprite sheet
            for (int col = 0; col < spriteSheet.getWidth() / 64; col++) {
                animations[row][col] = spriteSheet.getSubimage(col * 64, row * 64, 64, 64);
            }
        }
        return animations;
    }
}
