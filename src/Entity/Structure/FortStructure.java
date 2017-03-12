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
    }

    public MeleeSoldier createMeleeSoldier(int instanceID) {
        return new MeleeSoldier(instanceID, this.getLocation(), entityManager);
    }

    public RangeSoldier createRangeSoldier(int instanceID) {
        return new RangeSoldier(instanceID, this.getLocation(), entityManager);
    }

    public void destroy(){
        entityManager.destroyFort(this);
    }

}
