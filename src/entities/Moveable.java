package entities;

import java.awt.*;

public class Moveable extends Entity {
    private Rectangle trailingHitbox;

    public Moveable(int x, int y, String name, int rectangleX, int rectangleY, EntityType type) {
        super(x, y, name, rectangleX, rectangleY, type);
        trailingHitbox = (Rectangle) getHitbox().clone();
    }

    public void move(int dx, int dy) {
        trailingHitbox.setLocation(getPoint());
        super.move(dx, dy);
    }

    Rectangle getTrailingHitbox() {
        return trailingHitbox;
    }
}
