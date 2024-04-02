package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Moveable extends Entity {
    private int speed;
    private Rectangle lastHitbox;

    public Moveable(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage sprite, int speed) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite);
        this.speed = speed;
        lastHitbox = new Rectangle(getHitbox());
    }

    public void translate(int dx, int dy) {
        lastHitbox.setLocation(getLocation());
        super.translate(dx, dy);
        getEntityManager().dealWithCollisions(this);
    }

    public void setLocation(int x, int y) {
        lastHitbox.setLocation(getLocation());
        super.setLocation(x, y);
        getEntityManager().dealWithCollisions(this);
    }

    public int getSpeed() {
        return speed;
    }

    Rectangle getLastHitbox() {
        return lastHitbox;
    }
}
