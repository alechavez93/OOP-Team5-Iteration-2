package Game;

import Player.Player;
import GameMap.*;
import Utility.Vec2i;

import java.util.ArrayList;

/*--------------------------------------------------------------------------------------
|    Game Class: Created by Kevin on 2/16/17.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Game {

    private static Game singleton = null;
    private MapCoordinate p1Start = new MapCoordinate(1,1);
    private MapCoordinate p2Start = new MapCoordinate(18,18);
    public Player player1;
    public Player player2;
    private Player activePlayer;
    private ArrayList<Player> players;
    private int NUM_PLAYERS;
    private int currentPlayer;
    private boolean gameOver = false;

//    MAP

    private int turnCount;

    public Game(){


        //GameMap.getInstance().initialize(new Vec2i(20,20));
        player1 = new Player(1, p1Start);
        player2 = new Player(2, p2Start);
        activePlayer = player1;
        turnCount = 1;
        currentPlayer = 0;

        this.players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        activePlayer = player1;
        NUM_PLAYERS = players.size();
    }

    public static Game getInstance() {
        if(singleton == null)
            singleton = new Game();
        return singleton;
    }

    public void init(){

    }

    public void changeTurn(){

        activePlayer.endTurn();

        System.out.println("Player " + activePlayer.getpID() + " ended their turn.");

        int loser = endGameCheck();
        if(loser != 0){ endGame(loser); }

        currentPlayer = (currentPlayer+1)%NUM_PLAYERS;
        activePlayer =
                activePlayer == player1?
                player2:player1;

        System.out.println("It is now player " + activePlayer.getpID() + "'s turn");

        if(activePlayer == player1) { turnCount++; }

    }


    public int endGameCheck(){

        for(Player player: players){
            int capitalCount = player.getEntityManager().getCapitalCount();
            if(capitalCount < 1){
                gameOver = true;
                return player.getpID();
            }
        }

        return 0;
    }

    public void endGame(int i){
        // quit game? idk
        System.out.println("Player " + (i) + " has lost the game");
        System.exit(0);
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

    public int getTurnCount() { return turnCount; }
}
