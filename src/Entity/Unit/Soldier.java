package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    Soldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;

public abstract class Soldier extends Unit {

    public Soldier(String name, int instanceID, Coordinate location) {
        super(name, instanceID, location);
    }
}
