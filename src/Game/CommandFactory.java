package Game;

/*--------------------------------------------------------------------------------------
|    CommandFactory Class: Created by Tonny Xie on 3/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Command Factory for the list of commands available
|
---------------------------------------------------------------------------------------*/

import Commands.Command;
import Commands.Decommission;
import Commands.PowerDown;
import Commands.PowerUp;
import GameLibrary.GameLibrary;

public class CommandFactory {

    private CyclingState cyclingState;
    String command;

    public CommandFactory(CyclingState cyclingState) {
        this.cyclingState = cyclingState;
    }

    public Command makeCommand() {

        switch (cyclingState.gameMode) {

            case GameLibrary.UNIT_MODE:
                return makeUnitCommand();

            case GameLibrary.STRUCTURE_MODE:
                return makeStructureCommand();

            case GameLibrary.ARMY_MODE:
                return makeArmyCommand();

            case GameLibrary.RALLY_POINT_MODE:
                return makeRallyPointCommand();

            default:
                return null;
        }
    }

    public Command makeUnitCommand() {

        switch (cyclingState.modeType) {

            case GameLibrary.POWER_UP:
                return new PowerUp(cyclingState.selectedEntity);

            case GameLibrary.POWER_DOWN:
                return new PowerDown(cyclingState.selectedEntity);

            case GameLibrary.DECOMMISSION:
                return new Decommission(cyclingState.selectedEntity);

        }
    }

}
