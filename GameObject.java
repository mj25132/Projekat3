package src;

public abstract class GameObject {
	    protected double x;
	    protected double y;
	    protected Collidable collider;

	    public GameObject(double x, double y, Collidable collider) {
	        if (collider == null) {
	            throw new IllegalArgumentException("Kolajder ne moze biti null.");
	        }
	        this.x = x;
	        this.y = y;
	        this.collider = collider;
	        syncColliderPosition();
	    }

	    public abstract String getDisplayName();

	    public boolean intersects(GameObject other) {
	        if (other == null) {
	            throw new IllegalArgumentException("Drugi objekat ne moze biti null.");
	        }
	        return this.collider.intersects(other.collider);
	    }

	    protected void syncColliderPosition() {
	        if (collider instanceof RectangleCollider rc) {
	            rc.setPosition(this.x, this.y);
	        } else if (collider instanceof SquareCollider sc) {
	            sc.setPosition(this.x, this.y);
	        }
	    }

	    public double getX() {
	        return x;
	    }

	    public double getY() {
	        return y;
	    }

	    public void setPosition(double x, double y) {
	        this.x = x;
	        this.y = y;
	        syncColliderPosition();
	    }

	    public Collidable getCollider() {
	        return collider;
    }
}


