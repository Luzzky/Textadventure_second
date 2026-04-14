package Enemies;

import Game.Player;

public class Golem implements Enemie{

    private int health;
    private int damage;
    private int critChance;
    private int attackStatus = 0;
    private String name = "Golem";

    public Golem() {
        this.health = 150;
        this.damage = 20;
        this.critChance = 20;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String attack(Player player) {
        if(attackStatus == 1) {
            attackStatus = 0;
            int attack = (int) (100 * Math.random() + 1);
            if (attack <= critChance) {
                return ("Golem attack was Critical - " + player.tageDamage(calculateDamage(1)));
            } else {
                return player.tageDamage(calculateDamage(0));
            }
        }
        else{
            attackStatus++;
            return ("Golem attacks next turn");
        }
    }

    @Override
    public String takeDamage(int damage) {
        health -= damage;
        return ("Golem took " + damage + " damage");
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
}
