package Game;

/*--------------------------------------------------------------------------------------
|    CommandFactory Class: Created by Tonny Xie on 3/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Command Factory for the list of commands available
|
---------------------------------------------------------------------------------------*/

import Commands.Command;
import GameLibrary.GameLibrary;

public class CommandFactory {

    private CyclingState cyclingState;
    String command;

    public CommandFactory(CyclingState cyclingState) {
        this.cyclingState = cyclingState;
    }

    public Command makeCommand() {
/*
        switch (cyclingState.gameMode) {

            case GameLibrary.STRUCTURE_MODE:
                return makeStructureCommand();

            case GameLibrary.RALLY_POINT_MODE
        }*/
return null;
    }

}
