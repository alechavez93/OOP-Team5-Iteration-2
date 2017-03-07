package EntityTests;

/*--------------------------------------------------------------------------------------
|    TestStructure Class: Created by Tonny Xie on 2/26/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

import Entity.Structure.CapitalStructure;
import Entity.Worker;
import GameLibrary.GameLibrary;
import Utility.Vec2i;
import GameMap.*;
import Player.*;

import java.util.Scanner;

public class TestStructure {

    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(10,10));


    }

    private static void testCapitalStructure() {
//        int id = 1;
//        GameMap map = GameMap.getInstance();
//        MapCoordinate location = new MapCoordinate(2,3);
//        Player player = new Player(1, location);
//        EntityManager entityManager = new EntityManager(player);
//        CapitalStructure capital = new CapitalStructure(id, location, entityManager);
//        Worker worker = new worker(10);
//
//        String ASSIGN_WORKERS = "ASSIGN WORKERS", UNASSIGN_WORKERS = "UNASSIGN WORKERS",
//                CREATE_UNIT = "CREATE UNIT", HEAL_UNIT = "HEAL UNIT";
//        String capitalCommands[] = {ASSIGN_WORKERS, UNASSIGN_WORKERS, CREATE_UNIT, HEAL_UNIT};
//
//        // Player cycles through MODE - STRUCTURE
//        // Player cycles through STRUCTURE TYPE - CAPITAL
//        // Player cycles through STRUCTURE INSTANCE - 0
//
//        // Player cycles through STRUCTURE COMMANDS - ASSIGN WORKERS
//        // Player selects how many workers to assign to harvest energy
//        int workerCounter = 5;
//        // Player selects which tile to assign workers to
//        MapCoordinate resourceLocation;
//        capital.harvest(location);

    }

    private static void testBuildingStructure() {
        int id = 1;
        GameMap map = GameMap.getInstance();
        MapCoordinate location = new MapCoordinate(2,3);
        Player player = new Player(1, location);
        EntityManager entityManager = new EntityManager(player);


    }
}
