package entities;

import main.KeyHandler;
import main.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Weapon extends Entity implements Processable {
    private int damage;
    private int cooldown;
    private int timeUntilResetCooldown;
    private static MouseHandler mouseH;
    private static KeyHandler keyH;
    private static Player player;

    public Weapon(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, BufferedImage sprite, int damage, int cooldown) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite);
        this.damage = damage;
        this.cooldown = cooldown;
        timeUntilResetCooldown = 0;
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
        Point mousePoint = mouseH.getMouseLocation();
        Point playerPoint = player.getLocation();
        Point rightTriangle = new Point(playerPoint.x, mousePoint.y);
        double side1 = rightTriangle.y - playerPoint.y;
        double side2 = Math.sqrt(mousePoint.x * mousePoint.x + mousePoint.y * mousePoint.y);
        double angle1 = side1 / side2;
        double angle2 = 180 - 90 - angle1;

        System.out.println(angle2);

        setLocation((int) (playerPoint.x + 24), (int) (playerPoint.y));
    }
}
