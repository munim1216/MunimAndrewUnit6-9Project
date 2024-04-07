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
        System.out.println("shoots!");

        bulletPoint = new Point(getLocation().x + (int) (length * Math.cos(getAngle())), getLocation().y + (int) (length * Math.sin(getAngle())));
    }
}
