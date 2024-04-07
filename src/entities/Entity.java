package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    private static EntityManager entityManager;
    private Point location; // location of upper-left corner
    private String name; // name of the entity
    private Rectangle hitbox; // hitbox of entity
    private Dimension spriteSize;
    private final EntityType TYPE;
    private BufferedImage sprite;

    Entity(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage sprite) {
        this.location = new Point(x, y);
        this.name = name;
        hitbox = new Rectangle(x, y, hitboxX, hitboxY);
        spriteSize = new Dimension(spriteX, spriteY);
        this.TYPE = type;
        this.sprite = sprite;
        entityManager.add(this);
    }

    public static void setEntityManager(EntityManager entityManager) {
        Entity.entityManager = entityManager;
    }

    EntityManager getEntityManager() {
        return entityManager;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Point getLocation() {
        return location;
    }

    public int getX() {
        return getLocation().x;
    }

    public int getY() {
        return getLocation().y;
    }

    public void translate(int dx, int dy) {
        location.translate(dx, dy);
        hitbox.translate(dx, dy);
    }

    public void setLocation(int x, int y) {
        location.setLocation(x, y);
        hitbox.setLocation(x, y);
    }

    public int getSpriteWidth() {
        return spriteSize.width;
    }

    public int getSpriteHeight() {
        return spriteSize.height;
    }
    public BufferedImage getSprite() {
        return sprite;
    }

    boolean collidesWith(Entity otherEntity) {
        return this != otherEntity && hitbox.intersects(otherEntity.getHitbox());
    }

    public void draw(Graphics2D g2D) {
        g2D.drawImage(sprite, location.x, location.y, spriteSize.width, spriteSize.height, null);
    }

    public void process() {

    }
}
