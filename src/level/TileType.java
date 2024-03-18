package level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public enum TileType {
    GRASS1(0,0,false),
    GRASS2(16,0,false),
    GRASS3(32,0,false),
    GRASS4(48,0,false),
    GRASS5(64,0,false),
    GRASS6(80,0,false),
    GRASS7(96,0,false),
    GRASS8(112,0,false),
    GRASS9(128,0,false),
    TREES1(0,16, true),
    TREES2(16,16, true),
    TREES3(32,16, true),
    TREES4(48,16, true);

    public final BufferedImage SPRITE;
    public final boolean COLLISION;

    TileType (int x, int y, boolean collision) {
        this.COLLISION = collision;
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
