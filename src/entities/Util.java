package entities;

import java.awt.image.BufferedImage;

public class Util {

    private Util(){}

    public static BufferedImage[][] splitSpriteSheet(BufferedImage spriteSheet) {
        BufferedImage[][] animations = new BufferedImage[spriteSheet.getHeight() / 64][spriteSheet.getWidth() / 64];
        for (int row = 0; row < spriteSheet.getHeight() / 64; row++) { // number is 64 because for some reason each sprite is upscaled to that in my sprite sheet
            for (int col = 0; col < spriteSheet.getWidth() / 64; col++) {
                animations[row][col] = spriteSheet.getSubimage(col * 64, row * 64, 64, 64);
            }
        }
        return animations;
    }
}
