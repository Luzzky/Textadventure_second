package Rooms;

import Game.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Enemies.*;

public class RoomOneController implements PlayerAwareController {

    public Label enemieHelthLable;
    public Label statusLable;
    @FXML
    private Label healthLabel;
    private Player player;
    private Enemie enemie = new Zombie();
    private RoomAdministration administration;


    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        this.player = player;
        this.administration = administration;
        updateHealthLabel();
        updateEnemieHelthLable();
    }

    @Override
    public String getFXMLPath() {
        return "/Rooms/room_one.fxml";
    }

    @FXML
    public void test(ActionEvent actionEvent) {
        updateHealthLabel();
    }

    private void updateHealthLabel() {
        if (healthLabel == null) {
            return;
        }
        if (player == null) {
            healthLabel.setText("kein player gesetzt");
            return;
        }

        healthLabel.setText("Player Health: " + player.getHealth());

        if(player.getHealth() <= 0) {
            roomfailed(healthLabel.getScene());
        }
    }

    private void updateEnemieHelthLable() {
        if (enemie == null) {
            return;
        }
        if (enemieHelthLable == null) {
            enemieHelthLable.setText("kein enemie gesetzt");
            return;
        }
        enemieHelthLable.setText("Enemie Helth: " + enemie.getHealth());

    }

    public void attack(ActionEvent actionEvent) {
        String text = player.attack(enemie);
        updateEnemieHelthLable();
        text = text + "\nOpponent turn: " + enemieNextMove();
        updateHealthLabel();
        statusLable.setText(text); // erste trunde kein damage
    }

    public String enemieNextMove(){
        return enemie.attack(player);
    }

    private void roomfailed(Scene scene) {
        administration.setCurrentRoomFXML(getFXMLPath());
        administration.switchToFailScreen(scene, player, administration);
    }

    public void skipTurn(ActionEvent actionEvent) {
        enemieNextMove();
        updateHealthLabel();
    }

}
