package Items.Weapons;
import Items.*;

public interface Weapon extends Items{
    int attackOne();
    int attackTwo();
    int attackThree();
    String statusAttack();
    String getAttackOneName();
    String getAttackTwoName();
    String getAttackThreeName();
    int getBaseDamage();
}
