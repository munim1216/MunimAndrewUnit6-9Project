package entities;

import java.awt.image.BufferedImage;

public class Projectile extends Moveable {


    public Projectile(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage sprite, int speed) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite, speed);
    }
}
