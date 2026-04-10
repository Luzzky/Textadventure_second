package Enemies;

import Game.Player;

public interface Enemie {
    int getHealth();
    String attack(Player player);
    String takeDamage(int damage);
}
