package Game;

/*--------------------------------------------------------------------------------------
|    Game Class: Created by Kevin on 2/16/17.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Game {

    private static Game singleton = null;

    private Player player1;
    private Player player2;
    private Player activePlayer;

//    MAP

    private int turnCount;

    private Game(){

        player1 = new Player();
        player2 = new Player();
        activePlayer = player1;

        turnCount = 0;

//      MAP
    }

    public static Game getInstance() {
        if(singleton == null)
            singleton = new Game();
        return singleton;
    }

    public void changeTurn(){

        activePlayer =
                activePlayer == player1?
                player2:player1;
    }

    public Player getActivePlayer(){
        return activePlayer;
    }
}
