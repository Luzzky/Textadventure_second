package Enemies;

import Game.Player;
import Items.Armor.LetherHelmet;
import Items.Weapons.OpSchwert;

import java.util.Random;

public class Golem implements Enemie{

    private int health;
    private int damage;
    private int critChance;
    private int attackStatus = 0;
    private int maxHealth;
    private String name = "Golem";
    private Random rand = new Random();

    public Golem() {
        this.health = 150;
        this.maxHealth = health;
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
    public String dropLoot(Player player) {
        player.getInventory().addGold(20);
        if(rand.nextInt(101) <= 10){
            player.getInventory().addWeapon(new OpSchwert());
            return "20 Gold + Op Schwert";
        } else if (rand.nextInt(101) <= 35) {
            player.getInventory().addArmor(new LetherHelmet());
            return "20 Gold + Leder Helm";
        }
        else {
            return "20 Gold";
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
