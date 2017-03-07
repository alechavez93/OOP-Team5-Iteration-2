package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FortStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Unit.ExplorerUnit;
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

    public ExplorerUnit createExplorerUnit(int instanceID) {
        return new ExplorerUnit(instanceID, this.getLocation(), entityManager);
    }

    public void destroy(){
        entityManager.destroyFort(this);
    }

}
