package Game;

import Enemies.Enemie;

public interface Player {
    public int getHealth();
    public String tageDamage(int health);
    public String attack(Enemie enemie);
}
