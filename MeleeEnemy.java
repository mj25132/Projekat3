package src;

public class MeleeEnemy extends Enemy {
	    public MeleeEnemy(String type, int damage, int health, double x, double y, Collidable collider) {
	        super(type, damage, health, x, y, collider);
	    }

	    @Override
	    public int attack() {
	        return damage;
    }
}

