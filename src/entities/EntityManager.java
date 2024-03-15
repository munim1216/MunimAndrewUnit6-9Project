package entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities;
    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public ArrayList<Entity> collidesWith(Entity entity) {
        ArrayList<Entity> collidesWith = new ArrayList<>();
        for (Entity otherEntity : entities) {
            if (entity.collidesWith(otherEntity)) {
                collidesWith.add(entity);
            }
        }

        return collidesWith;
    }

    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager();
        GameCharacter gameCharacter = new GameCharacter(1,1,"1",1,1,EntityType.MOB, new BufferedImage[][]{}, 1, 1, 1);
        GameCharacter gameCharacter1 = new GameCharacter(1,1,"1",1,1,EntityType.MOB, new BufferedImage[][]{}, 1, 1, 1);
        GameCharacter gameCharacter2 = new GameCharacter(1,1,"1",1,1,EntityType.MOB, new BufferedImage[][]{}, 1, 1, 1);
        GameCharacter gameCharacter3 = new GameCharacter(1,1,"1",1,1,EntityType.MOB, new BufferedImage[][]{}, 1, 1, 1);

        entityManager.addEntity(gameCharacter);
        entityManager.addEntity(gameCharacter1);
    }
}
