package Player;

import Entity.Unit.ColonistUnit;
import Entity.Unit.ExplorerUnit;
import GameMap.GameMap;
import GameMap.MapCoordinate;
import Player.*;
import Utility.Coordinate;
import Utility.Vec2i;

/**
 * Created by Thomas on 02/19/2017.
 */

/*--------------------------------------------------------------------------------------
|    TestPlayer Module: Created by Thomas on 02/19/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests the class implemented in the Player package
|
---------------------------------------------------------------------------------------*/

public class TestPlayer {

    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(10,10));
        Player p1 = new Player(1, new MapCoordinate(1,1));
/*        System.out.println("Player " + p1.pID + " has resources: ");
        System.out.println("Food: " + p1.getFood());
        System.out.println("Wood: " + p1.getWood());
        System.out.println("Stone: " + p1.getStone());*/


        System.out.println("Player 1 has " + p1.getEntityManager().getColonistList().size() + " colonists");
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        System.out.println("Next ColonistUnit Index: " + p1.getEntityManager().nextColonistIndex());
        System.out.println("Next ExplorerUnit Index: " + p1.getEntityManager().nextExplorerIndex());

        System.out.println("Attempting to make new explorers:");
        for(int i = 0; i < 10; i++){
            ExplorerUnit explorer = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new MapCoordinate(1,1), p1.getEntityManager());
            p1.getEntityManager().addExplorer(explorer);
        }

        ExplorerUnit explorer1 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new MapCoordinate(1,1), p1.getEntityManager());
        p1.getEntityManager().addExplorer(explorer1);
        System.out.println("Index of last explorer: " + explorer1.getInstanceID());
        System.out.println("there are now " + p1.getEntityManager().getExplorerUnitCount() + " explorers");


        System.out.println("Attempting to create and destroy a colonist");
        ColonistUnit colonist = new ColonistUnit(p1.getEntityManager().nextColonistIndex(), new MapCoordinate(1,1), p1.getEntityManager());
        p1.getEntityManager().addColonist(colonist);
        System.out.println("Player 1 has " + p1.getEntityManager().getColonistList().size() + " colonists");

        System.out.println("total units: "  + p1.getEntityManager().getUnitCount());

        colonist.destroy();
        System.out.println("Player 1 has " + p1.getEntityManager().getColonistList().size() + " = " + p1.getEntityManager().getColonistUnitCount() + " colonists");






    }

}
