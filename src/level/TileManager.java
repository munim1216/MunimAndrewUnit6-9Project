package level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileManager {
    private Tile[][] currentMap;
    // TEST SPRITES
    private BufferedImage one, two, three;

    public TileManager() {
        currentMap = new Tile[16][12];
        try {
            one = ImageIO.read(new File("resources/TEST1.png"));
            two = ImageIO.read(new File("resources/TEST2.png"));
            three = ImageIO.read(new File("resources/TEST3.png"));
            importMap("resources/maps/testmap");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2D) {
        for (int y = 0; y < 12; y += 48) {
            for (int x = 0; x < 16; x += 48) {
                g2D
            }
        }
    }

    private void importMap(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String nextLine = br.readLine();
            int nextRow = 0;
            while (nextLine != null) {
                nextLine = br.readLine();
                String[] values = nextLine.split(",");
                for (int i = 0; i < values.length; i++) {
                    BufferedImage sprite = null;
                    TileType type = null;
                    switch (values[i]) {
                        case "0" -> {
                            sprite = one;
                            type = TileType.TEST1;
                        }
                        case "1" -> {
                            sprite = two;
                            type = TileType.TEST2;
                        }
                        case "2" -> {
                            sprite = three;
                            type = TileType.TEST3;
                        }
                    }

                    currentMap[nextRow][i] = new Tile(sprite, type);
                }
                nextRow++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
