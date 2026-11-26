package src;

public class SquareCollider implements Collidable {
	    private double x;
	    private double y;
	    private double side;

	    public SquareCollider(double x, double y, double side) {
	        if (side <= 0) {
	            throw new IllegalArgumentException("Stranica kvadrata mora biti veca od 0.");
	        }
	        this.x = x;
	        this.y = y;
	        this.side = side;
	    }

	    @Override
	    public boolean intersects(Collidable other) {
	        if (other == null) {
	            throw new IllegalArgumentException("Drugi kolajder ne moze biti null.");
	        }
	        boolean overlapX = this.x < other.getX() + other.getWidth() &&
	                           this.x + this.side > other.getX();
	        boolean overlapY = this.y < other.getY() + other.getHeight() &&
	                           this.y + this.side > other.getY();
	        return overlapX && overlapY;
	    }

	    @Override
	    public double getX() {
	        return x;
	    }

	    @Override
	    public double getY() {
	        return y;
	    }

	    @Override
	    public double getWidth() {
	        return side;
	    }

	    @Override
	    public double getHeight() {
	        return side;
	    }

	    public void setPosition(double x, double y) {
	        this.x = x;
	        this.y = y;
	   }
}


