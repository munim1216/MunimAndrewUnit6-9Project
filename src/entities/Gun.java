package entities;

import main.MouseHandler;

import java.awt.image.BufferedImage;

public class Gun extends Weapon {
    private int cooldown;
    private int cooldownCD;

    public Gun(String name, int hitboxX, int hitboxY, int spriteX, int spriteY, BufferedImage sprite, int damage, int cooldown) {
        super(getPlayer().getX() + 20, getPlayer().getY() + 20, name, hitboxX, hitboxY, spriteX, spriteY, EntityType.WEAPON, sprite, damage, cooldown);
        cooldown = 0;
        cooldownCD = 60;
    }


    @Override
    public void process() {
        super.process();
        if (getMouseH().isPressed()) {
            if (cooldown == 0) {
                cooldown = cooldownCD;
                System.out.println("shoot!");
            } else {
                System.out.println("cooling down");
                cooldown--;
            }
        }
    }
}
