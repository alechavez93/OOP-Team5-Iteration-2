package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FarmStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class FarmStructure extends Structure {

    public FarmStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.FARM, instanceID, location);
    }
}
