package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FarmStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Farm is built by Workers. It can only harvest food
|   which can be produced into nutrients by the Workers staffed at the Farm.
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
