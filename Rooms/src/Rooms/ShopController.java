package Rooms;


import Items.*;
import Game.Inventory;
import Game.Player;
import Items.Armor.Armor;
import Items.Consumables.Consumable;
import Items.ItemAdministration;
import Items.Weapons.Weapon;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.util.List;

public class ShopController implements PlayerAwareController{

    public TableView<Items> shopTableView;
    public Label playerHealthLabel;
    public Label playerGoldLable;
    public Label discriptionLable;
    public Button buyButton;
    public Button nextRoomButton;
    public Button inventoryButton;
    public Button buyAndEquipButton;
    public TableColumn tableViewCollumItem;
    public TableColumn tableViewCollumPrice;
    public BorderPane boarderPane;
    private Player player;
    private RoomAdministration administration;
    private Inventory inventory;
    private ItemAdministration itemAdministration;
    private final ListProperty<Items> tableItems = new SimpleListProperty<>(FXCollections.observableArrayList());

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
        playerGoldLable.setText("Gold: " + inventory.getGold());
    }

    private void setShopItems() {
        List<Items> randomItems = itemAdministration.getRandomDifferentItems(3);
        tableItems.set(FXCollections.observableArrayList(randomItems));
        shopTableView.setItems(tableItems.get());
        tableViewCollumItem.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableViewCollumPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        System.out.println(tableItems);
    }

    @Override
    public String getFXMLPath() {
        return "/Rooms/Shop.fxml";
    }

    @Override
    public void updateWindow() {
        updateHealthLabel();
        updateShop();
    }

    @Override
    public void updateHealthLabel() {
        playerHealthLabel.setText("Leben: " + player.getHealth() + "/" + player.getMaxHealth());
    }

    public void buySelectedItem(ActionEvent actionEvent) {
        Items item = shopTableView.getSelectionModel().getSelectedItem();
        if(item.getPrice() <= inventory.getGold()) {
            if(item.getType().equals("armor")) {
                inventory.addArmor((Armor)item);
                inventory.addGold(item.getPrice() * (-1) );
            }
            else if(item.getType().equals("weapon")) {
                inventory.addWeapon((Weapon) item);
                inventory.addGold(item.getPrice() * (-1) );
            }
            else if(item.getType().equals("consumable")) {
                inventory.addConsumable((Consumable) item);
                inventory.addGold(item.getPrice() * (-1) );
            }
            tableItems.remove(item);
            discriptionLable.setText(item.getName() + " wurde gekauft");
        }
        else {
            discriptionLable.setText("du hast zu wenig gold um dieses item zu kaufen.");
        }
        updateWindow();

    }

    public void byAndEquipSelectetItem(ActionEvent actionEvent) {
        Items item = shopTableView.getSelectionModel().getSelectedItem();
        if(item.getPrice() <= inventory.getGold()) {
            if(item.getType().equals("armor")) {
                inventory.addArmor((Armor)item);
                inventory.equipArmor((Armor)item);
                inventory.addGold(item.getPrice() * (-1) );
            }
            else if(item.getType().equals("weapon")) {
                inventory.addWeapon((Weapon) item);
                inventory.equipWeapon((Weapon) item);
                inventory.addGold(item.getPrice() * (-1) );
            }
            else if(item.getType().equals("consumable")) {
                inventory.addConsumable((Consumable) item);
                inventory.getPlayer().applyStatus(((Consumable) item).consume());
                inventory.addGold(item.getPrice() * (-1) );
            }
            tableItems.remove(item);
            discriptionLable.setText(item.getName() + " wurde gekauft");
        }
        else {
            discriptionLable.setText("du hast zu wenig gold um dieses item zu kaufen.");
        }
        updateWindow();
    }

    public void nextRoom(ActionEvent actionEvent) {
        Scene scene = boarderPane.getScene();
        administration.randomDifferentNextRoom(scene, player, administration);
    }

    public void showInventory(ActionEvent actionEvent) {
        inventory.open(inventory, this);
    }

    public void updateDiscriptionLabel(MouseEvent mouseEvent) {
        Node clickedNode = (Node) mouseEvent.getSource();
        if (clickedNode instanceof TableView<?>) {
            Items item = (Items) ((TableView<?>) clickedNode).getSelectionModel().getSelectedItem();
            discriptionLable.setText(item.getDiscription());
        }
    }
}
