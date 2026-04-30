package Rooms;

import Game.Game_loop;
import Game.Player;
import Game.Player_one;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FailScreenController implements PlayerAwareController{
    public Label statusLable;
    public Button restartRoomButton;
    private RoomAdministration roomAdministration;
    private Player player;


    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        statusLable.setText("You`ve just lost the fight");
        roomAdministration = administration;
        this.player = player;
        restartRoomButton.setDisable(true);

    }

    @Override
    public String getFXMLPath() {
        return "/Rooms/FailScreen.fxml";
    }

    @Override
    public void updateWindow() {

    }

    @Override
    public void updateHealthLabel() {

    }

    //richtige leben nach restart fixen dann disable aufheben
    public void restartRoom(ActionEvent actionEvent) {
        player.setHelth(100);
        roomAdministration.switchToRoom(roomAdministration.getLastRoomFXML(), statusLable.getScene(), player, roomAdministration);
    }

    public void exitGame(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void restartGame(ActionEvent actionEvent) {
        Player player = new Player_one();
        Game_loop game = new Game_loop(player, roomAdministration);
        game.start();
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        roomAdministration.restartGame("/Rooms/startscreen.fxml", scene, player, roomAdministration);
    }
}
