import Game.Game_loop;
import Game.Player_one;
import Rooms.RoomAdministration;

public class Main {
    public static void main(String[] args) {

        RoomAdministration admin = new RoomAdministration();
        Player_one playerOne = new Player_one();

        Game_loop game = new Game_loop(playerOne, admin);
        game.start();
    }
}
