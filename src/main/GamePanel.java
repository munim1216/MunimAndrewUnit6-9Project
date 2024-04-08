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
    private Gun gun;
    private Path2D.Double path2d;
    private GameUIManager uiManager;
    // THE GAME TILES
    private TileManager tm;
    // entity manager
    private EntityManager em;
    private GameState gameState;

    public GamePanel() {
        // setting up size of the panel
        this.setPreferredSize(new Dimension(TILE_SIZE * MAX_SCREEN_COL, TILE_SIZE * MAX_SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setBackground(BaseUI.BEIGE);

        gameState = GameState.MAIN_MENU;

        keyH = new KeyHandler();
        this.addKeyListener(keyH);
        Player.setKeyH(keyH);
        Weapon.setKeyH(keyH);

        mouseH = new MouseHandler(this);
        this.addMouseListener(mouseH);
        this.setFocusable(true);
        uiManager = new GameUIManager(mouseH);
        Gun.setMouseH(mouseH);

        BaseUI.setUIManager(uiManager);
        MainMenu.setGp(this);
        new MainMenu();

        em = new EntityManager();
        Entity.setEntityManager(em);

        tm = new TileManager();

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
        int deltasSinceEnemy = 0;

        while (gameThread != null) {
            // system.nanotime is java's very accurate clock or something (i dont 100% remember)
            currentTime = System.nanoTime();

            // the time between now and the least time this looped
            delta += (double) (currentTime - previousTime) / drawInterval;

            previousTime = currentTime;
            if (delta >= 1) {
                // delta being 1 or greater means 1/60 of a second;
                if (gameState == GameState.PLAYING) {
                    em.process();
                    deltasSinceEnemy++;
                    if (keyH.isEscKeyPressed()) {
                        new ExitGameBox();
                        gameState = GameState.UI;
                    }
                }
                if (gameState == GameState.UI || gameState == GameState.MAIN_MENU) {
                    uiManager.processUI();
                    if (uiManager.isCurrentUIEmpty()) {
                        gameState = GameState.PLAYING;
                    }
                }
                repaint();
                delta = 0;
            }
            if (deltasSinceEnemy > 60 && gameState == GameState.PLAYING) {
                deltasSinceEnemy = 0;
                try {
                    new Enemy(300, 300, null, 48, 48, 48, 48, EntityType.MOB, (int) (Math.random() * 10) + 6, new AnimatedSprite(ImageIO.read(new File("resources/characters/demon_eye_thing_sprite_sheet.png"))), 100, 100);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        if (gameState == GameState.UI || gameState == GameState.PLAYING) {
            tm.draw(g2D);
        }

        if (gameState == GameState.PLAYING || gameState == GameState.UI) {
//            g2D.setColor(Color.BLACK);
//            g2D.drawLine(gun.getMousePoint().x, gun.getMousePoint().y, gun.getPlayerPoint().x, gun.getPlayerPoint().y);
//            g2D.setColor(Color.BLUE);
//            g2D.drawLine(gun.getMousePoint().x, gun.getMousePoint().y, gun.getRightTriangle().x, gun.getRightTriangle().y);
//            g2D.setColor(Color.RED);
//            g2D.drawLine(gun.getPlayerPoint().x, gun.getPlayerPoint().y, gun.getRightTriangle().x, gun.getRightTriangle().y);
//            g2D.setColor(Color.YELLOW);
//            g2D.drawLine(gun.getBulletPoint().x, gun.getBulletPoint().y, gun.getMousePoint().x, gun.getMousePoint().y);
//            em.drawHitbox(g2D);
            em.draw(g2D);
        }

        if (gameState == GameState.UI || gameState == GameState.MAIN_MENU) {
            uiManager.drawUI(g2D);
        }
    }

    public void startGame() {
        try {
            gameState = GameState.PLAYING;
            testPlayer = new Player(250, 250, "Andrenee", 24, 48, 48, 48, EntityType.PLAYER, 2, new AnimatedSprite(ImageIO.read(new File("resources/characters/renee_sprite_sheet.png"))),1,1);
            Weapon.setPlayer(testPlayer);
            new Stationary(400, 400, "block", 48, 48, 48, 48, EntityType.STATIONARY, new StaticSprite(ImageIO.read(new File("resources/characters/treaszure!.jpg"))));
            new Stationary(400, 450, "block", 48, 48, 48, 48, EntityType.STATIONARY, new StaticSprite(ImageIO.read(new File("resources/characters/treaszure!.jpg"))));
            new Stationary(0, 0, "tree", 48 * 15, 48, 0, 0, EntityType.STATIONARY, new StaticSprite(null));
            new Stationary(0, 48, "tree", 48, 48 * 11, 0, 0, EntityType.STATIONARY, new StaticSprite(null));
            new Stationary(48, 48 * 11, "tree", 48 * 15, 48, 0, 0, EntityType.STATIONARY, new StaticSprite(null));
            new Stationary(48 * 15, 0, "tree", 48, 48 * 11, 0, 0, EntityType.STATIONARY, new StaticSprite(null));
            gun = new Gun(null, 0, 0, 48, 48, new AnimatedSprite(ImageIO.read(new File("resources/characters/gun_sprite_sheet.png"))),10, 30, 36);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
