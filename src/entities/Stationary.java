package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Stationary extends Entity {
    private BufferedImage sprite;
    public Stationary(int x, int y, String name, int rectangleX, int rectangleY, EntityType type, BufferedImage sprite) {
        super(x, y, name, rectangleX, rectangleY, type);

        this.sprite = sprite;
    }

    public void draw(Graphics2D g2D) {
        g2D.drawImage(sprite, getPoint().x, getPoint().y, getHitbox().width, getHitbox().height, null);
    }
}