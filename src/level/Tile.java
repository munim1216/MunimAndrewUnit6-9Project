package level;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage sprite;
    private boolean collision;
    private TileType typeOfTile;

    public Tile(BufferedImage image, TileType typeOfTile) {
        sprite = image;
        this.typeOfTile = typeOfTile;
    }
}
