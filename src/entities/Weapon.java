package entities;

import main.KeyHandler;
import main.MouseHandler;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Weapon extends Entity implements Processable {
    private static MouseHandler mouseH;
    private static KeyHandler keyH;
    private static Player player;
    private int damage;
    private int cooldown;
    private int timeUntilResetCooldown;
    private Sprite sprite;
    private int spriteFrame; // the column in the 2d array of animations
    private int typeOfSprite; // the row in the 2d array of animations, each row a different type of sprite
    private Direction dir;
    // THESE POINTS ARE ONLYT FOR TESTING PURPOSES PUBLIC TODO WHEN YOU'RE DONE FIX THEM
    public Point mousePoint = new Point(0,0);
    public Point playerPoint = new Point(0,0);
    public Point rightTriangle = new Point(0,0);
    public double angle = 0.0;
    AffineTransform rotate = new AffineTransform();

    public Weapon(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, Sprite sprite, int damage, int cooldown) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, null);
        this.sprite = sprite;
        this.damage = damage;
        this.cooldown = cooldown;
        timeUntilResetCooldown = 0;
        dir = Direction.LEFT;
        spriteFrame = 0;
        typeOfSprite = 0;
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
                System.out.println("shoot!");
            } else {
                System.out.println("cooling down!");
            }
        }

        mousePoint = mouseH.getMouseLocation();
        playerPoint = (Point) player.getLocation().clone();
        playerPoint.y += player.getSpriteHeight() / 2;
        playerPoint.x += player.getSpriteWidth() / 4;
        rightTriangle = new Point(playerPoint.x, mousePoint.y);

        double rt2Mx = 0.0;
        double rt2Py = 0.0;

        boolean below = false;
        boolean left = false;

        rt2Mx = Math.abs(rightTriangle.x - mousePoint.x);
        if (rightTriangle.x > mousePoint.x) {
            left = true;
            dir = Direction.RIGHT;
        } else if (rightTriangle.x < mousePoint.x) {
            dir = Direction.LEFT;
        }

        rt2Py = Math.abs(rightTriangle.y - playerPoint.y);
        if (rightTriangle.y > playerPoint.y) {
            below = true;
        }

        angle = Math.toRadians(90) - Math.atan(rt2Mx / rt2Py);

        if (below && left) {
            angle = Math.toRadians(180) + angle;
        } else if (left) {
            angle = Math.toRadians(180) - angle;
        } else if (below) {
            angle = Math.toRadians(360) - angle;
        }

        setLocation((playerPoint.x + 12), (playerPoint.y));
    }

    @Override
    public void draw(Graphics2D g2D) {
        rotate.setToRotation(-angle, playerPoint.x, playerPoint.y);
        AffineTransform composition = AffineTransform.getTranslateInstance(getX(), getY());
        composition.preConcatenate(rotate);
        BufferedImage currentFrame = sprite.currentSprite();

//        if (dir == Direction.LEFT) {
//            g2D.drawImage(currentFrame, getLocation().x, getLocation().y, getSpriteWidth(), getSpriteHeight(), null);
//        } else if (dir == Direction.RIGHT) {
//            g2D.drawImage(currentFrame, getLocation().x, getLocation().y, getSpriteWidth(), -getSpriteHeight(), null);
//        }
        g2D.drawImage(currentFrame, composition, null);
        g2D.draw(rotate.createTransformedShape(getHitbox()));
    }
}
