package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private int worldX; // x position in the whole map
    private int worldY; // y position in the whole map
    private String name; // name of the entity
    private Rectangle hitbox; // hitbox of entity
    private final EntityType TYPE;
    private BufferedImage[][] animations;

    public Entity(int worldX, int worldY, String name, int rectangleX, int rectangleY, EntityType type, BufferedImage[][] animations) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.name = name;
        this.TYPE = type;
        hitbox = new Rectangle(0, 0, rectangleX, rectangleY);
        this.animations = animations;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    protected boolean collidesWith(Entity otherEntity) {
        return this != otherEntity && hitbox.intersects(otherEntity.getHitbox());
    }

}
