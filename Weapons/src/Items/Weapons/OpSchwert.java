package Items.Weapons;

public class OpSchwert implements  Weapon{

    private final int baseDamage;
    private final int baseCrit;
    private final String discription;
    private String attackOneName = "insta kill";
    private String attackTwoName = "leerer atk slot";
    private String attackThreeName = "Leerer atk slot";
    private String name = "Op Schwert";
    private int price;
    private String type;

    public OpSchwert(){
            this.baseDamage = 50;
            this.baseCrit = 50;
            this.discription = "Op-Schwert\n-insta kill: dose some more damage";
            price = 1000;
            type = "weapon";
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

        if(critStatus == 1) {
            return (int) (baseDamage * Math.random() + baseDamage);
        }
        else {
            return (int) ((double) baseDamage /2 * Math.random() + (double) baseDamage /2);
        }
    }

    @Override
    public int attackTwo() {
        return 0;
    }

    @Override
    public int attackThree() {
        return 0;
    }

    @Override
    public String statusAttack() {
        return "";
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
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDiscription() {
        return discription;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Op Schwert";
    }
}
