package Entity.Army;
import Entity.Entity;

/*--------------------------------------------------------------------------------------
|    BattleGroup Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|       The main entity of an army. BattleGroup is able to partake in combat, and moves
|       at the speed of the slowest unit it has.
|
---------------------------------------------------------------------------------------*/

import Entity.Unit.Unit;
import GameMap.*;
import Utility.Direction;
import sun.misc.resources.Messages_pt_BR;

import java.util.ArrayList;
import java.util.List;

public class BattleGroup {

    private List<Unit> units;
    private MapCoordinate location;
    private Path path;
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

    public void createPathTo(MapCoordinate endPoint) {
        PathFinder finder = new AStarPathFinder();
        path = finder.createPath(location, endPoint);
    }

    public void updateLocation(){
        if(path.isEnd())
            return;
        if(!path.isValid())
            path.recreate(location);
        int speed = moveSpeed;
        Tile t = GameMap.getInstance().getTile(location);
        while(speed > 0) {
            //GameMap.getInstance().shiftEntity(unit, path.next());
            t.removeArmyUnits(units);
            t = GameMap.getInstance().getNeighborTile(location, path.next());
            location = t.getPos();
            t.addArmyUnits(units);
            speed -= t.getMovementCost();
        }
    }

    public MapCoordinate getLocation() {
        return location;
    }
}
