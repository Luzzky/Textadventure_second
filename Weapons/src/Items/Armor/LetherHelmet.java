package Items.Armor;

public class LetherHelmet implements Armor {
    private int armor;
    private String name;
    private String discription;
    private String typ;
    private int price;
    private String itemType;
    private int sellValue;

    public LetherHelmet() {
        typ = "head";
        armor = 10;
        name = "Leder helmet";
        sellValue = 15;
        discription = "Leather helmet\n-Protects your head a little bit and blocks 10 damage\n-Sell Value: " + sellValue;
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
    public int getSellValue() {
        return sellValue;
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
