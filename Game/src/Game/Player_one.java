package Game;

import Enemies.Enemie;
import Items.Weapons.Fists;
import Items.Weapons.Weapon;

import java.util.ArrayList;
import java.util.Collections;

public class Player_one implements Player {

    private int maxHealth;
    private int health;
    private int damage;
    private int critChance;
    private Weapon weapon;
    private Inventory inventory;
    private int[] defend = new int[]{0,0}; //blockt damage für eine runde erste stelle die höhe des blocks und zweite stelle wie viele runden es noch hält
    private ArrayList<int[]> statusEffects = new ArrayList<>(Collections.singletonList(defend)); // beinhaltet alle temporären status effekt

    public Player_one() {
        health = 100;
        maxHealth = health;
        damage = 10;
        critChance = 25;
        weapon = new Fists();
        inventory = new Inventory(this);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String tageDamage(int enimeDamage) {

        enimeDamage = enimeDamage - inventory.getComulativArmorValue();
        enimeDamage = enimeDamage - defend[0];

        if(enimeDamage <= 0) {
            return ("you've blocked all damage");
        }
        else if(defend[0] != 0){
            health -= enimeDamage;
            return ("you've blocked " + defend[0] + " and took " + enimeDamage + " damage");
        }
        else {
            health -= enimeDamage;
            return ("you took " + enimeDamage + " damage");
        }
    }

    @Override
    public String attackOne(Enemie enemie) {
        int damage = weapon.attackOne();
        if(damage > weapon.getBaseDamage()){
            return (weapon.getAttackOneName() + " was Critical - " + enemie.takeDamage(damage));
        }
        else{
            return enemie.takeDamage(damage);
        }
    }

    @Override
    public String attackTwo(Enemie enemie) {
        int damage = weapon.attackTwo();
        if(damage == -1){
            String status = weapon.statusAttack();
            return applyStatus(status);
        }
        else{
            if(damage > weapon.getBaseDamage()){
                return (weapon.getAttackOneName() + " was Critical - " + enemie.takeDamage(damage));
            }
            else{
                return enemie.takeDamage(damage);
            }
        }
    }

    @Override
    public String attackThree(Enemie enemie) {
        return "";
    }
    @Override
    public String applyStatus(String awnsersIN){
        String[] awnsers = awnsersIN.split(",");
        switch (awnsers[0]){
            case "defend":
                this.defend[0] = Integer.parseInt(awnsers[1]);
                this.defend[1] = Integer.parseInt(awnsers[2]);
                return "you used Your hands to block damage this round";
            case "heal":
                this.health += Integer.parseInt(awnsers[1]);
                if(health > maxHealth){
                    health = maxHealth;
                }
                return "you healed " + health + " health";
        }
        return "Something went wrong with status";
    }

    @Override
    public void setHelth(int heal) {
        health = heal;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getDefend() {
        return defend[0];
    }

    @Override
    public void resetTurnStatus() {
        for(int i = 0; i < statusEffects.size(); i++){ //geht alle status effekte dur
            if(statusEffects.get(i)[1] > 0){            //schaut ob der effekt noch länger als null runden halten soll
                statusEffects.get(i)[1]--;
            }
            else{
                statusEffects.get(i)[0] = 0;            // wenn die runden zeit abgelaufen ist wird der status effekt wieder auf null gesetzt
            }
        }
    }

    @Override
    public Weapon getweapon() {
        return weapon;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
