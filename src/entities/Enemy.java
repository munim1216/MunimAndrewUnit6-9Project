package entities;

public class Enemy extends Character implements  Processable{
    public Enemy(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, int speed, Sprite sprite, int health, int damage) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, speed, sprite, health, damage);
    }

    @Override
    public void process() {

    }

}
