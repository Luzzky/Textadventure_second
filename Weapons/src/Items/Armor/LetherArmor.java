package Items.Armor;

public class LetherArmor implements Armor {

    private int armor;
    private String name;
    private String discription;
    private String typ;

    public LetherArmor() {
        typ = "body";
        armor = 30;
        name = "Leder Harnish";
        discription = "This is a Leather Harnish";
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
    public String toString(){
        return name;
    }
}



