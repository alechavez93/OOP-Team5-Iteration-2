package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    MineStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|       Mine is built by Workers.
|       + Harvest ore
|       + Produce metal
|       + Staffed by Workers (Workers harvest and produce)
---------------------------------------------------------------------------------------*/

import Entity.Resource;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class MineStructure extends Structure {

    public MineStructure(int instanceID, MapCoordinate location, EntityManager entityManager, int workerCount) {
        super(GameLibrary.MINE, instanceID, location, entityManager);
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
        Resource.ORE.decrementAmount(production.oreRate*workerCount);
    }

    public void assignProduce(int workerCount) {
        Resource.METAL.incrementAmount( production.oreRate*workerCount);
    }

    public void destroy(){
        entityManager.destroyMine(this);
    }
}
