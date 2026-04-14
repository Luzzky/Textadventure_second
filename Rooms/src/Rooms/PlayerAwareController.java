package Rooms;

import Game.Player;

public interface PlayerAwareController {
    void setPlayer(Player player, RoomAdministration administration);
    String getFXMLPath();
}
