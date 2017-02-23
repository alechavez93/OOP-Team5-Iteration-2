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
 *
 * DISCUSSION NEEDED
 *
 * What is considered an entity? The army itself? The battlegroup?
 *
 * How do army stats work? When do units die in an army? Is health treated uniformly?
 *
 * How do we update an army at the end of the turn?
 */

import Entity.Unit.Unit;
import GameMap.MapCoordinate;

public class Army {

    private RallyPoint rallyPoint;
    private BattleGroup battleGroup;
    private Reinforcements reinforcements;

    private Boolean atRallyPoint;

    public Army(Unit startingUnit){

        atRallyPoint = true;
        this.rallyPoint = new RallyPoint(this, startingUnit.getLocation());

        battleGroup = new BattleGroup(startingUnit);
    }

    public void addUnit(Unit unit){

        if(unit.getLocation().isEqual(battleGroup.getLocation())) { // if unit is on battlegroup already

            battleGroup.addUnit(unit);
        }else{

            reinforcements.addUnit(unit);
        }
    }

    public void updateLocation(){

        if(!atRallyPoint) {

            battleGroup.updateLocation();
        }
        reinforcements.updateLocation();
    }

    public void moveRallyPoint(MapCoordinate location){

        if(!(rallyPoint.getLocation().isEqual(location))) { // if rallyPoint location is not same as new location

            rallyPoint.setLocation(location);
            atRallyPoint = false;
        }else{

            atRallyPoint = true; // ERROR: Attempted to move rally point to same location
        }
    }

    public RallyPoint getRallyPoint() {
        return rallyPoint;
    }

}