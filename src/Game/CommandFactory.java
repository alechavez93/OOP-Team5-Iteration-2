package Game;
/*--------------------------------------------------------------------------------------
|    CommandFactory Class: Created by Tonny Xie on 3/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Command Factory for the list of commands available
|
---------------------------------------------------------------------------------------*/

import Commands.*;
import Entity.Army.Army;
import Entity.Structure.CapitalStructure;
import Entity.Structure.FortStructure;
import Entity.Unit.ColonistUnit;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.Unit;
import Game.CyclingState;
import GameLibrary.GameLibrary;

import java.util.ArrayList;

public class CommandFactory {

    private CyclingState cyclingState;
    String command;

    public CommandFactory(CyclingState cyclingState) {
        this.cyclingState = cyclingState;
    }

    public static Command create(CyclingState state){
        if(state.selectedCommand.equals(GameLibrary.MAKE_CAPITAL)){
            if(state.selectedEntity instanceof ColonistUnit) {
                return new MakeCapital((ColonistUnit) state.selectedEntity);
            }
        }
        else if(state.selectedCommand.equals(GameLibrary.MOVE)){
            return new Move(state.selectedEntity, new ArrayList<>(state.path), state.inTurn.getFog());
        }
        else if(state.selectedCommand.equals(GameLibrary.ATTACK)){
            return new Attack(state.selectedEntity, state.cursorCoord);
        }
        else if(state.selectedCommand.equals(GameLibrary.BREED)){
            return new Breeding((CapitalStructure) (state.selectedEntity));
        }
/*        else if(state.selectedCommand.equals(GameLibrary.BUILD_STRUCTURE)){
            return new BuildStructure(state.selectedArmy, )
        }*/
        else if(state.selectedCommand.equals(GameLibrary.CREATE_ARMY)){
            return new CreateArmy(state.selectedEntity);
            //TODO: THIS DOES NOT WORK
        }
        else if(state.selectedCommand.equals(GameLibrary.DECOMMISSION)){
            return new Decommission(state.selectedEntity);
        }
        else if(state.selectedCommand.equals(GameLibrary.DEFEND)){
            return null;
            //TODO: THIS DOES NOT WORK, NEED TO SELECT TARGET
        }
        else if(state.selectedCommand.equals(GameLibrary.HEAL_UNIT)){
            return new Heal((CapitalStructure)state.selectedEntity);
        }
        else if(state.selectedCommand.equals(GameLibrary.MAKE_EXPLORER)){
            return new MakeExplorer((CapitalStructure)state.selectedEntity);
        }
        else if(state.selectedCommand.equals(GameLibrary.POWER_DOWN)){
            return new PowerDown(state.selectedEntity);
        }
        else if(state.selectedCommand.equals(GameLibrary.POWER_UP)){
            return new PowerUp(state.selectedEntity);
        }
        else if(state.selectedCommand.equals(GameLibrary.PROSPECT_MODE)){
            return new Prospect(state.selectedEntity);
        }
/*        else if(state.selectedCommand.equals(GameLibrary.REINFORCE)){
            return new ReinforceArmy()
            //TODO: ADD FUNCTIONALITY TO SELECT TARGET
        }*/

        return null;
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

//          TODO:NEEDS TO BE IMPLEMENTED
//            case GameLibrary.BREED:
//                return Breed();

            // Capital/Farm/Mine/Power Specific Commands
//          TODO:NEEDS TO BE IMPLEMENTED
//            case GameLibrary.ASSIGN_WORKERS:
//                return AssignWorker();

            // University Specific Commands
//          TODO:NEEDS TO BE IMPLEMENTED
//            case GameLibrary.RESEARCH:
//                return Research();

            // Fort Specific Commands
//          TODO:MISSING DIRECTION FROM CYCLING STATE
//            case GameLibrary.ATTACK:
//                return Attack(((FortStructure)cyclingState.selectedEntity /* Needs Direction */);

//          TODO:MISSING SOLDIER TYPE FROM CYCLING STATE
//            case GameLibrary.MAKE_SOLDIER:
//                return new MakeSoldier((FortStructure)cyclingState.selectedEntity, /*Needs Soldier Type */);

            // All Common Structure Commands
//          TODO:MISSING DIRECTION FROM CYCLING STATE
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
        switch (cyclingState.selectedCommand) {

//          TODO:MISSING DIRECTION FROM CYCLING STATE
//            case GameLibrary.ATTACK:
//                return new Attack(cyclingState.selectedEntity, /* Needs Direction */);

//          TODO:MISSING DIRECTION FROM CYCLING STATE
//            case GameLibrary.DEFEND:
//                return new Defend(cyclingState.selectedEntity, /* Needs Direction */);

            case GameLibrary.MOVE:
                return new MoveRallypoint((Army)cyclingState.selectedEntity, cyclingState.cursorCoord);

//          TODO:NEEDS TO BE IMPLEMENTED
//            case GameLibrary.DISBAND:
//                return new Disband();

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

    public Command makeRallyPointCommand() {
        switch (cyclingState.selectedCommand) {

//          TODO:MISSING RALLYPOINT, STRUCTURE, WORKERCOUNT FROM CYCLING STATE
//            case GameLibrary.PICKUP:
//                return new PickupWorkers(/* Needs RallyPoint, Structure, WorkerCount */);

//          TODO:MISSING RALLYPOINT, STRUCTURE, WORKERCOUNT FROM CYCLING STATE
//            case GameLibrary.DROPOFF:
//                return new Dropoff(/* Needs RallyPoint, Structure, WorkerCount */);

//          TODO:MISSING ARMY, WORKERCOUNT, STRUCTURETYPE FROM CYCLING STATE
//            case GameLibrary.BUILD_STRUCTURE:
//                return new BuildStructure(/* Needs Army, WorkerCount, StructureType */);

            default:
                return null;
        }

    }

}
