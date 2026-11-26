package src;

public class Player extends GameObject {
	    private String name;
	    private int health;

	    public Player(String name, int health, double x, double y, Collidable collider) {
	        super(x, y, collider);
	        setName(name);
	        setHealth(health);
	    }

	    @Override
	    public String getDisplayName() {
	        return name + " (HP: " + health + ")";
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        if (name == null || name.isBlank() || !Character.isUpperCase(name.trim().charAt(0))) {
	            throw new IllegalArgumentException("Ime igraca ne smije biti prazno i mora pocinjati velikim slovom.");
	        }
	        this.name = name.trim();
	    }

	    public int getHealth() {
	        return health;
	    }

	    public void setHealth(int health) {
	        if (health < 0 || health > 100) {
	            throw new IllegalArgumentException("Health igraca mora biti u opsegu [0, 100].");
	        }
	        this.health = health;
    }
}


