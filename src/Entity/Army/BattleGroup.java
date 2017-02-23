package Entity.Army;

/*--------------------------------------------------------------------------------------
|    BattleGroup Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|       The main entity of an army. BattleGroup is able to partake in combat, and moves
|       at the speed of the slowest unit it has.
|
---------------------------------------------------------------------------------------*/

import Entity.Unit.Unit;
import GameMap.MapCoordinate;

import java.util.ArrayList;
import java.util.List;

public class BattleGroup {

    private List<Unit> units;
    private MapCoordinate location;
    private int moveSpeed;

    public BattleGroup(Unit unit){

        units = new ArrayList<>();

        addUnit(unit);

        location = unit.getLocation();

        moveSpeed = unit.getMovement();
    }

    public void addUnit(Unit unit){

        units.add(unit);

        // Check if movespeed needs to be updated
        if(moveSpeed > unit.getMovement()){

            moveSpeed = unit.getMovement();
        }
    }

    public void updateLocation(){

        // MOVE BATTLEGROUP BASED ON SLOWEST UNIT
    }

    public List<Unit> getUnits(){
        return units;
    }

    public MapCoordinate getLocation() {
        return location;
    }
}
