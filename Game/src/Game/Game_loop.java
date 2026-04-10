package Game;

import Rooms.Room;
import Rooms.RoomAdministration;

public class Game_loop {

    private final Player player;
    private Room currentRoom;
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
        currentRoom.startRoom(player);
    }

    public String currentRoomFxml() {
        if (currentRoom == null) {
            start();
        }
        return currentRoom.roomFXML();
    }

    public Player getPlayer() {
        return player;
    }
}
