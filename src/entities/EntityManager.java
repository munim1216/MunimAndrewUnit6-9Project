package entities;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
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
        if (trailingHitbox.x < otherHitbox.x) {
            xAxis = otherHitbox.x;
        } else {
            xAxis = otherHitbox.x + otherHitbox.width;
        }
        if (trailingHitbox.y < otherHitbox.y) {
            yAxis = otherHitbox.y;
        } else {
            yAxis = otherHitbox.y + otherHitbox.height;
        }

        double xAxisT = (double) (xAxis - hitbox.x) / vx;
        double yAxisT = (double) (yAxis - hitbox.y) / vy;

        if (xAxisT < yAxisT) {
            entity.translate((int) (xAxisT * vx), (int) (xAxisT * vy));
        } else {
            entity.translate((int) (yAxisT * vx), (int) (yAxisT * vy));
        }
    }
}
