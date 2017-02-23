package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FortStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class FortStructure extends Structure {

    public FortStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.FORT, instanceID, location, entityManager);
    }

    public void destroy(){
        entityManager.destroyFort(this);
    }

}
