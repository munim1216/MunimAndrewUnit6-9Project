package entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet extends Projectile {

    private static BufferedImage[][] animations;

    static {
        try {
            animations = Util.splitSpriteSheet(ImageIO.read(new File("resources/characters/bullet_sheet.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Bullet(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, int speed) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, speed);
        setAnimations(animations);
    }
}
