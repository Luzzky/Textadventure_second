package Items.Armor;

public class IronHelmet implements Armor {
    private int armor;
    private String name;
    private String discription;
    private String typ;
    private int price;
    private String itemType;
    private int sellValue;

    public IronHelmet() {
        typ = "head";
        armor = 20;
        name = "Iron helmet";
        price = 50;
        itemType = "armor";
        sellValue = 25;
        discription = "Iron helmet\n-Protects Your head and Blocks 20 damage\n-Sell Value: " + sellValue;
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


