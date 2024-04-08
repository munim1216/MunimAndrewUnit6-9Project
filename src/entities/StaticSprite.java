package entities;

import java.awt.image.BufferedImage;

public class StaticSprite extends Sprite {
    private BufferedImage sprite;

    public StaticSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }


    @Override
    BufferedImage currentSprite() {
        return sprite;
    }

    @Override
    void nextSprite() {
    }

    @Override
    void switchSpriteType(int typeOfSprite) {
    }
}
