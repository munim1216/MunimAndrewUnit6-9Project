package level;

import java.awt.image.BufferedImage;


public class Tile {

    public final TileType TYPE_OF_TILE;

    public Tile(TileType typeOfTile) {
        this.TYPE_OF_TILE = typeOfTile;
    }

    public BufferedImage getSprite() {
        return TYPE_OF_TILE.SPRITE;
    }

}
