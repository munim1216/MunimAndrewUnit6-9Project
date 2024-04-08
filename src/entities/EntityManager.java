package entities;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

public class EntityManager {
    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void add(Entity entity) {
        entities.add(entity);
    }

    public boolean remove(Entity entity) {
        return entities.remove(entity);
    }

    private ArrayList<Entity> collidesWith(Entity entity) {
        ArrayList<Entity> collidesWith = new ArrayList<>();
        for (Entity otherEntity : entities) {
            if (entity.collidesWith(otherEntity)) {
                collidesWith.add(otherEntity);
            }
        }
        return collidesWith;
    }

    public void dealWithCollisions(Moveable entity) {
        for (Entity otherEntity : entities) {
            if (!entity.collidesWith(otherEntity)) {
                continue;
            }
            if (entity instanceof Projectile proj) {
                if (otherEntity instanceof Player) {
                  continue;
                } else if (otherEntity instanceof Character character) {
                    weaponCollision(character, proj);
                } else if (otherEntity instanceof Stationary) {
                    weaponCollision(proj);
                }
                continue;
            }

            if (otherEntity instanceof Projectile) {
                continue;
            }

            dealWithTwoCollisions(entity, otherEntity);
        }
    }

    private void weaponCollision(Character character, Projectile proj) {
        proj.hurt(character);
        proj.die();
    }

    private void weaponCollision(Projectile proj) {
        proj.die();
    }

    private void dealWithTwoCollisions(Moveable entity, Entity otherEntity) {
        Rectangle hitbox = entity.getHitbox();
        Rectangle lastHitbox = entity.getLastHitbox();
        Rectangle otherHitbox = otherEntity.getHitbox();

        if (entity instanceof Projectile) {
            System.out.println("i messed up!");
        }

        if (otherEntity instanceof Projectile) {
            System.out.println("I messed up 2x");
        }

        int dx = lastHitbox.x - hitbox.x;
        int dy = lastHitbox.y - hitbox.y;

        int xAxis;
        int yAxis;
        if (lastHitbox.x <= otherHitbox.x) {
            xAxis = otherHitbox.x - lastHitbox.width;
        } else {
            xAxis = otherHitbox.x + otherHitbox.width;
        }
        if (lastHitbox.y <= otherHitbox.y) {
            yAxis = otherHitbox.y - lastHitbox.height;
        } else {
            yAxis = otherHitbox.y + otherHitbox.height;
        }

        double xAxisT = (double) (xAxis - hitbox.x) / dx;
        double yAxisT = (double) (yAxis - hitbox.y) / dy;

        if (abs(xAxisT) <= abs(yAxisT)) {
            entity.setLocationDuringCollision(xAxis, hitbox.y);
        } else {
            entity.setLocationDuringCollision(hitbox.x, yAxis);
        }
    }

    public void draw(Graphics2D g2D) {
        for (Entity entity : entities) {
            entity.draw(g2D);
        }
    }

    public void drawHitbox(Graphics2D g2D) {
        for (Entity entity : entities) {
            g2D.drawRect(entity.getX(), entity.getY(), entity.getHitbox().width, entity.getHitbox().height);
        }
    }

    public void process() {
        int lastEntity = entities.size();
        for (int i = 0; i < lastEntity; i++) {
            if (entities.get(i) instanceof Processable processable) {
                processable.process();
                if (entities.get(i) instanceof Moveable moveable) {
                    if (moveable.isDead()) {
                        remove(moveable);
                        i--;
                        lastEntity = entities.size();
                    }
                }
            }
        }
    }
}
