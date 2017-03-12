package Entity.Unit.Soldier;

/*--------------------------------------------------------------------------------------
|    RangeSoldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class RangeSoldier extends Soldier {

    public RangeSoldier(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.RANGED, instanceID, location, entityManager);
        attack = 3;
        defense = 2;
        armor = 1;
        movement = 2;
        maxHealth = 20;
        currentHealth = maxHealth;
        rangeRadius = 2;
        visibilityRadius = 2;
        upkeep = 5;
    }

    public void destroy(){
        entityManager.destroyRange(this);
    }
}
