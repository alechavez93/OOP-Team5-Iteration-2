package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    PowerStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class PowerStructure extends Structure {

    public PowerStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.POWER_PLANT, instanceID, location);
    }

}
