package src;


public class RectangleCollider implements Collidable {
	    private double x;
	    private double y;
	    private double width;
	    private double height;

	    public RectangleCollider(double x, double y, double width, double height) {
	        if (width <= 0 || height <= 0) {
	            throw new IllegalArgumentException("Sirina i visina kolajdera moraju biti vece od 0.");
	        }
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }

	    @Override
	    public boolean intersects(Collidable other) {
	        if (other == null) {
	            throw new IllegalArgumentException("Drugi kolajder ne moze biti null.");
	        }
	        boolean overlapX = this.x < other.getX() + other.getWidth() &&
	                           this.x + this.width > other.getX();
	        boolean overlapY = this.y < other.getY() + other.getHeight() &&
	                           this.y + this.height > other.getY();
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
	        return width;
	    }

	    @Override
	    public double getHeight() {
	        return height;
	    }

	    public void setPosition(double x, double y) {
	        this.x = x;
	        this.y = y;
	    }
	}


