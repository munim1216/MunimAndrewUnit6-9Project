package entities;

import main.KeyHandler;
import main.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Weapon extends Entity implements Processable {
    private static MouseHandler mouseH;
    private static KeyHandler keyH;
    private static Player player;
    private int damage;
    private int cooldown;
    private int timeUntilResetCooldown;
    private Direction dir;
    // THESE POINTS ARE ONLYT FOR TESTING PURPOSES PUBLIC TODO WHEN YOU'RE DONE FIX THEM
    public Point mousePoint = new Point(0,0);
    public Point playerPoint = new Point(0,0);
    public Point rightTriangle = new Point(0,0);
    public double angle = 0.0;

    public Weapon(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage sprite, int damage, int cooldown) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite);
        this.damage = damage;
        this.cooldown = cooldown;
        timeUntilResetCooldown = 0;
        dir = Direction.DOWN;
    }

    public static void setMouseH(MouseHandler mouseH) {
        Weapon.mouseH = mouseH;
    }
    public static void setKeyH(KeyHandler keyH) {
        Weapon.keyH = keyH;
    }
    public static void setPlayer(Player player) {
        Weapon.player = player;
    }

    public static MouseHandler getMouseH() {
        return mouseH;
    }

    public static Player getPlayer() {
        return player;
    }

    @Override
    public void process() {

        mousePoint = mouseH.getMouseLocation();
        playerPoint = (Point) player.getLocation().clone();
        playerPoint.y += player.getSpriteHeight() / 2;
        playerPoint.x += player.getSpriteWidth() / 4;
        rightTriangle = new Point(playerPoint.x, mousePoint.y);

        double rt2Mx = 0.0;
        double rt2Px = 0.0;

        boolean below = false;
        boolean left = true;

        if (mousePoint.x > rightTriangle.x) {
            rt2Mx = mousePoint.x - rightTriangle.x;
            left = false;
        } else if (mousePoint.x < rightTriangle.x) {
            rt2Mx = rightTriangle.x - mousePoint.x;
        }

        if (playerPoint.y > rightTriangle.y) {
            rt2Px = playerPoint.y - rightTriangle.y;
            below = true;
        } else if (playerPoint.y < rightTriangle.y) {
            rt2Px = rightTriangle.y - playerPoint.y;
        }

        angle = Math.atan(rt2Mx / rt2Px) / 2;
//
//        if (left && below) {
//            angle += Math.toRadians(180);
//        } else if (below) {
//            angle += Math.toRadians(360) - angle;
//        } else if (left) {
//            angle = Math.toRadians(180) - angle;
//        }

        System.out.println("This is the x value!:" + rt2Mx);
        System.out.println("This is the y value!: " + rt2Px);
        System.out.println("This is the angle value!: " + angle);

        setLocation((int) (playerPoint.x + 12), (int) (playerPoint.y));
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.rotate(-angle, playerPoint.getX(), playerPoint.getY());
        super.draw(g2D);
        g2D.rotate(angle, playerPoint.getX(), playerPoint.getY());

    }
}
