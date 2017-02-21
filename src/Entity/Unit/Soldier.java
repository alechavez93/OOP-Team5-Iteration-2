package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    Soldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameMap.MapCoordinate;

public abstract class Soldier extends Unit {

    public Soldier(String name, int instanceID, MapCoordinate location) {
        super(name, instanceID, location);
    }
}
