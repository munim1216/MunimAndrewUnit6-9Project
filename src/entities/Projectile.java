package entities;

import java.awt.*;

public class Projectile extends Moveable implements Processable {
    private Sprite sprite;
    private double angle;
    private double xSpeed;
    private double ySpeed;
    private double remainingX;
    private double remainingY;

    public Projectile(Point startingLocation, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, int speed, double angle, Sprite sprite) {
        super(startingLocation.x, startingLocation.y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite, speed);
        this.sprite = sprite;
        this.angle = angle;
        xSpeed = speed * Math.cos(angle);
        ySpeed = speed * Math.sin(angle);
        System.out.println(Math.toDegrees(angle));
    }

    public void hurt(Character c) {
        c.die();
    }

    @Override
    public void process() {
        remainingX += xSpeed;
        remainingY += ySpeed;

        int dX = (int) remainingX;
        int dY = (int) remainingY;

        remainingX -= dX;
        remainingY -= dY;

        setLocation(getX() + dX, getY() + dY);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.rotate(angle, getX() + (double) getHitbox().width / 2, getY() + (double) getHitbox().height / 2);
        g2D.drawImage(sprite.currentSprite(), getX(), getY(), getSpriteWidth(), getSpriteHeight(), null);
        g2D.rotate(-angle, getX() + (double) getHitbox().width / 2, getY() + (double) getHitbox().height / 2);
    }
}
