package Rooms;

import Game.Player;

public class Raum_zwei implements Room {

    @Override
    public void startRoom(Player player) {
        System.out.println("Raum zwei");
    }

    @Override
    public String roomFXML() {
        return "/Rooms/room_two.fxml";
    }
}
