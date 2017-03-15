package Game;
/*--------------------------------------------------------------------------------------
|	CommandFactory Class: Created by Alejandro Chavez on 3/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Creates commands based on a cyclingstate.
---------------------------------------------------------------------------------------*/

import Commands.Command;
import Commands.MakeCapital;
import Commands.Move;
import Entity.Unit.ColonistUnit;
import GameLibrary.GameLibrary;
import GameMap.Tile;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    public static Command create(CyclingState state){
        if(state.selectedCommand.equals(GameLibrary.MAKE_CAPITAL)){
            if(state.selectedEntity instanceof ColonistUnit) {
                return new MakeCapital((ColonistUnit) state.selectedEntity);
            }
        }
        else if(state.selectedCommand.equals(GameLibrary.MOVE)){
            return new Move(state.selectedEntity, new ArrayList<>(state.path), state.inTurn.getFog());
        }
        return null;
    }

    public static Command create(CyclingState state, List<Tile> path) {

        return null;
    }
}
