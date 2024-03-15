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

        int x = 0;
        int y = 0;

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 16; i++) {
                g2D.drawImage(one, x + (i * 48), y, 48, 48, null);
            }
            y += 144;
        }
        y = 48;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 16; i++) {
                g2D.drawImage(two, x + (i * 48), y, 48, 48, null);
            }
            y += 144;
        }
        y = 48 * 2;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 16; i++) {
                g2D.drawImage(three, x + (i * 48), y, 48, 48, null);
            }
            y += 144;
        }
    }

}
