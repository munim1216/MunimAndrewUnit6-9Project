package entities;

import java.awt.*;

public class Moveable extends Entity {
    private Rectangle trailingHitbox;

    public Moveable(int x, int y, String name, int rectangleX, int rectangleY, EntityType type) {
        super(x, y, name, rectangleX, rectangleY, type);
        trailingHitbox = (Rectangle) getHitbox().clone();
    }

    public void translate(int dx, int dy) {
        trailingHitbox.setLocation(getPoint());
        super.translate(dx, dy);
    }

    public void setLocation(Point point) {
        trailingHitbox.setLocation(point);
        super.setLocation(point);
    }

    Rectangle getTrailingHitbox() {
        return trailingHitbox;
    }
}
