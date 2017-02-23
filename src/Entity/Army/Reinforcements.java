package Entity.Army;

/*--------------------------------------------------------------------------------------
|    Reinforcements Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|       Reinforcements make up the units in an army that are not a part of the BattleGroup
|       Their only responsibility is to reach the RallyPoint, and join the BattleGroup if
|       it is at the RallyPoint.
|
---------------------------------------------------------------------------------------*/

import Entity.Unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Reinforcements {

    private List<Unit> units;
    private Army armyToReinforce;
    private RallyPoint rallyPoint;

    public void Reinforcements(Army army) {

        armyToReinforce = army;
        units = new ArrayList<>();
        rallyPoint = armyToReinforce.getRallyPoint();
    }

    // Add unit to an Army's reinforcements
    public void addUnit(Unit unit){

        units.add(unit);
    }

    // update the location of every reinforcement
    // check to see if the reinforcement is now a part of the BattleGroup
    public void updateLocation(){

        /**
         * POSSIBLE UPDATES
         *
         * if not at rally point, move towards it
         *
         * if at rally point, check if BattleGroup is present
         *      YES:
         *          add to BattleGroup
         *      NO:
         *          stays at RallyPoint, still a reinforcement
         */
    }

    // call this if the army is disbanded, all units need to know they are no longer in the army
    public void disband(){

        /**
         * Tell all units they are no longer part of an army
         */
    }
}
