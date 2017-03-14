package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FortStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|       Fort is built by Workers.
|       Staffed by Workers and Soldiers
|           Workers train to become Soldiers
|           Soldiers speed up Workers' training
|       Automatically attacks enemies within influence radius
|       Automatically buff ally defenses within influence radius
|       NOTE: + indicates implemented functions
---------------------------------------------------------------------------------------*/

import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class FortStructure extends Structure {

    public FortStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.FORT, instanceID, location, entityManager);
        attack = 5;
        defense = 3;
        armor = 5;
        maxHealth = 125;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 5;
    }

    public MeleeSoldier createMeleeSoldier() {
        return new MeleeSoldier(entityManager.nextMeleeIndex(), this.getLocation(), entityManager);
    }

    public RangeSoldier createRangeSoldier() {
        return new RangeSoldier(entityManager.nextRangeIndex(), this.getLocation(), entityManager);
    }

    public void destroy(){
        entityManager.destroyFort(this);
    }

}
