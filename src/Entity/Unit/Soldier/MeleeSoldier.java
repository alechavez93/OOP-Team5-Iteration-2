package Entity.Unit.Soldier;

/*--------------------------------------------------------------------------------------
|    MeleeSoldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class MeleeSoldier extends Soldier {

    public MeleeSoldier(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.MELEE, instanceID, location, entityManager);
        attack = 3;
        defense = 3;
        armor = 1;
        movement = 2;
        maxHealth = 20;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 5;
    }

    public void destroy(){
        entityManager.destroyMelee(this);
    }
}
