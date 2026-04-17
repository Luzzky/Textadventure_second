package Rooms;

import Game.Game_loop;
import Game.Player;
import Game.Player_one;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController implements PlayerAwareController, Initializable {
    public Label currentHighscore;
    private Player playerOne = new Player_one();
    private RoomAdministration roomAdministration = new RoomAdministration();
    private final Game_loop game = new Game_loop(playerOne, roomAdministration);


    public void sceneSwitch(ActionEvent actionEvent) {
        game.start();
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        roomAdministration.switchToRoom(game.currentRoomFxml(), scene, game.getPlayer(), roomAdministration);
    }

    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        playerOne = player;
        roomAdministration = administration;
        currentHighscore.setText("Highscore: " + roomAdministration.getHighscore() + " Rooms beaten");
    }

    @Override
    public String getFXMLPath() {
        return "/startScreen.fxml";
    }

    @Override
    public void updateHealthLabel() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentHighscore.setText("Highscore: " + roomAdministration.getHighscore() + " Rooms beaten");
    }
}
