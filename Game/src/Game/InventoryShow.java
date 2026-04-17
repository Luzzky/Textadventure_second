package Game;

import Items.Consumables.Consumable;
import Rooms.PlayerAwareController;
import Rooms.RoomAdministration;
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
        roomController.updateHealthLabel();
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
            }
            updateInventory();

        }
    }

    public void closeInventory(ActionEvent actionEvent) {
        Stage stage = (Stage) itemList.getScene().getWindow();
        stage.close();
    }
}
