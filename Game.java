package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies;
    private List<String> eventLog;

    public Game(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Igrac ne moze biti null.");
        }
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        if (enemy == null) {
            throw new IllegalArgumentException("Neprijatelj ne moze biti null.");
        }
        enemies.add(enemy);
        logEvent("Dodat neprijatelj: " + enemy.getDisplayName());
    }

    public List<Enemy> findByType(String type) {
        List<Enemy> result = new ArrayList<>();
        if (type == null || type.isBlank()) {
            return result;
        }
        for (Enemy enemy : enemies) {
            if (enemy.getType().equalsIgnoreCase(type.trim())) {
                result.add(enemy);
            }
        }
        return result;
    }

    public void decreaseHealth(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Kolicina smanjenja health-a ne moze biti negativna.");
        }
        int newHealth = Math.max(0, player.getHealth() - amount);
        player.setHealth(newHealth);
    }

    public List<Enemy> collidingWithPlayer() {
        List<Enemy> colliding = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (player.intersects(enemy)) {
                colliding.add(enemy);
            }
        }
        return colliding;
    }

    public boolean checkCollision(GameObject first, GameObject second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Objekti za provjeru sudara ne mogu biti null.");
        }
        boolean collided = first.intersects(second);
        if (collided) {
            logEvent("Sudar izmedju " + first.getDisplayName() + " i " + second.getDisplayName());
        }
        return collided;
    }

    public void resolveCollisions() {
        List<Enemy> colliding = collidingWithPlayer();
        for (Enemy enemy : colliding) {
            int dmg = enemy.attack();
            decreaseHealth(dmg);
            logEvent("Igrac " + player.getName() + " primio " + dmg +
                     " stete od " + enemy.getDisplayName() +
                     " | Preostali HP: " + player.getHealth());
        }
    }

    private void logEvent(String message) {
        eventLog.add(message);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public List<String> getEventLog() {
        return eventLog;
    }}