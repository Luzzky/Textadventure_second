package Rooms;

import Game.Player;

public interface Room {
    void startRoom(Player player);
    String roomFXML();
}
