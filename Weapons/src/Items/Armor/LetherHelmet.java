package Items.Armor;

public class LetherHelmet implements Armor {
    private int armor;
    private String name;
    private String discription;

    public LetherHelmet() {
        armor = 10;
        name = "Leder helmet";
        discription = "This is a Leather helm";
    }

    @Override
    public int getArmorValue() {
        return armor;
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
    public String toString(){
        return name;
    }
}
