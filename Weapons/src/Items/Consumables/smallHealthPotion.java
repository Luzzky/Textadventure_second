package Items.Consumables;

public class smallHealthPotion implements Consumable {
    private String name;
    private int power;
    private String discription;
    private int price;
    private String type;

    public smallHealthPotion() {
        name = "small Health Potion";
        power = 30;
        discription = "This is a small health potion";
        price = 20;
        type = "consumable";
    }

    @Override
    public String consume() {
        System.out.println("Healpotion consumed");
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
    public int getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
