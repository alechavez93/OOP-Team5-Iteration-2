package Game;
/*--------------------------------------------------------------------------------------
|	CyclingState Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Keeps the cycling state of the Player in turn.
---------------------------------------------------------------------------------------*/

import Entity.Army.Army;
import Entity.Entity;
import GameLibrary.GameLibrary;
import GameMap.*;
import GameMap.MapCoordinate;
import Player.*;
import Utility.Direction;

import java.util.ArrayList;
import java.util.List;

public class CyclingState {

    public Player inTurn = null;
    public EntityManager entityManager = null;
    public String gameMode = GameLibrary.UNIT_MODE;
    public String modeType = GameLibrary.COLONIST;
    public Entity selectedEntity = null;
    public String selectedCommand = null;
    public Army selectedArmy = null;
    public MapCoordinate cursorCoord = null;
    public List<Tile> path = new ArrayList<>();

    @Override
    public String toString(){
        return "Player: "+inTurn.getName()+"\n"+
                "Mode: "+ gameMode+"\n"+
                "Type: "+ modeType+"\n"+
                "Entity: "+selectedEntity.getName()+"\n"+
                "Command: "+selectedCommand+"\n\n";
    }


    public void cycleMode(boolean backward) {}
    public void cycleType(boolean backward) {}
    public void cycleInstances(boolean backward) {}
    public void cycleCommands(boolean backward) {}

    public void moveCursor(Direction dir) {
        cursorCoord = GameMap.getInstance().getNeighborTile(cursorCoord, dir).getPos();
    }
}
