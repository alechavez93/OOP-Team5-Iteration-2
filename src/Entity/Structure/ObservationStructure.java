package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    ObservationStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class ObservationStructure extends Structure {

    public ObservationStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.OBSERVATION_TOWER, instanceID, location, entityManager);
    }

    public void destroy(){
        entityManager.destroyObserver(this);
    }
}
