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


    public PowerStructure(int instanceID, MapCoordinate location, EntityManager entityManager, int workerCount) {
        super(GameLibrary.POWER_PLANT, instanceID, location, entityManager);
        defense = 3;
        armor = 5;
        maxHealth = 100;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 12;
        workers.setNumberOfWorkers(workerCount);
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        Resource.ENERGY.decrementAmount(production.energyRate*workerCount);
    }

    public void assignProduce(int workerCount) {
        Resource.POWER.incrementAmount( production.energyRate*workerCount);
    }

    public void destroy(){
        entityManager.destroyPower(this);
    }
}
