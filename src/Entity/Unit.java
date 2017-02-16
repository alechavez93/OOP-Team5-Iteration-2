package Entity;

/*--------------------------------------------------------------------------------------
|    Unit Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;

public abstract class Unit extends Entity {

    public Unit(String name, int instanceID, Coordinate location) {
        super(name, instanceID, location);
    }
}
