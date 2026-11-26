package src;

public abstract class Enemy extends GameObject implements Attacker {
	    protected String type;
	    protected int damage;
	    protected int health;

	    public Enemy(String type, int damage, int health, double x, double y, Collidable collider) {
	        super(x, y, collider);
	        setType(type);
	        setDamage(damage);
	        setHealth(health);
	    }

	    @Override
	    public String getDisplayName() {
	        return type + " [HP: " + health + ", DMG: " + attack() + "]";
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        if (type == null || type.isBlank()) {
	            throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan.");
	        }
	        this.type = type.trim();
	    }

	    public int getDamage() {
	        return damage;
	    }

	    public void setDamage(int damage) {
	        if (damage < 0) {
	            throw new IllegalArgumentException("Damage ne moze biti negativan.");
	        }
	        this.damage = damage;
	    }

	    public int getHealth() {
	        return health;
	    }

	    public void setHealth(int health) {
	        if (health < 0 || health > 100) {
	            throw new IllegalArgumentException("Health neprijatelja mora biti u opsegu [0, 100].");
	        }
	        this.health = health;
    }
}

