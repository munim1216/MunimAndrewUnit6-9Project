package entities;

import java.awt.*;

public abstract class Entity {
    private Point point; // location of upper-left corner
    private String name; // name of the entity
    private Rectangle hitbox; // hitbox of entity
    private final EntityType TYPE;

    Entity(int x, int y, String name, int rectangleX, int rectangleY, EntityType type) {
        this.point = new Point(x, y);
        this.name = name;
        this.TYPE = type;
        hitbox = new Rectangle(point, new Dimension(rectangleX, rectangleY));
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void move(int dx, int dy) {
        point.translate(dx, dy);
        hitbox.translate(dx, dy);
    }

    Point getPoint() {
        return point;
    }

    boolean collidesWith(Entity otherEntity) {
        return this != otherEntity && hitbox.intersects(otherEntity.getHitbox());
    }
}
