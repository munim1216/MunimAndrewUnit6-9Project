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

    public BufferedImage getSprite() {
        return sprite;
    }

    public boolean isCollision() {
        return collision;
    }

    public TileType getTypeOfTile() {
        return typeOfTile;
    }
}
