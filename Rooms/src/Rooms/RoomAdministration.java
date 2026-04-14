package Rooms;

import Game.Game_loop;
import Game.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RoomAdministration {

    private List<Room> rooms;
    private Random rand = new Random();
    private String currentRoomFXML;
    private String lastRoomFXML;
    private int roomNumber = 1;


    public RoomAdministration() {
        rooms = new ArrayList<Room>();
        Room room_eins = new Raum_eins();
        rooms.add(room_eins);
        Room room_zwei = new Raum_zwei();
        rooms.add(room_zwei);
    }

    public Room getRandomRoom(){
        return rooms.get(rand.nextInt(rooms.size()));
    }

    public void setCurrentRoomFXML(String currentRoomFXML) {
        this.currentRoomFXML = currentRoomFXML;
    }

    public String getCurrentRoomFXML() {
        return currentRoomFXML; // current room wird nicht gescpreichert --> fürt zu null in last room
    }
    public String getLastRoomFXML() {
        return lastRoomFXML;
    }

    public void randomDifferentNextRoom(Scene scene, Player player, RoomAdministration administration) {
        Room room;
        int status = 0;

        do {
            room = getRandomRoom();
            if (!Objects.equals(room.roomFXML(), currentRoomFXML)) {
                status++;
                switchToRoom(room.roomFXML(), scene, player, administration);
            }
        }
        while(status == 0);

        roomNumber++;
    }


    public void switchToRoom(String fxmlPath, Scene scene, Player player, RoomAdministration administration) {

        try {
            URL resource = getClass().getResource(fxmlPath);
            if (resource == null) {
                throw new IllegalStateException("FXML nicht gefunden: " + fxmlPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Parent roomView = loader.load();

            Object roomController = loader.getController();
            if (roomController instanceof PlayerAwareController playerAwareController) {
                playerAwareController.setPlayer(player, administration);
            }

            Stage stage = (Stage) scene.getWindow();
            stage.getScene().setRoot(roomView);

            lastRoomFXML = currentRoomFXML;
            currentRoomFXML = fxmlPath;

        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden von " + fxmlPath, e);
        }
    }


    public void switchToFailScreen(Scene scene, Player player, RoomAdministration administration) {
        switchToRoom("/Rooms/FailScreen.fxml", scene, player, administration);
    }

    public int getRoomNumber(){
        return roomNumber;
    }
}
