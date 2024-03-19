package entities;

import java.awt.*;

public class Moveable extends Entity {
    private Rectangle trailingHitbox;
    public Moveable(int worldX, int worldY, String name, int rectangleX, int rectangleY, EntityType type) {
        super(worldX, worldY, name, rectangleX, rectangleY, type);
    }

    public void move(int deltaX, int deltaY) {
        super.move(deltaX, deltaY);
    }
}
