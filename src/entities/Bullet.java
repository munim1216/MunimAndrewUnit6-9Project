package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet extends Projectile {

    private static Sprite sprite;

    static {
        try {
            sprite = new AnimatedSprite(ImageIO.read(new File("resources/characters/bullet_sheet.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Bullet(Point startingLocation, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, int speed, double angle) {
        super(startingLocation, name, hitboxX, hitboxY, spriteX, spriteY, EntityType.PROJECTILE, speed, angle, sprite);
    }
}
