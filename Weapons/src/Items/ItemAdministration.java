package Items;

import Items.Armor.*;
import Items.Consumables.*;
import Items.Weapons.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ItemAdministration {

    private List<Items> items;
    private Random rand = new Random();

    public ItemAdministration() {
        items = createAllItems();
    }

    private final List<Supplier<Items>> itemFactories = List.of(
            IronHelmet::new,
            LetherHelmet::new,
            LetherArmor::new,
            smallHealthPotion::new,
            OpSchwert::new
    );

    public List<Items> createAllItems() {
        List<Items> items = new ArrayList<>();
        for (Supplier<Items> itemFactory : itemFactories) {
            items.add(itemFactory.get());
        }
        return items;
    }

    public List<Items> getRandomItems(int ammount) {
        List<Items> randomItems = new ArrayList<>();
        for (int i = 0; i <= ammount; i++) {
            randomItems.add(items.get(rand.nextInt(items.size())));
        }
        return randomItems;
    }

    public List<Items> getRandomDifferentItems(int ammount) {
        List<Items> randomItems = new ArrayList<>();
        Items test;
        for (int i = 0; i < ammount; i++) {
            test = items.get(rand.nextInt(items.size()));
            if(randomItems.contains(test)) {
                i--;
            }
            else{
                randomItems.add(test);
            }
        }
        return randomItems;
    }

}
