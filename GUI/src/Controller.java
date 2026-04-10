import Game.Game_loop;
import Game.Player_one;
import Rooms.PlayerAwareController;
import Rooms.RoomAdministration;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Controller {
    private final Player_one playerOne = new Player_one();
    private final RoomAdministration roomAdministration = new RoomAdministration();
    private final Game_loop game = new Game_loop(playerOne, roomAdministration);

    public void test(ActionEvent actionEvent) {
        game.start();
    }

    public void sceneSwitch(ActionEvent actionEvent) {
        switchToRoom(actionEvent, game.currentRoomFxml());
    }

    private void switchToRoom(ActionEvent actionEvent, String fxmlPath) {
        try {
            URL resource = getClass().getResource(fxmlPath);
            if (resource == null) {
                throw new IllegalStateException("FXML nicht gefunden: " + fxmlPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Parent roomView = loader.load();

            Object roomController = loader.getController();
            if (roomController instanceof PlayerAwareController playerAwareController) {
                playerAwareController.setPlayer(game.getPlayer(),roomAdministration);
            }

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.getScene().setRoot(roomView);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden von " + fxmlPath, e);
        }
    }
}
