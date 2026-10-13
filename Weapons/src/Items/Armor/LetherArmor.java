package Items.Armor;

public class LetherArmor implements Armor {

    private int armor;
    private String name;
    private String discription;
    private String typ;
    private int price;
    private String itemType;
    private int sellValue;

    public LetherArmor() {
        typ = "body";
        armor = 30;
        name = "Leder Harnish";
        sellValue = 25;
        discription = "Leather Harnish\n-Protects your body a little bit and blocks 30 Damage\n-Sell Value: " + sellValue;
        price = 50;
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



