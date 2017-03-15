package Game;

/*--------------------------------------------------------------------------------------
|    CommandFactory Class: Created by Tonny Xie on 3/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Command Factory for the list of commands available
|
---------------------------------------------------------------------------------------*/

import Commands.*;
import Entity.Structure.CapitalStructure;
import Entity.Structure.FortStructure;
import Entity.Unit.ColonistUnit;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.Unit;
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
        switch (cyclingState.selectedCommand) {

            case GameLibrary.MAKE_CAPITAL:
                return new MakeCapital((ColonistUnit)cyclingState.selectedEntity);

            case GameLibrary.PROSPECT_MODE:
                return new ProspectMode((ExplorerUnit)cyclingState.selectedEntity);

            // selectedArmy may be null
            case GameLibrary.REINFORCE:
                return new ReinforceArmy((Unit)cyclingState.selectedEntity, cyclingState.selectedArmy);

            case GameLibrary.POWER_UP:
                return new PowerUp(cyclingState.selectedEntity);

            case GameLibrary.POWER_DOWN:
                return new PowerDown(cyclingState.selectedEntity);

            case GameLibrary.DECOMMISSION:
                return new Decommission(cyclingState.selectedEntity);

            default:
                return null;
        }
    }

    public Command makeStructureCommand() {
        switch (cyclingState.selectedCommand) {

            // Capital Specific Commands
            case GameLibrary.MAKE_EXPLORER:
                return new MakeExplorer((CapitalStructure)cyclingState.selectedEntity);

            case GameLibrary.HEAL_UNIT:
                return new Heal((CapitalStructure)cyclingState.selectedEntity);

//          NEEDS TO BE IMPLEMENTED
//            case GameLibrary.BREED:
//                return Breed();

            // Capital/Farm/Mine/Power Specific Commands
//          NEEDS TO BE IMPLEMENTED
//            case GameLibrary.ASSIGN_WORKERS:
//                return AssignWorker();

            // University Specific Commands
//            NEEDS TO BE IMPLEMENTED
//            case GameLibrary.RESEARCH:
//                return Research();

            // Fort Specific Commands
//              MISSING DIRECTION FROM CYCLING STATE
//            case GameLibrary.ATTACK:
//                return Attack(((FortStructure)cyclingState.selectedEntity /* Needs Direction */);

//              MISSING SOLDIER TYPE FROM CYCLING STATE
//            case GameLibrary.MAKE_SOLDIER:
//                return new MakeSoldier((FortStructure)cyclingState.selectedEntity, /*Needs Soldier Type */);

            // All Common Structure Commands
//              MISSING DIRECTION FROM CYCLING STATE
//            case GameLibrary.DEFEND:
//                return new Defend(cyclingState.selectedEntity, /* Needs Direction */);

            case GameLibrary.POWER_UP:
                return new PowerUp(cyclingState.selectedEntity);

            case GameLibrary.POWER_DOWN:
                return new PowerDown(cyclingState.selectedEntity);

            case GameLibrary.DECOMMISSION:
                return new Decommission(cyclingState.selectedEntity);

            case GameLibrary.CANCEL:
                return new CancelOrders(cyclingState.selectedEntity);

            default:
                return null;
        }
    }


    public Command makeArmyCommand() {
        return null;
    }

    public Command makeRallyPointCommand() {
        return null;
    }

}
