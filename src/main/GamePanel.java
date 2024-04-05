package main;

import level.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;

import entities.*;
import ui.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int TILE_SIZE = 48; // default tile size is 48
    private int scale; // plans to use this to allow for window resizing

    public static final int MAX_SCREEN_COL = 16; // used for how to draw tiles
    public static final int MAX_SCREEN_ROW = 12;

    // GAME LOOP
    private Thread gameThread;
    // TRACKING INPUT
    private KeyHandler keyH;
    private MouseHandler mouseH;
    // TEST VARIABLES
    private Player testPlayer;
    private Path2D.Double path2d;
    private GameUIManager uiManager;
    // THE GAME TILES
    private TileManager tm;
    // entity manager
    private EntityManager em;
  
    public GamePanel() {
        // setting up size of the panel
        this.setPreferredSize(new Dimension(TILE_SIZE * MAX_SCREEN_COL, TILE_SIZE * MAX_SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        path2d = new Path2D.Double();
        path2d.moveTo(100,100);
        path2d.lineTo(500,500);

        keyH = new KeyHandler();
        this.addKeyListener(keyH);
        Player.setKeyH(keyH);

        mouseH = new MouseHandler(this);
        this.addMouseListener(mouseH);
        this.setFocusable(true);
        uiManager = new GameUIManager(mouseH);
        Gun.setMouseH(mouseH);

        BaseUI.setUIManager(uiManager);

        new ExitGameBox();

        tm = new TileManager();
        em = new EntityManager();
        Entity.setEntityManager(em);

        try { // TESTING
            testPlayer = new Player(250, 250, "Andrenee", 24, 48, 48, 48, EntityType.PLAYER, 2, ImageIO.read(new File("resources/characters/renee_sprite_sheet.png")),1,1);
            new Stationary(400, 400, "block", 48, 48, 48, 48, EntityType.STATIONARY, ImageIO.read(new File("resources/characters/treaszure!.jpg")));
            new Gun(0, 0, null, 0, 0, 0, 0, null,10, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                em.process();
                uiManager.processUI();
                if (path2d.intersects(testPlayer.getHitbox())) {
                    System.out.println("Intersecrting");
                }
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
        g2D.drawLine(testPlayer.getLocation().x + testPlayer.getHitbox().width / 2, testPlayer.getLocation().y, mouseH.getMouseLocation().x, mouseH.getMouseLocation().y);
        g2D.setColor(Color.YELLOW);
        g2D.drawLine(100, 100, 500, 500);
        em.draw(g2D);
        em.drawHitbox(g2D);
        uiManager.drawUI(g2D);
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
