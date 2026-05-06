package Items.Armor;

public class LetherHelmet implements Armor {
    private int armor;
    private String name;
    private String discription;
    private String typ;
    private int price;
    private String itemType;

    public LetherHelmet() {
        typ = "head";
        armor = 10;
        name = "Leder helmet";
        discription = "This is a Leather helm";
        price = 30;
        itemType = "armor";
    }

    @Override
    public int getArmorValue() {
        return armor;
    }

    @Override
    public String getArmorTyp() {
        return typ;
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
        return itemType;
    }

    @Override
    public String toString(){
        return name;
    }
}
