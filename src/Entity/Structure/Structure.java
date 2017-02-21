package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    Structure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Utility.Coordinate;

public abstract class Structure extends Entity {

    public Structure(String name, int instanceID, Coordinate location) {
        super(name, instanceID, location);
    }

//    public abstract void produce();
//    public abstract void harvest();

}
