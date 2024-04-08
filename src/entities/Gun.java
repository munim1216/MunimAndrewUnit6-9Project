package entities;

import main.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Gun extends Weapon {
    private int length;
    private Point bulletPoint;

    public Gun(String name, int hitboxX, int hitboxY, int spriteX, int spriteY, BufferedImage sprite, int damage, int cooldown, int length) {
        super(getPlayer().getX() + 20, getPlayer().getY() + 20, name, hitboxX, hitboxY, spriteX, spriteY, EntityType.WEAPON, sprite, damage, cooldown);
        this.length = length;
        bulletPoint = new Point(0,0);
    }

    public Point getBulletPoint() {
        return bulletPoint;
    }

    @Override
    public void attack() {
        if (getDir() == Direction.RIGHT) {
            bulletPoint = new Point(getPlayerPoint().x + (int) (length * Math.cos(getAngle())), getPlayerPoint().y + (int) (length * Math.sin(getAngle())));
        } else if (getDir() == Direction.LEFT) {
            bulletPoint = new Point(getPlayerPoint().x + (int) (length * Math.cos(getAngle())), getPlayerPoint().y + (int) (length * Math.sin(getAngle())));
        }

        new Bullet(bulletPoint,null, 10, 10, 48, 48, 20, getAngle());
    }
}
