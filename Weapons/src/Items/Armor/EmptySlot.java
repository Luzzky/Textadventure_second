package Items.Armor;

public class EmptySlot implements Armor{

    String name;
    String type;
    String discription;
    private int price;

    public EmptySlot() {

        name = "Leerer Slot";
        type = "empty";
        discription = "Hier kann ein item ausgerüstet werden";
        price = 0;
    }
    @Override
    public int getArmorValue() {
        return 0;
    }

    @Override
    public String getArmorTyp() {
        return type;
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
        return "empty";
    }
}
