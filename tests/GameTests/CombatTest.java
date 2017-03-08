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

        System.out.println("Game has started");

        MapCoordinate map1 =  new MapCoordinate(1, 1);
        MeleeSoldier m1 = new MeleeSoldier(0,map1, game.player1.getEntityManager());
        game.player1.getEntityManager().addMelee(m1);

        MapCoordinate map2 = new MapCoordinate(2, 1);
        MeleeSoldier m2 = new MeleeSoldier(0, map2, game.player2.getEntityManager());
        game.player2.getEntityManager().addMelee(m2);

        game.player2.getEntityManager().defend(m2, Direction.North);


        System.out.println("The soldier m1 is on tile (" + m1.getLocation().getRow() + " , " + m1.getLocation().getColumn() + ")");
        System.out.print("The soldier m1 attacks South, which is off by: ");
        Vec2i target = Direction.South.getHex(true);
        System.out.println("(" + target.x + " , " + target.y + ")");
        game.player1.getEntityManager().attack(m1, Direction.South);

        System.out.println("The enum is South(180,0,1)");

    }
}
