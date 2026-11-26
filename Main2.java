package src;

public class Main2 {
    public static void main(String[] args) {
	        Player player = new Player("Marko", 100, 10, 10, new SquareCollider(10, 10, 20));
	        Game game = new Game(player);

	        Enemy goblin = new MeleeEnemy("Goblin", 15, 60, 15, 15, new RectangleCollider(15, 15, 10, 10));
	        Enemy dragon = new BossEnemy("Dragon", 25, 100, 100, 100, new SquareCollider(100, 100, 30));

	        game.addEnemy(goblin);
	        game.addEnemy(dragon);

	        game.resolveCollisions();

	        System.out.println("HP igraca nakon sudara: " + player.getHealth()); // 85
	        System.out.println("Pronadjeni goblin-i: " + game.findByType("goblin").size()); // 1
	        for (String log : game.getEventLog()) {
	            System.out.println(log);
        }
    }
}

