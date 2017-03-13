package Game;
/*--------------------------------------------------------------------------------------
|	CyclingState Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Keeps the cycling state of the Player in turn.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Unit.ColonistUnit;
import GameLibrary.GameLibrary;
import GameMap.GameMap;
import GameMap.MapCoordinate;
import Player.*;
import Utility.Direction;

public class CyclingState {

    public Player inTurn = new Player(1, "Logan", new MapCoordinate(2,2));
    public String gameMode = GameLibrary.UNIT_MODE;
    public String modeType = GameLibrary.COLONIST;
    public Entity selectedEntity = new ColonistUnit(0,new MapCoordinate(2,2),new EntityManager(inTurn));
    public String selectedCommand = GameLibrary.UNIT_COMMANDS[0];

    //
    public MapCoordinate cursorCoord;


    public void cycleMode(boolean backward) {}
    public void cycleType(boolean backward) {}
    public void cycleInstances(boolean backward) {}
    public void cycleCommands(boolean backward) {}

    public void moveCursor(Direction dir) {
        cursorCoord = GameMap.getInstance().getNeighborTile(cursorCoord, dir).getPos();
    }
}
