package Rooms;

import Game.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Enemies.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;

public class RoomOneController implements PlayerAwareController {

    public Label enemieHelthLable;
    public Label statusLable;
    public Label enemieName;
    public BorderPane pane;
    public Button nextRoomButton;
    public Button inventory;
    public Button attackThree;
    public Button attackTow;
    public Button attackOne;
    public Label roomNumber;
    public ProgressBar playerHealthBar;
    public ProgressBar enimeHealthBar;
    public Label highscore;
    @FXML
    private Label healthLabel;
    private Player player;
    private Enemie enemie;
    private RoomAdministration administration;
    private EnemieAdministration enadministration;


    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        this.player = player;
        this.administration = administration;
        nextRoomButton.setDisable(true);
        nextRoomButton.setVisible(false);
        roomNumber.setText("Room: " + administration.getRoomNumber());
        enadministration = new EnemieAdministration();
        enemie = enadministration.getRandomEnemie();
        enemieName.setText("Enemie: " + enemie.getName());
        highscore.setText("Highscore: " + administration.getHighscore());

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
        playerHealthBar.setProgress((double) player.getHealth() /player.getMaxHealth());

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
        enimeHealthBar.setProgress((double) enemie.getHealth() /enemie.getMaxHealth());

        if(enemie.getHealth() <= 0) {
            nextRoomButton.setVisible(true);
            nextRoomButton.setDisable(false);
            attackOne.setVisible(false);
            attackThree.setVisible(false);
            attackTow.setVisible(false);
            inventory.setVisible(false);
            statusLable.setText("You defeated " + enemie.getName() + "\nyou can now continue your journey");
        }

    }

    public void attack(ActionEvent actionEvent) {
        String text = player.attackOne(enemie);
        updateEnemieHelthLable();
        if(enemie.getHealth() > 0) {
            text = text + "\nOpponent turn: " + enemieNextMove();
            updateHealthLabel();
            statusLable.setText(text);
        }
    }

    public String enemieNextMove(){
        player.resetTurnStatus();
        return enemie.attack(player);
    }

    private void roomfailed(Scene scene) {
        administration.setCurrentRoomFXML(getFXMLPath());
        administration.switchToFailScreen(scene, player, administration);
    }

    public void attackTwo(ActionEvent actionEvent) {
        String text = player.attackTwo(enemie);
        updateEnemieHelthLable();
        if(enemie.getHealth() > 0) {
            text = text + "\nOpponent turn: " + enemieNextMove();
            updateHealthLabel();
            statusLable.setText(text);
        }
    }

    public void nextRoom(ActionEvent actionEvent) {
        Scene scene = pane.getScene();
        administration.randomDifferentNextRoom(scene, player, administration);
    }
}
