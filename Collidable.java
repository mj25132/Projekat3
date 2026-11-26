package src;

public interface Collidable {
	    boolean intersects(Collidable other);
	    double getX();
	    double getY();
	    double getWidth();
	    double getHeight();
}


