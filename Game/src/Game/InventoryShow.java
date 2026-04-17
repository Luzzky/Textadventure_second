package Game;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import Items.*;

import javax.naming.ldap.Control;

public class InventoryShow {

    public ListView weaponsView;
    public ListView armorView;
    public ListView ConsumableView;
    public Label discriptionText;
    @FXML
    private VBox itemList;

    private Inventory inventory;

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        updateInventory();
    }

    private void updateInventory() {
        weaponsView.setItems(inventory.getWeapons());
        armorView.setItems(inventory.getArmors());
        ConsumableView.setItems(inventory.getConsumables());

    }

    public void listedViewShowItemDiscription(MouseEvent mouseEvent) {
        Node clickedNode = (Node) mouseEvent.getSource();
        if (clickedNode instanceof ListView) {
            Items item = (Items) ((ListView<?>) clickedNode).getSelectionModel().getSelectedItem();
            discriptionText.setText(item.getDiscription());
        }
    }
}
