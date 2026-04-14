package Rooms;

import Game.Player;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class FailScreenController implements PlayerAwareController{
    public Label statusLable;
    private RoomAdministration roomAdministration;
    private Player player;


    @Override
    public void setPlayer(Player player, RoomAdministration administration) {
        statusLable.setText("You`ve just lost the fight");
        roomAdministration = administration;
        this.player = player;

    }

    @Override
    public String getFXMLPath() {
        return "/Rooms/FailScreen.fxml";
    }

    public void restartRoom(ActionEvent actionEvent) {
        player.setHelth(100);
        roomAdministration.switchToRoom(roomAdministration.getLastRoomFXML(), statusLable.getScene(), player, roomAdministration);
    }

    public void exitGame(ActionEvent actionEvent) {
        System.exit(0);
    }
}
