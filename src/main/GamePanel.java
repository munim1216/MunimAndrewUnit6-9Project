package main;

import level.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import entities.*;
public class GamePanel extends JPanel implements Runnable {
    public static int tile_size = 48; // default tile size is 48
    private int scale; // plans to use this to allow for window resizing

    public static final int MAX_SCREEN_COL = 16; // used for how to draw tiles
    public static final int MAX_SCREEN_ROW = 12;

    // GAME LOOP
    private Thread gameThread;
    // TRACKING INPUT
    private KeyHandler keyH;
    private MouseHandler mouseH;
    // TEST VARIABLES
    private Player player;
    // THE GAME TILES
    private TileManager tm;
    // entity manager
    private EntityManager manager;
    private Stationary box;
    public GamePanel() {
        // setting up size of the panel
        this.setPreferredSize(new Dimension(tile_size * MAX_SCREEN_COL, tile_size * MAX_SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        keyH = new KeyHandler();
        this.addKeyListener(keyH);

        mouseH = new MouseHandler(this);
        this.addMouseListener(mouseH);
        this.setFocusable(true);

        tm = new TileManager();
        try { // TESTING
            player = new Player(250, 250, "Munim", 48, 48, EntityType.PLAYER, 2, ImageIO.read(new File("resources/characters/renee_sprite_sheet.png")),1,1, keyH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        manager = new EntityManager();
        try {
            box = new Stationary(350, 400, "block", 48, 48, EntityType.STATIONARY, ImageIO.read(new File("resources/characters/blackbox.jpeg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager.addEntity(box);
        manager.addEntity(player);
        startGameThread();
        setUpWindow();
    }

    @Override
    public void run() {
        // variables needed to ensure its locked at 60 fps and below
        long currentTime = System.nanoTime();
        long previousTime = currentTime;
        double delta = 0.0;
        int FPS = 60;
        double drawInterval = 1000000000.0 / FPS;

        while (gameThread != null) {
            // system.nanotime is java's very accurate clock or something (i dont 100% remember)
            currentTime = System.nanoTime();

            // the time between now and the least time this looped
            delta += (double) (currentTime - previousTime) / drawInterval;

            previousTime = currentTime;
            if (delta >= 1) {
                // delta being 1 or greater means 1/60 of a second;
                player.processInput();
                manager.dealWithCollisions(player);
                repaint();
                delta = 0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        tm.draw(g2D);
        // mouse handler test code
        g2D.drawLine(player.getPoint().x, player.getPoint().y, mouseH.getMouseLocation().x, mouseH.getMouseLocation().y);
        g2D.drawRect(player.getPoint().x, player.getPoint().y, player.getHitbox().width, player.getHitbox().height);
        player.draw(g2D);
        box.draw(g2D);
    }

    private void setUpWindow() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D GAME");
        window.add(this);
        window.pack();
        window.setVisible(true);
    }

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
}
