package level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public enum TileType {
    GRASS1(0,0),
    GRASS2(16,0),
    GRASS3(32,0),
    GRASS4(48,0),
    GRASS5(64,0),
    GRASS6(80,0),
    GRASS7(96,0),
    GRASS8(112,0),
    GRASS9(128,0),
    TREES1(0,16),
    TREES2(16,16),
    TREES3(32,16),
    TREES4(48,16);

    public final BufferedImage SPRITE;

    TileType (int x, int y) {
        BufferedImage sprite1 = null;
        try {
            sprite1 = ImageIO.read(new File("resources/tiles/project_sprites_v1.png"));
            sprite1 = sprite1.getSubimage(x, y, 16,16);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SPRITE = sprite1;
    }
}
