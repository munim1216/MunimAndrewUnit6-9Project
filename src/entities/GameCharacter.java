package entities;

import java.awt.image.BufferedImage;

public class GameCharacter extends Entity {
    private int currentSprite; // the column in the 2d array of animations
    private int typeOfSprite; // the row in the 2d array of animations, each row a different type of sprite
    private int speed;
    private int actionLockCounter;
    private int health;
    private int damage;
    private int iframes;
    private boolean isInvincible;
    private boolean hasDied;
    private int deathAnimationCounter;
    private boolean isDeathAnimationOver;
    private Direction direction;

    public GameCharacter(int worldX,
                         int worldY,
                         String name,
                         int rectangleX,
                         int rectangleY,
                         EntityType type,
                         BufferedImage[][] animations,
                         int speed,
                         int health,
                         int damage
    ) {
        super(worldX, worldY, name, rectangleX, rectangleY, type, animations);
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        direction = Direction.DOWN; // lol default
        currentSprite = 0;
        typeOfSprite = 0;
        actionLockCounter = 0;
        iframes = 0;
        isInvincible = false;
        hasDied = false;
        deathAnimationCounter = 0;
        isDeathAnimationOver = false;
    }
}
