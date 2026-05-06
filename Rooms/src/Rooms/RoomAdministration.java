package Rooms;

import Enemies.Enemie;
import Enemies.RandomCollection;
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
import java.util.Random;

public class RoomAdministration {

    private List<PlayerAwareController> roomControllers = new ArrayList<>();
    private Random rand = new Random();
    private String currentRoomFXML;
    private String lastRoomFXML;
    private int roomNumber = 1;
    private int highscore;
    private RandomCollection<PlayerAwareController> rc = new RandomCollection<>();

    public RoomAdministration() {

        rc.add(80, new RoomOneController());
        rc.add(30, new RoomTowController());

        roomControllers.add(new RoomOneController());
        roomControllers.add(new RoomTowController());
    }

    public PlayerAwareController getRandomRoom(){
        return rc.next();
    }

    public PlayerAwareController getFXMLRoom(String roomFXML){
        for (PlayerAwareController roomController : roomControllers) {
            String path = roomController.getFXMLPath();
           if(path.equals(roomFXML)){
               return roomController;
           }
        }
        return null;
    }

    public void setCurrentRoomFXML(String currentRoomFXML) {
        this.currentRoomFXML = currentRoomFXML;
    }

    public String getCurrentRoomFXML() {
        return currentRoomFXML;
    }
    public String getLastRoomFXML() {
        return lastRoomFXML;
    }

    public void randomDifferentNextRoom(Scene scene, Player player, RoomAdministration administration) {
        PlayerAwareController room;
        int status = 0;
        if((roomNumber + 1)%5 == 0){
            switchToRoom("/Rooms/Shop.fxml", scene, player, administration);
            setHighscore(roomNumber);
            roomNumber++;
        }
        else {
           do {
                room = getRandomRoom();
               if(room.getFXMLPath().equals("/Rooms/room_two.fxml") && currentRoomFXML.equals("/Rooms/room_two.fxml")){
                //es soll nicht zweimal hintereinander room teo kommen können
               }
               else{
                   status++;
                   setHighscore(roomNumber);
                   roomNumber++;
                   switchToRoom(room.getFXMLPath(), scene, player, administration);
               }
            }
            while (status == 0);
        }

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

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setHighscore(int score){
        if(score > getHighscore()){
            this.highscore = score;
        }
    }

    public int getHighscore(){
        return highscore;
    }

    public void restartGame(String fxml, Scene scene, Player player, RoomAdministration administration) {
        setRoomNumber(0);
        switchToRoom(fxml, scene, player, administration);
    }
}
