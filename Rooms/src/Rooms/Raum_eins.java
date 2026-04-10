package Rooms;

import Game.Player;

public class Raum_eins implements Room {


    @Override
    public void startRoom(Player player) {
        System.out.println("Raum Eins");
    }

    @Override
    public String roomFXML() {
        return "/Rooms/room_one.fxml";
    }
}
