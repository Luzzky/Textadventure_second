package Game;

import Enemies.Enemie;

public class Player_one implements Player {

    private int health;
    private int attackDamage;
    private int critChance = 25;

    public Player_one() {
        health = 100;
        attackDamage = 10;
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
            return ("Your attack was Critical - " + enemie.takeDamage(attackDamage*2));
        }
        else {
            return enemie.takeDamage(attackDamage);
        }
    }
}
