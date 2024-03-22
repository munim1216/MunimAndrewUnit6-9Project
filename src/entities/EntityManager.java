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
        Rectangle entityHitbox = entity.getHitbox();
        Rectangle entityTrailingHitbox = entity.getTrailingHitbox();
        Rectangle otherEntityHitbox = otherEntity.getHitbox();

        if ()
    }
}
