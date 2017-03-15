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

import Entity.HarvestComponent;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class MineStructure extends Structure {

    private HarvestComponent harvest;

    public MineStructure(int instanceID, MapCoordinate location, EntityManager entityManager, int workerCount) {
        super(GameLibrary.MINE, instanceID, location, entityManager);
        defense = 3;
        armor = 5;
        maxHealth = 100;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 12;
        harvest = new HarvestComponent(workers, location, GameLibrary.HarvestType.ORE);
        workers.setNumberOfWorkers(workerCount);
        production = new Production(0,0,1,0,0,1,0,0,0);
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        harvest.setWorkersAt(location, workerCount);
    }

    public void harvest() {
        entityManager.playerOwner.gainOre(harvest.harvest(production.oreRate));
    }

    public void finishTurn() {
        super.finishTurn();
        harvest();
    }

    public void destroy(){
        entityManager.destroyMine(this);
    }
}
