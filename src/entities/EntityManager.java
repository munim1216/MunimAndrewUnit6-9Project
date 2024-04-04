package entities;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

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
        ArrayList<Entity> entitiesCollidedWith = collidesWith(entity);

        if (entitiesCollidedWith.isEmpty()) {
            return;
        }

        for (Entity otherEntity : entitiesCollidedWith) {
            dealWithTwoCollisions(entity, otherEntity);
        }
    }

    private void dealWithTwoCollisions(Moveable entity, Entity otherEntity) {
        Rectangle hitbox = entity.getHitbox();
        Rectangle lastHitbox = entity.getLastHitbox();
        Rectangle otherHitbox = otherEntity.getHitbox();

        int dx = lastHitbox.x - hitbox.x;
        int dy = lastHitbox.y - hitbox.y;

        int xAxis;
        int yAxis;
        if (lastHitbox.x <= otherHitbox.x - lastHitbox.width) {
            xAxis = otherHitbox.x - lastHitbox.width;
        } else {
            xAxis = otherHitbox.x + otherHitbox.width;
        }
        if (lastHitbox.y <= otherHitbox.y - lastHitbox.height) {
            yAxis = otherHitbox.y - lastHitbox.height;
        } else {
            yAxis = otherHitbox.y + lastHitbox.height;
        }

        double xAxisT = (double) (xAxis - hitbox.x) / dx;
        double yAxisT = (double) (yAxis - hitbox.y) / dy;

        if (abs(xAxisT) <= abs(yAxisT)) {
            entity.setLocation(xAxis, hitbox.y);
        } else {
            entity.setLocation(hitbox.x, yAxis);
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
        for (Entity entity : entities) {
            if (entity instanceof Processable processable) {
                processable.process();
            }
        }
    }
}
