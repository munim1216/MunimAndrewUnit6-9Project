package entities;

public class Stationary extends Entity {
    public Stationary(int x, int y, String name, int hitboxX, int hitboxY, int spriteX, int spriteY, EntityType type, Sprite sprite) {
        super(x, y, name, hitboxX, hitboxY, spriteX, spriteY, type, sprite);
    }

    @Override
    public void draw(Graphics2D g2D) {
        if (getSprite() != null) {
            super.draw(g2D);
        }
    }
}
