package entities;

import main.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Gun extends Weapon {
    private int length;
    public Point bulletPoint = new Point(0,0);

    public Gun(String name, int hitboxX, int hitboxY, int spriteX, int spriteY, BufferedImage sprite, int damage, int cooldown, int length) {
        super(getPlayer().getX() + 20, getPlayer().getY() + 20, name, hitboxX, hitboxY, spriteX, spriteY, EntityType.WEAPON, sprite, damage, cooldown);
        this.length = length;
    }

    @Override
    public void attack() {
        if (getDir() == Direction.RIGHT) {
            bulletPoint = new Point(playerPoint.x + (int) (length * Math.cos(getAngle())), playerPoint.y + (int) (length * Math.sin(getAngle())));
        } else if (getDir() == Direction.LEFT) {
            bulletPoint = new Point(playerPoint.x - (int) (length * Math.cos(getAngle())), playerPoint.y - (int) (length * Math.sin(getAngle())));
        }

        new Bullet(bulletPoint,null, 25, 25, 48, 48, 5, getAngle());
    }
}
