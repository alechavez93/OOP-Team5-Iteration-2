package GameTests;

import Entity.Structure.CapitalStructure;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.Soldier;
import Game.Game;
import GameMap.*;
import Utility.*;

/**
 * Created by Thomas on 02/27/2017.
 */

/*--------------------------------------------------------------------------------------
|    CombatTest Module: Created by Thomas on 02/27/2017.
|---------------------------------------------------------------------------------------
|   Description: testing combat as well as tile searching
|
---------------------------------------------------------------------------------------*/

public class CombatTest {

    public static void main(String[] args) {

        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();

        System.out.println("Game has started, Players 1 and 2 each have " + game.player1.getEntityManager().getUnitCount());

        MapCoordinate map1 =  new MapCoordinate(3, 3);
        MeleeSoldier m1 = new MeleeSoldier(0,map1, game.player1.getEntityManager());
        game.player1.getEntityManager().addMelee(m1);

        MapCoordinate map2 = new MapCoordinate(4, 3);
        MeleeSoldier m2 = new MeleeSoldier(0, map2, game.player2.getEntityManager());
        game.player2.getEntityManager().addMelee(m2);
        System.out.println("Both gained a new unit for a total of " + game.player2.getEntityManager().getUnitCount());

        game.player2.getEntityManager().defend(m2, Direction.North);


        System.out.println("The soldier m1 is on tile (" + m1.getLocation().getRow() + " , " + m1.getLocation().getColumn() + ")");

        System.out.println("Soldier m1 has " + m1.getMaxHealth() + " max health");
        for(int i = 0; i < 10; i++) {
            game.player1.getEntityManager().attack(m1, new MapCoordinate(m1.getLocation().getRow() + 1, m1.getLocation().getColumn()));

        }
        System.out.println("Player 2 has " + game.player2.getEntityManager().getUnitCount() + " remaining units");
        System.out.println("The remaining health of solder m1 is " + m1.getCurrentHealth());

    }
}
