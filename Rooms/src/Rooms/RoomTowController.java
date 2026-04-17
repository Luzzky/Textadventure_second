package Rooms;

import Game.Player;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RoomTowController implements PlayerAwareController{

    public Label statusLable;
    public Button nextRoom;
    public Button pass;
    public Button drink;
    public Label playerLife;
    public Label roomNumber;
    public Label highscore;
    private Player player;
    private RoomAdministration administration;

    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        this.player = player;
        this.administration = administration;
        updtePlayerLife();
        nextRoom.setVisible(false);
        roomNumber.setText("Room: " + administration.getRoomNumber());
        highscore.setText("Highscore: " + administration.getHighscore());

    }

    @Override
    public String getFXMLPath() {
        return "/Rooms/room_two.fxml";
    }

    private void updtePlayerLife() {
        playerLife.setText("Spieler 1 Leben: " + player.getHealth() + " / " + player.getMaxHealth());
    }

    public void nextRoom(ActionEvent actionEvent) {
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        administration.randomDifferentNextRoom(scene, player, administration);
    }

    public void pass(ActionEvent actionEvent) {
        statusLable.setText("Du entscheidest dich dazu nichts von dem wasser zu trinken, wer weiß was da drin ist...");
        nextRoom.setVisible(true);
        drink.setDisable(true);
        pass.setDisable(true);
    }

    public void drink(ActionEvent actionEvent) {
        int healedLife;
        drink.setDisable(true);
        pass.setDisable(true);
        nextRoom.setVisible(true);
        if(player.getHealth() == player.getMaxHealth()){
            statusLable.setText("Du trinkst was von dem wasser...\nnichts passiert.");
        }
        else {
            player.setHelth(player.getHealth() + 30);
            if (player.getHealth() > player.getMaxHealth()) {
                healedLife = 30 - (player.getHealth() - player.getMaxHealth());
                player.setHelth(player.getMaxHealth());
                statusLable.setText("Du trinkst was von dem wasser und spürst wie dich neues leben durchströmt\n- Du hast " + healedLife + " Leben geheilt - ");

            } else {
                statusLable.setText("Du trinkst was von dem wasser und spürst wie dich neues leben durchströmt\n- Du hast 30 Leben geheilt - ");
            }
        }
        updtePlayerLife();
    }
}


