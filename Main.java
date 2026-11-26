package src;

public class Main {
	    public static void main(String[] args) {
	        Collidable r1 = new RectangleCollider(0, 0, 10, 10);
	        Collidable s1 = new SquareCollider(5, 5, 5);
	        Collidable s2 = new SquareCollider(20, 20, 5);

	        System.out.println("Sudar r1 i s1: " + r1.intersects(s1)); // true
	        System.out.println("Sudar r1 i s2: " + r1.intersects(s2)); // false
    }
}


