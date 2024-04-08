package entities;

import java.awt.image.BufferedImage;

public class AnimatedSprite extends Sprite {
    private BufferedImage[][] sprites;
    private int typeOfSprite; // the row in the 2d array of animations, each row a different type of sprite
    private int spriteFrame; // the column in the 2d array of animations

    public AnimatedSprite(BufferedImage spriteSheet) {
        this.sprites = new BufferedImage[spriteSheet.getHeight() / 64][spriteSheet.getWidth() / 64];
        for (int row = 0; row < spriteSheet.getHeight() / 64; row++) { // number is 64 because for some reason each sprite is upscaled to that in my sprite sheet
            for (int col = 0; col < spriteSheet.getWidth() / 64; col++) {
                sprites[row][col] = spriteSheet.getSubimage(col * 64, row * 64, 64, 64);
            }
        }
        typeOfSprite = 0;
        spriteFrame = 0;
    }

    @Override
    BufferedImage currentSprite() {
        return sprites[typeOfSprite][spriteFrame];
    }

    @Override
    void nextSprite() {
        spriteFrame++;
        spriteFrame %= sprites[0].length;
    }

    @Override
    void switchSpriteType(int typeOfSprite) {
        this.typeOfSprite = typeOfSprite;
        spriteFrame = 0;
    }
}
