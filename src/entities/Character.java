package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Character extends Moveable {
    private Sprite sprite;
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
                     Sprite sprite,
                     int health,
                     int damage
    ) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite, speed);
        this.sprite = sprite;
        this.health = health;
        this.damage = damage;
        direction = Direction.DOWN;
        lastDirection = direction;
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

    public void removeHealth(int healthLost) {
        health -= healthLost;
        System.out.println("I have lost " + healthLost + " and currently have " + health + " HP");
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
            sprite.switchSpriteType(typeOfSprite);
            actionLockCounter = 0;
        }
        if (actionLockCounter > 10) {
            sprite.nextSprite();
            actionLockCounter = 0;
        }
        BufferedImage currentFrame = sprite.currentSprite();

        g2D.drawImage(currentFrame, getX(), getY(), getSpriteWidth(), getSpriteHeight(), null);
    }
}
