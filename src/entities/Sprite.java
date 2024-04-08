package entities;

import java.awt.image.BufferedImage;

public abstract class Sprite {
    abstract BufferedImage currentSprite();

    abstract void nextSprite();

    abstract void switchSpriteType(int typeOfSprite);
}
