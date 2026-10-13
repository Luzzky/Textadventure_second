package Items.Consumables;

public class smallHealthPotion implements Consumable {
    private String name;
    private int power;
    private String discription;
    private int price;
    private String type;
    private int sellValue;

    public smallHealthPotion() {
        name = "small Health Potion";
        power = 30;
        sellValue = 10;
        discription = "small health potion\n-Heals the Player for 30 helth\n-Sell Value: " + sellValue;
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
    public int getSellValue() {
        return sellValue;
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
