package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    Structure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Abstract Structure class
|       Needs a transfer workers function for all structures to inherit once the structure is built
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameMap.MapCoordinate;
import Player.EntityManager;

public abstract class Structure extends Entity {

    public Structure(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(name, instanceID, location, entityManager);
    }

}
