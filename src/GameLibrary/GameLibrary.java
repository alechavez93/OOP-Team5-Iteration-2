package GameLibrary;

/*--------------------------------------------------------------------------------------
|    GameLibrary Class: Created by Tonny Xie on 2/21/2017.
|---------------------------------------------------------------------------------------
|   Description: Library
|
---------------------------------------------------------------------------------------*/

import Game.Game;
import Utility.GraphicsFactory;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class GameLibrary {

    //Game Modes
    public static final String STRUCTURE_MODE = "STRUCTURE", RALLY_POINT_MODE = "RALLY POINT", ARMY_MODE = "ARMY", UNIT_MODE = "UNIT";
    public static final String[] MODES = {RALLY_POINT_MODE, STRUCTURE_MODE, UNIT_MODE, ARMY_MODE};

    //Unit Types
    public static final String MELEE = "MELEE SOLDIER", RANGED = "RANGED SOLDIER", COLONIST = "COLONIST", EXPLORER = "EXPLORER", WORKER = "WORKER", BODY = "BODY", SOLDIER = "SOLDIER";
    public static final String[] UNITS = {MELEE, RANGED, COLONIST, EXPLORER};

    //Structure Types
    public static final String CAPITAL = "CAPITAL", FARM = "FARM", MINE = "MINE", POWER_PLANT = "POWER PLANT", FORT = "FORT", OBSERVATION_TOWER = "OBSERVATION TOWER", UNIVERSITY = "UNIVERSITY";
    public static final String[] STRUCTURES = {CAPITAL, FARM, MINE, POWER_PLANT, FORT, OBSERVATION_TOWER, UNIVERSITY};

    //Army Sub-Modes
    public static final String ENTIRE_ARMY = "ENTIRE ARMY", BATTLE_GROUP = "BATTLE GROUP", REINFORCEMENTS = "REINFORCEMENTS";
    public static final String[] ARMIES = {ENTIRE_ARMY, BATTLE_GROUP, REINFORCEMENTS};

    //Stats
    public static final String VISIBILITY = "VISIBILITY", DEFENSE = "DEFENSE", ARMOR = "ARMOR", SPEED = "SPEED", HEALTH = "HEALTH", EFFICIENCY = "EFFICIENCY";


    //Army Commands
    public static final String ATTACK = "ATTACK DIRECTION", DEFEND = "DEFEND DIRECTION", MOVE = "MOVE", DISBAND = "DISBAND", DECOMMISSION = "DECOMMISSION",
            POWER_UP = "POWER UP", POWER_DOWN = "POWER DOWN", CANCEL = "CANCEL QUEUED ORDERS";
    public static final String[] ARMY_COMMANDS = {ATTACK, DEFEND, MOVE, DISBAND, DECOMMISSION, POWER_DOWN, POWER_UP, CANCEL};

    //Structure Commands
    public static final String MAKE_UNIT = "MAKE UNIT TYPE", HEAL_UNIT = "HEAL UNIT";
//    public static final String[] STRUCTURE_COMMANDS = {ATTACK, MAKE_UNIT, DEFEND, HEAL_UNIT, DECOMMISSION, POWER_DOWN, POWER_UP, CANCEL};

    //Capital Commands
    public static final String[] CAPITAL_COMMANDS = {MAKE_UNIT, HEAL_UNIT, DEFEND, DECOMMISSION, POWER_DOWN, POWER_UP, CANCEL};

    //Fort Commands
    public static final String[] FORT_COMMANDS = {MAKE_UNIT, ATTACK, DEFEND, DECOMMISSION, POWER_DOWN, POWER_UP, CANCEL};

    //Unit Commands
    public static final String REINFORCE = "REINFORCE ARMY", CREATE_ARMY = "CREATE ARMY", BUILD_CAPITAL = "BUILD CAPITAL", PROSPECT_MODE = "PROSPECT MODE";
    public static final String[] UNIT_COMMANDS = {REINFORCE, DECOMMISSION, POWER_DOWN, POWER_UP};

    //Colonist Commands
    public static final String[] COLONIST_COMMANDS = {BUILD_CAPITAL, REINFORCE, DECOMMISSION, POWER_DOWN, POWER_UP};

    //Explorer Commands
    public static final String[] EXPLORER_COMMANDS = {PROSPECT_MODE, REINFORCE, DECOMMISSION, POWER_DOWN, POWER_UP};

    //Soldier Commands
    public static final String[] SOLDIER_COMMANDS = {REINFORCE, POWER_UP, POWER_DOWN, DECOMMISSION};

    //Explorer Commands
    public static final String PROSPECT_MODE = "PROSPECT MODE";

    //Resources (Harvest)
    public static final String ENERGY = "ENERGY", ORE = "ORE", FOOD = "FOOD";
    //Resources (Produce)
    public static final String POWER = "POWER", NUTRIENT = "NUTRIENT", METAL = "METAL", BREEDING = "BREEDING";
    //Worker stats
    public static final String RADIUS = "RADIUS", DENSITY = "DENSITY";


    public static final int MAP_HEIGHT = 10, MAP_WIDTH = 20;

    //Items
    public static final String ONESHOT = "ONE SHOT ITEM", OBSTACLE = "OBSTACLE ITEM";

    //Tile
    public enum TileType {
        GRASS("Grass", 1, false, GraphicsFactory.GRASS,'G'),
        MOUNTAIN("Mountain", 999, true, GraphicsFactory.MOUNTAIN,'M'),
        SAND("Sand", 2, false, GraphicsFactory.SAND,'S'),
        WATER("Water", 999, true, GraphicsFactory.WATER,'W'),
        JUNGLE("Jungle", 3, false, GraphicsFactory.JUNGLE,'J');

        public final String name;
        public final int movementCost;
        public final boolean impassable;
        public final String graphicName;
        public final char charSymbol;
        TileType(String name, int movementCost, boolean impassable, String graphicName, char charSymbol) {
            this.name = name;
            this.movementCost = movementCost;
            this.impassable = impassable;
            this.graphicName = graphicName;
            this.charSymbol = charSymbol;
        }
    }

    //Graphics mapping for Structures
    public static Map<String, String> structMap = new HashMap<>();
    static{
        structMap.put(CAPITAL, GraphicsFactory.CAPITAL_SRC);
        structMap.put(FARM, GraphicsFactory.FARM_SRC);
        structMap.put(MINE, GraphicsFactory.MINE_SRC);
        structMap.put(POWER_PLANT, GraphicsFactory.PLANT_SRC);
        structMap.put(OBSERVATION_TOWER, GraphicsFactory.TOWER_SRC);
        structMap.put(UNIVERSITY, GraphicsFactory.UNIVERSITY_SRC);
        structMap.put(FORT, GraphicsFactory.FORT_SRC);
    }

    //Graphics mapping for Structures
    public static Map<String, String> unitMap = new HashMap<>();
    static{
        unitMap.put(MELEE, GraphicsFactory.MELEE_SRC);
        unitMap.put(RANGED, GraphicsFactory.RANGED_SRC);
        unitMap.put(EXPLORER, GraphicsFactory.EXPLORER_SRC);
        unitMap.put(COLONIST, GraphicsFactory.COLONIST_SRC);
        unitMap.put(WORKER, GraphicsFactory.WORKER_SRC);
        unitMap.put(BODY, GraphicsFactory.BODY_SRC);
    }

    //Stuff Creation Cost
    public static final int MELEE_FOOD = 30, MELEE_ORE = 10, MELEE_ENERGY = 0,
                            RANGED_FOOD = 25, RANGED_ORE = 20, RANGED_ENERGY = 10,
                            EXPLORER_FOOD = 40, EXPLORER_ORE = 15, EXPLORER_ENERGY = 15,
                            WORKER_FOOD = 10, WORKER_ORE = 0, WORKER_ENRGY = 5;

    public static final int CAPITAL_FOOD = 0, CAPITAL_ORE = 200, CAPITAL_ENERGY = 100,
                            FARM_FOOD = 50, FARM_ORE = 50, FARM_ENERGY = 50,
                            MINE_FOOD = 0, MINE_ORE = 100, MINE_ENERGY = 50,
                            POWER_FOOD = 0, POWER_ORE = 100, POWER_ENERGY = 100,
                            FORT_FOOD = 100, FORT_ORE = 100, FORT_ENERGY = 50,
                            OBSERVATION_FOOD = 0, OBSERVATION_ORE = 50, OBSERVATION_ENERGY = 50,
                            UNIVERSITY_FOOD = 0, UNIVERSITY_ORE = 100, UNIVERSITY_ENERGY = 150;

    public static final int HEAL_FOOD_COST = 10;

    //building structures
    public static final String BUILD_STRUCTURE = "BUILD STRUCTURE";

    public static final String PICKUP = "PICKUP", DROPOFF = "DROPOFF";

    public static final int FARM_TURNS = 15, MINE_TURNS = 20, POWER_TURNS = 20, FORT_TURNS = 30, OBSERVATION_TURNS = 25, UNIVERSITY_TURNS = 25;

    //Creating Units
    public static final String MAKE_EXPLORER = "MAKE EXPLORER", MAKE_SOLDIER = "MAKE SOLDIER";
    public static final int EXPLORER_TURNS = 5,MELEE_TURNS = 9, RANGE_TURNS = 11;
}
