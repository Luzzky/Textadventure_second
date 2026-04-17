package Game;

import Items.Armor.Armor;
import Items.Consumables.Consumable;
import Items.Armor.LetherHelmet;
import Items.Consumables.smallHealthPotion;
import Items.Weapons.Fists;
import Items.Weapons.Weapon;
import Rooms.PlayerAwareController;
import Rooms.RoomAdministration;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;

public class Inventory {

    private Player player;
    private ListProperty<Weapon> weapons = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ListProperty<Armor> armors = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ListProperty<Consumable> consumables = new SimpleListProperty<>(FXCollections.observableArrayList());
    private int gold;

    public Inventory(Player player) {
        gold = 10;
        weapons.add(new Fists());
        armors.add(new LetherHelmet());
        consumables.add(new smallHealthPotion());
        this.player = player;
    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }

    public void addArmor(Armor armor){
        armors.add(armor);
    }

    public void addConsumable(Consumable consumable){
        consumables.add(consumable);
    }

    public ListProperty<Weapon> getWeapons() { return weapons; }
    public ListProperty<Armor> getArmors() { return armors; }
    public ListProperty<Consumable> getConsumables() { return consumables; }
    public int getGold() { return gold; }

    public void open(Inventory inventory, PlayerAwareController con) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/Game/InventoryShow.fxml"));
            javafx.scene.Parent root = loader.load();
            Game.InventoryShow controller = loader.getController();
            controller.setInventory(inventory, con);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Inventory");
            stage.setScene(new Scene(root));
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer() { return player; }
}
