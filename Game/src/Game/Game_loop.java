package Game;

import Rooms.PlayerAwareController;
import Rooms.RoomAdministration;

public class Game_loop {

    private final Player player;
    private PlayerAwareController currentRoom;
    private final RoomAdministration roomAdmin;

    public Game_loop(Player player, RoomAdministration roomAdmin) {
        this.player = player;
        this.roomAdmin = roomAdmin;
    }

    public void start() {
        System.out.println("Game loop started");
        nextRoom();
    }

    public void nextRoom() {
        currentRoom = roomAdmin.getRandomRoom();
//        currentRoom = roomAdmin.getFXMLRoom("/Rooms/Shop.fxml");
    }

    public String currentRoomFxml() {
        if (currentRoom == null) {
            start();
        }
        return currentRoom.getFXMLPath();
    }

    public Player getPlayer() {
        return player;
    }
}
