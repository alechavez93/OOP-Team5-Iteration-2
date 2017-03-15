package Game;

import Entity.NONE;
import GameLibrary.GameLibrary;
import Player.Player;
import GameMap.*;
import Utility.Vec2i;

import java.awt.*;
import java.util.ArrayList;

/*--------------------------------------------------------------------------------------
|    Game Class: Created by Kevin on 2/16/17.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Game {

    private static Game singleton = null;
    private MapCoordinate p1Start;
    private MapCoordinate p2Start;
    public Player player1;
    public Player player2;
    private Player activePlayer;
    private ArrayList<Player> players;
    private int NUM_PLAYERS;
    private int currentPlayer;
    private boolean gameOver = false;
    private CyclingState state;

//    MAP

    private int turnCount;

    public Game(){

        p1Start = new MapCoordinate(2,7);
        p2Start = new MapCoordinate(10,15);
        //GameMap.getInstance().initialize(new Vec2i(20,20));
        player1 = new Player(1, "Logan", p1Start);
        player1.setColor(new Color(0,0,255));
        player2 = new Player(2, "Wade", p2Start);
        player2.setColor(new Color(255,0,0));
        turnCount = 1;
        currentPlayer = 0;

        this.players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        activePlayer = player1;
        NUM_PLAYERS = players.size();
    }

    public void setState(CyclingState state){
        this.state = state;
        System.out.println(state);
    }

    public static Game getInstance() {
        if(singleton == null)
            singleton = new Game();
        return singleton;
    }

    public void init(){

    }

    public void changeTurn(){

        System.out.println(state);
        //Change Player

        activePlayer.getFogOfWar().calculateVisibility(activePlayer.getEntityManager().getAllEntities());

        if(activePlayer == player1)
            activePlayer = player2;
        else if(activePlayer == player2)
            activePlayer = player1;


        System.out.println(activePlayer.getName());
        //Update State
        state.inTurn = activePlayer;
        state.gameMode = GameLibrary.UNIT_MODE;
        state.modeType = GameLibrary.COLONIST;
        if(state.inTurn.getEntityManager().getColonistList().size()>0)
            state.selectedEntity = state.inTurn.getEntityManager().getColonistList().get(0);
        else state.selectedEntity = new NONE();
        state.selectedCommand = GameLibrary.REINFORCE;


//        activePlayer.endTurn();
//
//        System.out.println("Player " + activePlayer.getpID() + " ended their turn.");
//
//        int loser = endGameCheck();
//        if(loser != 0){ endGame(loser); }
//
//        currentPlayer = (currentPlayer+1)%NUM_PLAYERS;
//        activePlayer =
//                activePlayer == player1?
//                player2:player1;
//
//        System.out.println("It is now player " + activePlayer.getpID() + "'s turn");
//
//        if(activePlayer == player1) { turnCount++; }

    }


    public void endGameCheck(){

        for(Player player: players){
            int settlerCount = player.getEntityManager().getColonistUnitCount();
            int capitalCount = player.getEntityManager().getCapitalCount();
            if(capitalCount + settlerCount < 1){
                gameOver = true;
                System.out.println("someone lost the game");
                endGame();
                //
            }
        }
    }

    public void endGame(){
        // quit game? idk
        System.out.println("A Player has lost the game");
        System.exit(0);
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

    public int getTurnCount() { return turnCount; }

}
