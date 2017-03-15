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

import Entity.HarvestComponent;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.HarvestResources;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class FarmStructure extends Structure {

    private HarvestComponent harvest;

    public FarmStructure(int instanceID, MapCoordinate location, EntityManager entityManager, int workerCount) {
        super(GameLibrary.FARM, instanceID, location, entityManager);
        defense = 3;
        armor = 5;
        maxHealth = 100;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 12;
        workers.setNumberOfWorkers(workerCount);
        harvest = new HarvestComponent(workers, location, GameLibrary.HarvestType.FOOD);
        production = new Production(1,0,0,0,1,0,0,0,0);
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        harvest.setWorkersAt(location, workerCount);
    }

    public int harvest() {
        return harvest.harvest(production.foodRate);
    }

    public void destroy(){
        entityManager.destroyFarm(this);
    }
}
