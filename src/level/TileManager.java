package level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileManager {
    private Tile[][] currentMap;
    // TEST SPRITES
    private BufferedImage one, two, three;

    public TileManager() {
        try {
            one = ImageIO.read(new File("resources/TEST1.png"));
            two = ImageIO.read(new File("resources/TEST2.png"));
            three = ImageIO.read(new File("resources/TEST3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2D) {
        g2D.drawImage(one, 20, 20, 48, 48,null);
        g2D.drawImage(two, 60, 60, 48, 48, null);
        g2D.drawImage(three, 200, 200, 48, 48, null);
    }

}
