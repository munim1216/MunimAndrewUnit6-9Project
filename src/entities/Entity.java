package entities;

import java.awt.*;

public abstract class Entity {
    private int worldX;
    private int worldY;
    private String name;
    private Rectangle hitbox;
    public static final int TYPE_PLAYER = 0, TYPE_MOB = 1, TYPE_NPC = 2, TYPE_INTERACTABLE = 4;
    public Entity(int worldX, int worldY, String name, int rectangleX, int rectangleY) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.name = name;
        hitbox = new Rectangle(0,0, rectangleX, rectangleY);
    }
}
