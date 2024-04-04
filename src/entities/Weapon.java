package entities;

import main.MouseHandler;

import java.awt.image.BufferedImage;

public class Weapon extends Entity implements Processable {
    private int damage;
    private int cooldown;
    private int timeUntilResetCooldown;
    private static MouseHandler mouseH;

    public Weapon(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage sprite, int damage, int cooldown) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite);
        this.damage = damage;
        this.cooldown = cooldown;
        timeUntilResetCooldown = 0;
    }

    public static void setMouseH(MouseHandler mouseH) {
        Weapon.mouseH = mouseH;
    }

    @Override
    public void process() {

    }
}
