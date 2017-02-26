package GameLibrary;

/*--------------------------------------------------------------------------------------
|    GameLibrary Class: Created by Tonny Xie on 2/21/2017.
|---------------------------------------------------------------------------------------
|   Description: Library
|
---------------------------------------------------------------------------------------*/

import javax.swing.plaf.synth.SynthLookAndFeel;

final public class GameLibrary {

    //Game Modes
    public static final String STRUCTURE_MODE = "STRUCTURE", RALLY_POINT_MODE = "RALLY POINT", ARMY_MODE = "ARMY", UNIT_MODE = "UNIT";
    public static final String[] MODES = {RALLY_POINT_MODE, STRUCTURE_MODE, UNIT_MODE, ARMY_MODE};

    //Unit Types
    public static final String MELEE = "MELEE SOLDIER", RANGED = "RANGED SOLDIER", COLONIST = "COLONIST", EXPLORER = "EXPLORER";
    public static final String[] UNITS = {MELEE, RANGED, COLONIST, EXPLORER};

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

    //Resources
    public static final String FOOD = "FOOD RESOURCE", WOOD = "WOOD RESOURCE", STONE = "STONE RESOURCE", DIAMOND="DIAMOND RESOURCE";


    public static final int MAP_HEIGHT = 10, MAP_WIDTH = 20;

    //Items
    public static final String ONESHOT = "ONE SHOT ITEM", OBSTACLE = "OBSTACLE ITEM";

    //Tile
    public enum TileType {
        GRASS("Grass", 1, false, "grass.jpg"),
        MOUNTAIN("Mountain", 999, true, "mountain.jpg"),
        SAND("Sand", 2, false, "sand.jpg"),
        WATER("Water", 999, true, "water.jpg"),
        JUNGLE("Jungle", 3, true, "grass2.jpg");

        public final String name;
        public final int movementCost;
        public final boolean impassable;
        public final String graphicName;
        TileType(String name, int movementCost, boolean impassable, String graphicName) {
            this.name = name;
            this.movementCost = movementCost;
            this.impassable = impassable;
            this.graphicName = graphicName;
        }
    }
}
