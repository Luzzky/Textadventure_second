package Game;

import Enemies.Enemie;

public class Player_one implements Player {

    private int maxHealth;
    private int health;
    private int damage;
    private int critChance = 25;

    public Player_one() {
        health = 100;
        maxHealth = health;
        damage = 10;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String tageDamage(int damage) {
        health -= damage;
        return ("you took " + damage + " damage");
    }

    @Override
    public String attack(Enemie enemie) {
        int attack = (int) (100 * Math.random() + 1);
        if (attack <= critChance) {
            return ("Your attack was Critical - " + enemie.takeDamage(damage *2));
        }
        else {
            return enemie.takeDamage(damage);
        }
    }

    @Override
    public void setHelth(int heal) {
        health = heal;
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
    public int getMaxHealth() {
        return maxHealth;
    }
}
