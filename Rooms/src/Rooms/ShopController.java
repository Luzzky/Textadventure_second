package Rooms;


import Items.*;
import Game.Inventory;
import Game.Player;
import Items.ItemAdministration;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ShopController implements PlayerAwareController{

    public TableView shopTableView;
    public Label playerHealthLabel;
    public Label playerGoldLable;
    public Label discriptionLable;
    public Button buyButton;
    public Button nextRoomButton;
    public Button inventoryButton;
    public Button buyAndEquipButton;
    private Player player;
    private RoomAdministration administration;
    private Inventory inventory;
    private ItemAdministration itemAdministration;
    private ListProperty<Items> tableItems = new SimpleListProperty<>();

    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        this.player = player;
        this.administration = administration;
        this.inventory = player.getInventory();
        itemAdministration = new ItemAdministration();
        setShopItems();
        updateShop();
    }

    private void updateShop() {
        playerHealthLabel.setText("Leben: " + player.getHealth() + "/" + player.getMaxHealth());
        playerGoldLable.setText("Gold: " + inventory.getGold());
    }

    private void setShopItems() {
        tableItems.setAll(itemAdministration.getRandomItems(5));
        shopTableView.setItems(tableItems); // funktionirt nicht
    }

    @Override
    public String getFXMLPath() {
        return "/Rooms/Shop.fxml";
    }

    @Override
    public void updateHealthLabel() {

    }
}
