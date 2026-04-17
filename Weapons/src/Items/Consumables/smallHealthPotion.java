package Items.Consumables;

public class smallHealthPotion implements Consumable {
    private String name;
    private int power;
    private String discription;

    public smallHealthPotion() {
        name = "small Health Potion";
        power = 30;
        discription = "This is a small health potion";
    }

    @Override
    public String consume() {
        return "heal,30";
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
    public String toString() {
        return name;
    }
}
