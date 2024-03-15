package level;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage sprite;
    private boolean collision;
    private int typeOfTile;

    public Tile(BufferedImage image, int typeOfTile) {
        sprite = image;
        this.typeOfTile = typeOfTile;
    }
}
