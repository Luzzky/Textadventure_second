package Game;

import Items.Armor.Armor;
import Items.Armor.EmptySlot;
import Items.Consumables.Consumable;
import Items.Weapons.Weapon;
import Rooms.PlayerAwareController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import Items.*;
import javafx.stage.Stage;

import java.util.Objects;

public class InventoryShow {

    public ListView weaponsView;
    public ListView armorView;
    public ListView consumableView;
    public Label discriptionText;
    public Label playerHealt;
    public Label playerGold;
    public Button backButton;
    public Button useButton;
    public TabPane inventoryTabPane;
    public Tab consumablesTab;
    public Tab armorTab;
    public Tab weaponTab;
    public Label headWear;
    public Label bodyWear;
    public Label legWear;
    public Label equipedWeapon;
    public Button equipButton;
    public Label blockValue;
    public Button unEquipHead;
    public Button unEquipBody;
    public Button unEquipLeg;
    public Button unEquipWeapon;
    @FXML
    private VBox itemList;

    private Inventory inventory;
    private PlayerAwareController roomController;



    public void setInventory(Inventory inventory, PlayerAwareController roomController) {
        this.inventory = inventory;
        this.roomController = roomController;
        updateInventory();
    }

    private void updateInventory() {
        weaponsView.setItems(inventory.getWeapons());
        armorView.setItems(inventory.getArmors());
        consumableView.setItems(inventory.getConsumables());
        playerGold.setText("Gold: " + inventory.getGold());
        playerHealt.setText("Leben: " + inventory.getPlayer().getHealth() + "/" + inventory.getPlayer().getMaxHealth());
        headWear.setText(inventory.getCurrentEquipedHead().getName());
        bodyWear.setText(inventory.getCurrentEquipedBody().getName());
        legWear.setText(inventory.getCurrentEquipedLeg().getName());
        equipedWeapon.setText(inventory.getCurrentEquipedWeapon().getName());
        roomController.updateHealthLabel();
        blockValue.setText("Block: " + inventory.getComulativArmorValue());
    }

    public void listedViewShowItemDiscription(MouseEvent mouseEvent) {
        Node clickedNode = (Node) mouseEvent.getSource();
        if (clickedNode instanceof ListView) {
            Items item = (Items) ((ListView<?>) clickedNode).getSelectionModel().getSelectedItem();
            discriptionText.setText(item.getDiscription());
        }
    }

    public void useSelectetItem(ActionEvent actionEvent) {
        if(Objects.equals(inventoryTabPane.getSelectionModel().getSelectedItem().getId(), "consumablesTab")) {
            if (consumableView.getSelectionModel().getSelectedItem() != null){
                Consumable item = (Consumable) consumableView.getSelectionModel().getSelectedItem();
                String test = item.consume();
                System.out.println(inventory.getPlayer().applyStatus(test));
                inventory.deleteConsumable(item);
            }
            updateInventory();
        }
    }

    public void closeInventory(ActionEvent actionEvent) {
        Stage stage = (Stage) itemList.getScene().getWindow();
        stage.close();
    }

    public void equipSelectetItem(ActionEvent actionEvent) {
        if(Objects.equals(inventoryTabPane.getSelectionModel().getSelectedItem().getId(), "armorTab")) {
            if(armorView.getSelectionModel().getSelectedItem() != null){
                Armor item = (Armor) armorView.getSelectionModel().getSelectedItem();
                inventory.equipArmor(item);
            }
        }
        else if (Objects.equals(inventoryTabPane.getSelectionModel().getSelectedItem().getId(), "weaponTab")) {
            if(weaponsView.getSelectionModel().getSelectedItem() != null){
                Weapon item = (Weapon) weaponsView.getSelectionModel().getSelectedItem();
                inventory.equipWeapon(item);
            }
        }
        updateInventory();
    }

    public void unequip(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String id = button.getId();
        inventory.unEquip(id);
        updateInventory();
    }
}
