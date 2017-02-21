package PlayerTests;

import Entity.Unit.ColonistUnit;
import Entity.Unit.ExplorerUnit;
import Player.*;
import Utilities.Coordinate;
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
        Player p1 = new Player(1, new Coordinate(1,1));
        System.out.println("Player " + p1.pID + " has resources: ");
        System.out.println("Food: " + p1.getFood());
        System.out.println("Wood: " + p1.getWood());
        System.out.println("Stone: " + p1.getStone());


        System.out.println("Player 1 has " + p1.getEntityManager().getColonistList().size() + " colonists");
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        System.out.println("Next ColonistUnit Index: " + p1.getEntityManager().nextColonistIndex());
        System.out.println("Next ExplorerUnit Index: " + p1.getEntityManager().nextExplorerIndex());

        /*System.out.println("Attempting to make new explorers:");
        ExplorerUnit e2 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e2);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e3 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e3);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e4 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e4);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e5 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e5);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e6 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e6);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e7 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e7);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e8 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e8);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");


        ExplorerUnit e9 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e9);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");

        //System.out.println(" next value: " + p1.getEntityManager().nextExplorerIndex());
        ExplorerUnit e10 = new ExplorerUnit(p1.getEntityManager().nextExplorerIndex(), new Coordinate(1,1));
        p1.getEntityManager().addExplorer(e10);
        System.out.println("Player 1 has " + p1.getEntityManager().getExplorerUnitList().size() + " explorers");
        System.out.println("e10s ID: " + e10.getInstanceID());*/

        ColonistUnit colonist = p1.getEntityManager().newColonist(p1.getEntityManager().getExplorerUnitList().get(0).getLocation());
        p1.getEntityManager().addColonist(colonist);
        System.out.println("Player 1 has " + p1.getEntityManager().getColonistList().size() + " colonists");




    }

}
