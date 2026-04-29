package Items.Armor;

public class IronHelmet implements Armor {
    private int armor;
    private String name;
    private String discription;
    private String typ;

    public IronHelmet() {
        typ = "head";
        armor = 20;
        name = "Iron helmet";
        discription = "This is a Iron helm";
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


