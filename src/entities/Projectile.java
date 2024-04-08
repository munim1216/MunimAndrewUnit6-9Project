package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Moveable implements Processable {
    private BufferedImage[][] animations;
    private double angle;
    private double xSpeed;
    private double ySpeed;
    private double remainingX;
    private double remainingY;

    public Projectile(Point startingLocation, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, int speed, double angle, BufferedImage animations) {
        super(startingLocation.x, startingLocation.y, name, hitboxX, hitboxY, spriteX, spriteY, type, animations, speed);
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
        g2D.rotate(angle, getX(), getY());
        g2D.drawImage(getAnimations()[0][0], getX(), getY(), getSpriteWidth(), getSpriteHeight(), null);
        g2D.rotate(-angle, getX(), getY());
    }
}
