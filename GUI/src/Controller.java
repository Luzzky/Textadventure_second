import Game.Game_loop;
import Game.Player_one;
import Rooms.RoomAdministration;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;

public class Controller {
    private final Player_one playerOne = new Player_one();
    private final RoomAdministration roomAdministration = new RoomAdministration();
    private final Game_loop game = new Game_loop(playerOne, roomAdministration);


    public void sceneSwitch(ActionEvent actionEvent) {
        game.start();
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        roomAdministration.switchToRoom(game.currentRoomFxml(), scene, game.getPlayer(), roomAdministration);
    }
}
