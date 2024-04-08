package entities;

public class Gun extends Weapon {

    public Gun(String name, int hitboxX, int hitboxY, int spriteX, int spriteY, Sprite sprite, int damage, int cooldown) {
        super(getPlayer().getX() + 20, getPlayer().getY() + 20, name, hitboxX, hitboxY, spriteX, spriteY, EntityType.WEAPON, sprite, damage, cooldown);
    }
}
