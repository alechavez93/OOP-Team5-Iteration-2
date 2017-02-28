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


        System.out.println("The soldier m1 is on tile (" + m1.getLocation().getRow() + " , " + m1.getLocation().getColumn() + ")");
        System.out.print("The soldier m1 attacks SouthEast, which is off by: ");
        Vec2i target = Direction.SouthEast.getHex(true);
        System.out.println("(" + target.x + " , " + target.y + ")");
        game.player1.getEntityManager().attack(m1, Direction.SouthEast);

        System.out.println("The enum is SouthEast(120,1,0) ...");

    }
}
