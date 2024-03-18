package entities;

import java.awt.*;
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
                         BufferedImage animations,
                         int health,
                         int damage
    ) {
        super(worldX, worldY, name, rectangleX, rectangleY, type);
        this.speed = speed;
        this.animations = splitSpriteSheet(animations);
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

    public int getSpeed() {
        return speed;
    }

    public int getActionLockCounter() {
        return actionLockCounter;
    }

    public void incrementActionLockCounter() {
        actionLockCounter++;
    }

    public void draw(Graphics2D g2D) {
        if (actionLockCounter > 10) {
            if (currentSprite < animations[0].length - 1) {
                currentSprite++;
            } else {
                currentSprite = 0;
            }
            actionLockCounter = 0;
        }
        g2D.drawImage(animations[typeOfSprite][currentSprite], getWorldX(), getWorldY(), 48, 48, null);
    }

    private BufferedImage[][] splitSpriteSheet(BufferedImage unsplit) {
        BufferedImage[][] animations = new BufferedImage[unsplit.getHeight() / 64][unsplit.getWidth() / 64];
        for (int row = 0; row < unsplit.getHeight() / 64; row++) { // number is 64 because for some reason each sprite is upscaled to that in my sprite sheet
            for (int col = 0; col < unsplit.getWidth() / 64; col++) {
                animations[row][col] = unsplit.getSubimage(col * 64, row * 64, 64, 64);
            }
        }

        return animations;
    }
}
