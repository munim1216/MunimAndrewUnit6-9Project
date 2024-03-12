package entities;

import java.awt.*;

public abstract class Entity {
    private int worldX; // x position in the whole map
    private int worldY; // y position in the whole map
    private String name; // name of the entity
    private Rectangle hitbox; // hitbox of entity
    private final int TYPE;
    public static final int TYPE_PLAYER = 0, TYPE_MOB = 1, TYPE_NPC = 2, TYPE_WEAPON = 3;
    protected Entity(int worldX, int worldY, String name, int rectangleX, int rectangleY, int type) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.name = name;
        this.TYPE = type;
        hitbox = new Rectangle(0,0, rectangleX, rectangleY);
    }
}
