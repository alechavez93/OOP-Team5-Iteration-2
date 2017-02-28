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
import GameMap.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reinforcements {

    private List<UnitPath> units;
    private Army armyToReinforce;
    private RallyPoint rallyPoint;

    //Unit shouldn't know how to path itself except in the context of reinforcement
    private class UnitPath {
        public Unit unit;
        public Path path;

        public UnitPath(Unit u, Path p) {this.unit = u; this.path = p;}

        public void updateLocation() {
            if(path.isEnd())
                return;
            if(!path.isValid())
                path.recreate(unit.getLocation());

            int speed = unit.getMovement();
            GameMap map = GameMap.getInstance();
            while(speed > 0) {
                map.shiftEntity(unit, path.next());
                speed -= map.getTile(unit.getLocation()).getMovementCost();
            }
        }
    }


    public void Reinforcements(Army army) {
        armyToReinforce = army;
        units = new ArrayList<>();
        rallyPoint = armyToReinforce.getRallyPoint();
    }

    // Add unit to an Army's reinforcements
    public void addUnit(Unit unit){
        PathFinder finder = new AStarPathFinder();
        Path path = finder.createPath(unit.getLocation(), rallyPoint.getLocation());
        units.add(new UnitPath(unit, path));
    }

    public void createPathsTo(MapCoordinate endPoint) {
        PathFinder finder = new AStarPathFinder();
        for(UnitPath u : units) {
            u.path = finder.createPath(u.unit.getLocation(), endPoint);
        }
    }

    // update the location of every reinforcement
    public void updateLocations(){
        for(UnitPath u: units) {
            u.updateLocation();
        }
    }

    //Reinforces a battleGroup with units at location
    public void reinforce(BattleGroup battleGroup, MapCoordinate location) {
        List<UnitPath> removeList = new ArrayList<UnitPath>(units.size());
        for(UnitPath u : units) {
            if(u.unit.getLocation().equals(location)) {
                battleGroup.addUnit(u.unit);
                removeList.add(u);
            }
        }
        units.removeAll(removeList);
    }

    // call this if the army is disbanded, all units need to know they are no longer in the army
    public void disband(){

        /**
         * Tell all units they are no longer part of an army
         */
    }
}
