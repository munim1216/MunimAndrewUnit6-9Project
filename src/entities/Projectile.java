package entities;

import java.awt.image.BufferedImage;

public class Projectile extends Moveable implements Processable {
    private BufferedImage[][] animations;

    public Projectile(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, int speed) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, null, speed);
    }

    public void setAnimations(BufferedImage[][] animations) {
        this.animations = animations;
    }

    public void hurt(Character c) {

    }
}
