package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    ObservationStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class ObservationStructure extends Structure {

    public ObservationStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.OBSERVATION_TOWER, instanceID, location);
    }
}
