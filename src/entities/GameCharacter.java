package entities;

import java.awt.image.BufferedImage;

public class GameCharacter extends Entity {
    private BufferedImage[][] animations;
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
    private int direction;
    public static final int DIRECTION_UP = 1, DIRECTION_DOWN = 2, DIRECTION_LEFT = 3, DIRECTION_RIGHT = 4;
    public GameCharacter(int worldX,
                         int worldY,
                         String name,
                         int rectangleX,
                         int rectangleY,
                         EntityType type,
                         int speed,
                         BufferedImage[][] animations,
                         int health,
                         int damage
    ) {
        super(worldX, worldY, name, rectangleX, rectangleY, type);
        this.speed = speed;
        this.animations = animations;
        this.health = health;
        this.damage = damage;
        direction = DIRECTION_DOWN;
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
