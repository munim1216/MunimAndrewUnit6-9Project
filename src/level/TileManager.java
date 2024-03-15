package level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileManager {
    private Tile[][] currentMap;
    // TEST SPRITES
    private BufferedImage one, two, three;
    private boolean isReady;
    public TileManager() {
        currentMap = new Tile[12][16];
        isReady = false;
        try {
            one = ImageIO.read(new File("resources/tiles/TEST1.png"));
            two = ImageIO.read(new File("resources/tiles/TEST2.png"));
            three = ImageIO.read(new File("resources/tiles/TEST3.png"));
            importMap("resources/maps/testmap");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2D) {
        if (currentMap != null) {
            for (int y = 0; y < currentMap.length; y++) {
                for (int x = 0; x < currentMap[0].length; x++) {
                    g2D.drawImage(currentMap[y][x].getSprite(), x * 48, y * 48, 48, 48, null);
                }
            }
        }
    }

    private void importMap(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String nextLine = br.readLine();
            int nextRow = 0;
            while (nextLine != null) {
                String[] values = nextLine.split(",");
                for (int nextCol = 0; nextCol < values.length; nextCol++) {
                    BufferedImage sprite = null;
                    TileType type = null;
                    switch (Integer.parseInt(values[nextCol])) {
                        case 0 -> {
                            sprite = one;
                            type = TileType.TEST1;
                        }
                        case 1 -> {
                            sprite = two;
                            type = TileType.TEST2;
                        }
                        case 2 -> {
                            sprite = three;
                            type = TileType.TEST3;
                        }
                    }
                    System.out.println("CURRENT COL: " + nextCol + sprite);
                    currentMap[nextRow][nextCol] = new Tile(sprite, type);

                }
                nextLine = br.readLine();
                nextRow++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        isReady = true;
        System.out.println("\n\n\n");
        for(Tile[] a : currentMap) {
            for (Tile b : a) {
                if (b != null) {
                    System.out.print(b.getSprite() + " ");
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }
}
