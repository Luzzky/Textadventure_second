package Enemies;

import Game.Player;

public interface Enemie {
    int getHealth();
    String attack(Player player);
    String takeDamage(int damage);
    int calculateDamage(int critStatus);
    String getName();
    int getMaxHealth();
}
