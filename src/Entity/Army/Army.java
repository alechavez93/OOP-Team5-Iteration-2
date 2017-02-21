package Entity.Army;

/*--------------------------------------------------------------------------------------
|    Army Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|       Army is responsible for grouping units together and moving them to a RallyPoint.
|       It consists of a BattleGroup and Reinforcements.
|
---------------------------------------------------------------------------------------*/

/**
 * TO DO
 *
 * updateLocation()
 * handle combat
 * handle workers
 * integrate w/ view
 */

import Entity.Unit.Unit;

public class Army {

    private RallyPoint rallyPoint;
    private BattleGroup battleGroup;
    private Reinforcements reinforcements;

    private Boolean atRallyPoint;

    public Army(Unit startingUnit){

        atRallyPoint = true;
        this.rallyPoint = new RallyPoint(this); // NEEDS TO BE UPDATED SO THAT RALLYPOINT IS AT LOC OF STARTING UNIT

        battleGroup = new BattleGroup(startingUnit);
    }

    public void addUnit(Unit unit){

        // determine if unit is part of BattleGroup or Reinforcements, add to that
    }

    public void updateLocation(){

        if(!atRallyPoint) {
            battleGroup.updateLocation();
        }
        reinforcements.updateLocation();
    }

    public RallyPoint getRallyPoint() {
        return rallyPoint;
    }

}
