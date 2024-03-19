package entities;

import java.awt.*;

public abstract class Entity {
    private int worldX; // x position in the whole map
    private int worldY; // y position in the whole map
    private String name; // name of the entity
    private Rectangle hitbox; // hitbox of entity
    private final EntityType TYPE;
    protected Entity(int worldX, int worldY, String name, int rectangleX, int rectangleY, EntityType type) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.name = name;
        this.TYPE = type;
        hitbox = new Rectangle(0,0, rectangleX, rectangleY);
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void move(int deltaX, int deltaY) {
        worldX += deltaX;
        worldY += deltaY;
    }
}
