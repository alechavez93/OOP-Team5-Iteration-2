package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    Unit Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Abstract Unit class
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameMap.MapCoordinate;

public abstract class Unit extends Entity {

    public Unit(String name, int instanceID, MapCoordinate location) {
        super(name, instanceID, location);
    }


}
