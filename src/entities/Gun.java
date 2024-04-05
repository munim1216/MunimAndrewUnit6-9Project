package entities;

import main.MouseHandler;

import java.awt.image.BufferedImage;

public class Gun extends Weapon {
    private int cooldown;
    private int cooldownCD;
    private static MouseHandler mouseH;

    public Gun(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, BufferedImage sprite, int damage, int cooldown) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, EntityType.WEAPON, sprite, damage, cooldown);
        cooldown = 0;
        cooldownCD = 60;
    }


    @Override
    public void process() {
        if (mouseH.isPressed()) {
            if (cooldown == 0) {
                cooldown = cooldownCD;
                System.out.println("shoot!");
            } else {
                System.out.println("cooling down");
                cooldown--;
            }
        }
    }

    public static void setMouseH(MouseHandler mouseH) {
        Gun.mouseH = mouseH;
    }
}
