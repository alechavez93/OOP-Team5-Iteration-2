package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    ObservationStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Observation Tower is built by Workers. All tiles within the
|   visibility radius remains visible. It requires no staff.
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class ObservationStructure extends Structure {

    public ObservationStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.OBSERVATION_TOWER, instanceID, location);
    }
}
