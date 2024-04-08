package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Moveable extends Entity {
    private int speed;
    private Rectangle lastHitbox;
    private BufferedImage[][] animations;
    private boolean dead;

    public Moveable(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage animations, int speed) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, animations);
        this.speed = speed;
        lastHitbox = new Rectangle(getHitbox());
        this.animations = Util.splitSpriteSheet(animations);
        dead = false;
    }

    public BufferedImage[][] getAnimations() {
        return animations;
    }

    public int getSpeed() {
        return speed;
    }

    Rectangle getLastHitbox() {
        return lastHitbox;
    }

    public boolean isDead() {
        return dead;
    }
    public void die() {
        dead = true;
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

    void setLocationDuringCollision(int x, int y) {
        super.setLocation(x, y);
    }
}
