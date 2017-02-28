package GameTests;

import Entity.Structure.CapitalStructure;
import Game.Game;
import GameMap.*;
import Utility.Vec2i;

/**
 * Created by Thomas on 02/26/2017.
 */

/*--------------------------------------------------------------------------------------
|    TurnTest Module: Created by Thomas on 02/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests for turn passing and ending the game
|
---------------------------------------------------------------------------------------*/

public class TurnTest {
    public static void main(String[] args) {

        GameMap.getInstance().initialize(new Vec2i(20,20));
        Game game = new Game();

        System.out.println("Game has started");
        CapitalStructure capital1 = new CapitalStructure(0, new MapCoordinate(1,1), game.player1.getEntityManager());
        game.player1.getEntityManager().addCapital(capital1);
        CapitalStructure capital2 = new CapitalStructure(0, new MapCoordinate(1,1), game.player2.getEntityManager());
        game.player2.getEntityManager().addCapital(capital2);

        System.out.println("Turn " + game.getTurnCount());
        game.changeTurn();
        game.changeTurn();

        System.out.println("Turn " + game.getTurnCount());
        System.out.println("Destroying Player 2's capital");
        capital2.destroy();
        game.changeTurn();
        game.changeTurn();

        System.out.println("Turn " + game.getTurnCount());
        //do stuff

    }

}
