package Enemies;

import Game.Player;

public class Zombie implements Enemie {
    private int health;
    private int maxHealth;
    private int damage;
    private int critChance;
    private String name ="Zombie";

    public Zombie() {
        this.health = 100;
        this.maxHealth = health;
        this.damage = 10;
        this.critChance = 10;
    }
    @Override
    public int getHealth() {
        return health;
    }

    public String attack(Player player) {
        int attack = (int) (100 * Math.random() + 1);
        if (attack <= critChance) {
            return ("Zombie attack was Critical - " + player.tageDamage(calculateDamage(1)));
        }
        else {
            return player.tageDamage(calculateDamage(0));
        }
    }

    @Override
    public String takeDamage(int damage) {
        health -= damage;
        return ("Zombie took " + damage + " damage");
    }

    @Override
    public int calculateDamage(int critStatus) {
        if(critStatus == 1) {
            return (int) (damage * Math.random() + damage);
        }
        else {
            return (int) (damage * Math.random() + 1);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }
}
