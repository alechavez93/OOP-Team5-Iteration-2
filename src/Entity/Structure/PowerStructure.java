package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    PowerStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Power Plant is built by Workers. It can harvest only energy
|   which can be produced into power by the workers staffed at the Power Plant.
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
