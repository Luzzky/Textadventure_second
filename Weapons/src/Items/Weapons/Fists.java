package Items.Weapons;

public class Fists implements Weapon{

    private int baseDamage;
    private int baseCrit;
    private String discription;
    private String attackOneName = "Punch";
    private String attackTwoName = "Block";
    private String attackThreeName = "Leerer atk slot";
    private String name = "Fists";


    public Fists(){
        this.baseDamage = 10;
        this.baseCrit = 25;
        this.discription = "Fists\n-Punch: dose some damage\n-Block: blocks some damage and increases crit chance for one turn";
    }
    @Override
    public int attackOne() {
        int critStatus;

        int attack = (int) (100 * Math.random() + 1);
        if (attack <= baseCrit) {
            critStatus = 1;
        }
        else {
            critStatus = 0;
        }

        this.baseCrit = 25;

        if(critStatus == 1) {
            return (int) (baseDamage * Math.random() + baseDamage);
        }
        else {
            return (int) ((double) baseDamage /2 * Math.random() + (double) baseDamage /2);
        }
    }

    @Override
    public int attackTwo() {
        return -1;
    }

    @Override
    public int attackThree() {
        return 0;
    }

    @Override
    public String statusAttack() {
        this.baseCrit = 75;
        return "defend,10,1"; // 5 defens für eine runde
    }

    @Override
    public String getAttackOneName() {
        return attackOneName;
    }

    @Override
    public String getAttackTwoName() {
        return attackTwoName;
    }

    @Override
    public String getAttackThreeName() {
        return attackThreeName;
    }

    @Override
    public String getDiscription() {
        return discription;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
