package entities;

import java.awt.image.BufferedImage;

public class Stationary extends Entity {
    private BufferedImage sprite;
    public Stationary(int x, int y, String name, int rectangleX, int rectangleY, EntityType type, BufferedImage sprite) {
        super(x, y, name, rectangleX, rectangleY, type);

        this.sprite = sprite;
    }
}
