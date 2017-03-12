package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    PowerStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: |
|       Power Plant is built by Workers.
|       + Harvest energy
|       + Produce power
|       + Staffed by Workers (Workers harvest and produce)
|       NOTE: + indicates implemented functions
---------------------------------------------------------------------------------------*/

import Entity.Resource;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class PowerStructure extends Structure {

    private int productionRate;
    private Worker workers;
    private int workRadius;

    public PowerStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.POWER_PLANT, instanceID, location, entityManager);
        this.productionRate = 1;
        this.workers = new Worker(0);
        this.workRadius = 1;
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        Resource.ENERGY.decrementAmount(productionRate*workerCount);
    }

    public void assignProduce(int workerCount) {
        Resource.POWER.incrementAmount( productionRate*workerCount);
    }

    public void destroy(){
        entityManager.destroyPower(this);
    }
}
