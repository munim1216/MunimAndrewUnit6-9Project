package entities;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class EntityManager {
    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public boolean addEntity(Entity entity) {
        return entities.add(entity);
    }

    public boolean removeEntity(Entity entity) {
        return entities.remove(entity);
    }

    public ArrayList<Entity> collidesWith(Entity entity) {
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

    public void dealWithTwoCollisions(Moveable entity, Entity otherEntity) {
        Rectangle hitbox = entity.getHitbox();
        Rectangle trailingHitbox = entity.getTrailingHitbox();
        Rectangle otherHitbox = otherEntity.getHitbox();


        int vx = trailingHitbox.x - hitbox.x;
        int vy = trailingHitbox.y - hitbox.y;

        int xAxis;
        int yAxis;
        if (trailingHitbox.x <= otherHitbox.x - trailingHitbox.width) {
            xAxis = otherHitbox.x - trailingHitbox.width;
        } else {
            xAxis = otherHitbox.x + otherHitbox.width;
        }
        if (trailingHitbox.y <= otherHitbox.y - trailingHitbox.height) {
            yAxis = otherHitbox.y - trailingHitbox.height;
        } else {
            yAxis = otherHitbox.y + trailingHitbox.height;
        }

        double xAxisT = (double) (xAxis - hitbox.x) / vx;
        double yAxisT = (double) (yAxis - hitbox.y) / vy;

        if (abs(xAxisT) < abs(yAxisT)) {
            entity.translate((int) (xAxisT * vx), (int) (xAxisT * vy));
        } else {
            entity.translate((int) (yAxisT * vx), (int) (yAxisT * vy));
        }
    }
}
