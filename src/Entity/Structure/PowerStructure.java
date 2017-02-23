package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    PowerStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class PowerStructure extends Structure {

    public PowerStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.POWER_PLANT, instanceID, location, entityManager);
    }

    public void destroy(){
        entityManager.destroyPower(this);
    }
}
