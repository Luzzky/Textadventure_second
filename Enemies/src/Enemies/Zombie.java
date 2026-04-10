package Enemies;

import Game.Player;

public class Zombie implements Enemie {
    private int health;
    private int damage;
    private int critChance = 10;

    public Zombie() {
        this.health = 100;
        this.damage = 10;
    }
    @Override
    public int getHealth() {
        return health;
    }

    public String attack(Player player) {
        int attack = (int) (100 * Math.random() + 1);
        if (attack <= critChance) {
            return ("Zombie attack was Critical - " + player.tageDamage(damage*2));
        }
        else {
            return player.tageDamage(damage);
        }
    }

    @Override
    public String takeDamage(int damage) {
        health -= damage;
        return ("Zombie took " + damage + " damage");
    }
}
