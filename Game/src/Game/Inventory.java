package Game;

import Items.Armor.*;
import Items.Consumables.Consumable;
import Items.Consumables.smallHealthPotion;
import Items.Weapons.Fists;
import Items.Weapons.OpSchwert;
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
    private Armor currentEquipedHead = new EmptySlot();
    private Armor currentEquipedBody = new EmptySlot();
    private Armor currentEquipedLeg = new EmptySlot();
    private Weapon currentEquipedWeapon = new Fists();

    public Inventory(Player player) {
        gold = 100;
        consumables.add(new smallHealthPotion());
        this.player = player;
    }

    public void addGold(int gold) {
        this.gold += gold;
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

    public void deleteConsumable(Consumable consumable){
        consumables.remove(consumable);
    }

    public boolean equipArmor(Armor armor){
        String typ = armor.getArmorTyp();
        switch(typ){
            case "head":
                if(!currentEquipedHead.getArmorTyp().equals("empty")){
                    armors.add(currentEquipedHead);
                }
                armors.remove(armor);
                currentEquipedHead = armor;
                return true;
            case "body":
                if(!currentEquipedBody.getArmorTyp().equals("empty")){
                    armors.add(currentEquipedBody);
                }
                armors.remove(armor);
                currentEquipedBody = armor;
                return true;
            case "leg":
                if(!currentEquipedLeg.getArmorTyp().equals("empty")){
                    armors.add(currentEquipedLeg);
                }
                armors.remove(armor);
                currentEquipedLeg = armor;
                return true;
            default:
                return false;
        }
    }

    public void unEquip(String slot){
        switch(slot){
            case "unEquipHead":
                if(!currentEquipedHead.getArmorTyp().equals("empty")){
                    armors.add(currentEquipedHead);
                    currentEquipedHead = new EmptySlot();
                }
                break;
            case "unEquipBody":
                if(!currentEquipedBody.getArmorTyp().equals("empty")){
                    armors.add(currentEquipedBody);
                    currentEquipedBody = new EmptySlot();
                }
                break;
            case "unEquipLeg":
                if(!currentEquipedLeg.getArmorTyp().equals("empty")){
                    armors.add(currentEquipedLeg);
                    currentEquipedLeg = new EmptySlot();
                }
                break;
            case "unEquipWeapon":
                if(!currentEquipedWeapon.getName().equals("Fists")){
                    weapons.add(currentEquipedWeapon);
                    currentEquipedWeapon = new Fists();
                }
                break;
        }
    }

    public void equipWeapon(Weapon weapon){
        weapons.add(currentEquipedWeapon);
        weapons.remove(weapon);
        currentEquipedWeapon = weapon;
    }

    public Armor getCurrentEquipedHead() {
        return currentEquipedHead;
    }
    public Armor getCurrentEquipedBody() {
        return currentEquipedBody;
    }
    public Armor getCurrentEquipedLeg() {
        return currentEquipedLeg;
    }
    public Weapon getCurrentEquipedWeapon(){
        return currentEquipedWeapon;
    }
    public ListProperty<Weapon> getWeapons() { return weapons; }
    public ListProperty<Armor> getArmors() { return armors; }
    public ListProperty<Consumable> getConsumables() { return consumables; }
    public int getGold() { return gold; }



    public int getComulativArmorValue(){
        return currentEquipedBody.getArmorValue()+currentEquipedHead.getArmorValue()+currentEquipedLeg.getArmorValue();
    }

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
