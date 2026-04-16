package Game;

import Enemies.Enemie;

public interface Player {
    int getHealth();
    String tageDamage(int health);
    String attackOne(Enemie enemie);
    String attackTwo(Enemie enemie);
    String attackThree(Enemie enemie);
    String applyStatus(String[] awnsers);
    void setHelth(int heal);
    int getMaxHealth();
    int getDefend();
    void resetTurnStatus();
}
