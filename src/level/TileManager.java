package level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileManager {
    private Tile[][] currentMap;
    private BufferedImage[] tileSprites;
    public TileManager() {
        currentMap = new Tile[12][16];
        tileSprites = new BufferedImage[13]; // number to be changed as more sprites are made
        importMap("resources/maps/testmap");
    }
    public void draw(Graphics2D g2D) {
        for (int y = 0; y < currentMap.length; y++) {
            for (int x = 0; x < currentMap[0].length; x++) {
                System.out.println(currentMap[y][x].getSprite());
                g2D.drawImage(TileType.GRASS1.SPRITE, x * 48, y * 48, 48, 48, null);
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
                    currentMap[nextRow][nextCol] = new Tile(typeAssigner(Integer.parseInt(values[nextCol])));
                }
                nextLine = br.readLine();
                nextRow++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private TileType typeAssigner(int type) {
       return switch (type) {
           case 10 -> TileType.GRASS1;
           case 11 -> TileType.GRASS2;
           case 12 -> TileType.GRASS3;
           case 13 -> TileType.GRASS4;
           case 14 -> TileType.GRASS5;
           case 15 -> TileType.GRASS6;
           case 16 -> TileType.GRASS7;
           case 17 -> TileType.GRASS8;
           case 18 -> TileType.GRASS9;
           case 19 -> TileType.TREES1;
           case 20 -> TileType.TREES2;
           case 21 -> TileType.TREES3;
           case 22 -> TileType.TREES4;
           default -> throw new IllegalStateException("Unexpected value: " + type);
       };
    }
}
