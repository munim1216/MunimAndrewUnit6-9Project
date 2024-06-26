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
    private Sprite sprite;
    private Direction dir;
    private Point mousePoint;
    private Point playerPoint;
    private Point rightTriangle;
    private double angle;

    public Weapon(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, Sprite sprite, int damage, int cooldown) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, null);
        this.sprite = sprite;
        this.damage = damage;
        this.cooldown = cooldown;
        timeUntilResetCooldown = 0;
        dir = Direction.LEFT;
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

    public Point getMousePoint() {
        return mousePoint;
    }

    public Point getPlayerPoint() {
        return playerPoint;
    }

    public Point getRightTriangle() {
        return rightTriangle;
    }

    public Direction getDir() {
        return dir;
    }

    public static MouseHandler getMouseH() {
        return mouseH;
    }

    public static Player getPlayer() {
        return player;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public void process() {
        mousePoint = mouseH.getMouseLocation();
        playerPoint = (Point) player.getLocation().clone();
        playerPoint.y += player.getSpriteHeight() / 2;
        playerPoint.x += player.getSpriteWidth() / 4;
        rightTriangle = new Point(playerPoint.x, mousePoint.y);

        double rt2Mx = 0.0;
        double rt2Py = 0.0;

        boolean above = false;
        boolean left = false;

        rt2Mx = Math.abs(rightTriangle.x - mousePoint.x);
        if (rightTriangle.x > mousePoint.x) {
            left = true;
            dir = Direction.LEFT;
        } else if (rightTriangle.x < mousePoint.x) {
            dir = Direction.RIGHT;
        }

        rt2Py = Math.abs(rightTriangle.y - playerPoint.y);
        if (rightTriangle.y < playerPoint.y) {
            above = true;
        }

        angle = Math.atan(rt2Py / rt2Mx);



        if (above && left) {
            angle = Math.toRadians(180) + angle;
        } else if (left) {
            angle = Math.toRadians(180) - angle;
        } else if (above) {
            angle = Math.toRadians(360) - angle;
        }

        setLocation((playerPoint.x + 12), (playerPoint.y));

        if (timeUntilResetCooldown >= cooldown - cooldown / 3) {
            sprite.switchSpriteType(1);
        } else {
            sprite.switchSpriteType(0);
        }

        if (timeUntilResetCooldown > 0) {
            timeUntilResetCooldown--;
        }

        if (mouseH.isPressed()) {
            if (timeUntilResetCooldown == 0) {
                timeUntilResetCooldown = cooldown;
                attack();
            }
        }
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.rotate(angle, playerPoint.getX(), playerPoint.getY());

        BufferedImage currentFrame = sprite.currentSprite();

        if (dir == Direction.RIGHT) {
            g2D.drawImage(currentFrame, getLocation().x, getLocation().y, getSpriteWidth(), getSpriteHeight(), null);
        } else if (dir == Direction.LEFT) {
            g2D.drawImage(currentFrame, getLocation().x, getLocation().y, getSpriteWidth(), -getSpriteHeight(), null);
        }
        g2D.rotate(-angle, playerPoint.getX(), playerPoint.getY());

    }

    public void attack() {

    }
}
