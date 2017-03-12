package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    MineStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Mine is built by Workers. It can only harvest pre
|   which can be produced into metal by the Workers staffed at the Mine.
---------------------------------------------------------------------------------------*/

import Entity.Resource;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class MineStructure extends Structure {

    private int productionRate;
    private Worker workers;
    private int workRadius;

    public MineStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.MINE, instanceID, location, entityManager);
        this.productionRate = 1;
        this.workers = new Worker(0);
        this.workRadius = 1;
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        Resource.ORE.decrementAmount(productionRate*workerCount);
    }

    public void assignProduce(int workerCount) {
        Resource.METAL.incrementAmount( productionRate*workerCount);
    }

    public void destroy(){
        entityManager.destroyMine(this);
    }
}
