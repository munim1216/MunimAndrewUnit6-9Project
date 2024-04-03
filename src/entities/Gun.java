package entities;

import main.MouseHandler;

import java.awt.image.BufferedImage;

public class Gun extends Moveable {
    private int cooldown;
    private int cooldownCD;
    private static MouseHandler mouseH;


    public Gun(int x, int y, String name, int spriteX, int spriteY, BufferedImage sprite, int speed) {
        super(x, y, name, 0, 0, spriteX, spriteY, EntityType.WEAPON, sprite, speed);

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
