package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FarmStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class FarmStructure extends Structure {

    public FarmStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.FARM, instanceID, location, entityManager);
    }

    public void destroy(){
        entityManager.destroyFarm(this);
    }
}
