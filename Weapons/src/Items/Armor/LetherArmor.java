package Items.Armor;

public class LetherArmor implements Armor {

    private int armor;
    private String name;
    private String discription;
    private String typ;
    private int price;
    private String itemType;

    public LetherArmor() {
        typ = "body";
        armor = 30;
        name = "Leder Harnish";
        discription = "This is a Leather Harnish";
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
    public String getType() {
        return itemType;
    }

    @Override
    public String toString(){
        return name;
    }
}



