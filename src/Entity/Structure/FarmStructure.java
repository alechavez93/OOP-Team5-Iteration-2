package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FarmStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|       Farm is built by Workers.
|       + Harvest food
|       + Produce nutrients
|       + Staffed by Workers (Workers harvest and produce)
|       NOTE: + indicates implemented functions
---------------------------------------------------------------------------------------*/

import Entity.Resource;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class FarmStructure extends Structure {

    private int productionRate;
    private Worker workers;
    private int workRadius;

    public FarmStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.FARM, instanceID, location, entityManager);
        this.productionRate = 1;
        this.workers = new Worker(0);
        this.workRadius = 1;
        defense = 3;
        armor = 5;
        maxHealth = 100;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 5;
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        Resource.FOOD.decrementAmount(productionRate*workerCount);
    }

    public void assignProduce(int workerCount) {
        Resource.NUTRIENT.incrementAmount( productionRate*workerCount);
    }

    public void destroy(){
        entityManager.destroyFarm(this);
    }
}
