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

final public class GameLibrary {

    //Game Modes
    public static final String STRUCTURE_MODE = "STRUCTURE", RALLY_POINT_MODE = "RALLY POINT", ARMY_MODE = "ARMY", UNIT_MODE = "UNIT";
    public static final String[] MODES = {RALLY_POINT_MODE, STRUCTURE_MODE, UNIT_MODE, ARMY_MODE};

    //Unit Types
    public static final String MELEE = "MELEE SOLDIER", RANGED = "RANGED SOLDIER", COLONIST = "COLONIST", EXPLORER = "EXPLORER", WORKER = "WORKER", BODY = "BODY";
    public static final String[] UNITS = {MELEE, RANGED, COLONIST, EXPLORER, WORKER, BODY};

    //Structure Types
    public static final String CAPITAL = "CAPITAL", FARM = "FARM", MINE = "MINE", POWER_PLANT = "POWER PLANT", FORT = "FORT", OBSERVATION_TOWER = "OBSERVATION TOWER", UNIVERSITY = "UNIVERSITY";
    public static final String[] STRUCTURES = {CAPITAL, FARM, MINE, POWER_PLANT, FORT, OBSERVATION_TOWER, UNIVERSITY};

    //Army Sub-Modes
    public static final String ENTIRE_ARMY = "ENTIRE ARMY", BATTLE_GROUP = "BATTLE GROUP", REINFORCEMENTS = "REINFORCEMENTS";
    public static final String[] ARMIES = {ENTIRE_ARMY, BATTLE_GROUP, REINFORCEMENTS};



    //Army Commands
    public static final String ATTACK = "ATTACK DIRECTION", DEFEND = "DEFEND DIRECTION", MOVE = "MOVE", DISBAND = "DISBAND", DECOMMISSION = "DECOMMISSION",
            POWER_UP = "POWER UP", POWER_DOWN = "POWER DOWN", CANCEL = "CANCEL QUEUED ORDERS";
    public static final String[] ARMY_COMMANDS = {ATTACK, DEFEND, MOVE, DISBAND, DECOMMISSION, POWER_DOWN, POWER_UP, CANCEL};

    //Structure Commands
    public static final String MAKE_UNIT = "MAKE UNIT TYPE", HEAL_UNIT = "HEAL UNIT";
    public static final String[] STRUCTURE_COMMANDS = {ATTACK, MAKE_UNIT, DEFEND, HEAL_UNIT, DECOMMISSION, POWER_DOWN, POWER_UP, CANCEL};

    //Unit Commands
    public static final String REINFORCE = "REINFORCE ARMY";
    public static final String[] UNIT_COMMANDS = {REINFORCE, DECOMMISSION, POWER_DOWN, POWER_UP};

    //Resources (Harvest)
    public static final String ENERGY = "ENERGY", ORE = "ORE", FOOD = "FOOD";
    //Resources (Produce)
    public static final String POWER = "POWER", NUTRIENT = "NUTRIENT", METAL = "METAL";


    public static final int MAP_HEIGHT = 10, MAP_WIDTH = 20;

    //Items
    public static final String ONESHOT = "ONE SHOT ITEM", OBSTACLE = "OBSTACLE ITEM";

    //Tile
    public enum TileType {
        GRASS("Grass", 1, false, GraphicsFactory.GRASS,'G'),
        MOUNTAIN("Mountain", 999, true, GraphicsFactory.MOUNTAIN,'M'),
        SAND("Sand", 2, false, GraphicsFactory.SAND,'S'),
        WATER("Water", 999, true, GraphicsFactory.WATER,'W'),
        JUNGLE("Jungle", 3, true, GraphicsFactory.JUNGLE,'J');

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

}
