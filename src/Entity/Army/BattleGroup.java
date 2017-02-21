package Entity.Army;

/*--------------------------------------------------------------------------------------
|    BattleGroup Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|       The main entity of
---------------------------------------------------------------------------------------*/

import Entity.Unit.Unit;

import java.util.List;

public class BattleGroup {

    private List<Unit> units;
    private int moveSpeed;

    public BattleGroup(Unit unit){

        addUnit(unit);
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
}
