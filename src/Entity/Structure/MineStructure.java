package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    MineStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class MineStructure extends Structure {

    public MineStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.MINE, instanceID, location, entityManager);
    }

    public void destroy(){
        entityManager.destroyMine(this);
    }
}
