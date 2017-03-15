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

import Entity.HarvestComponent;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.HarvestResources;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class PowerStructure extends Structure {

    private HarvestComponent harvest;

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
        harvest = new HarvestComponent(workers, location, GameLibrary.HarvestType.ENERGY);
        production = new Production(0,1,0,1,0,0,0,0,0);
    }

    public void assignHarvest(int workerCount, MapCoordinate location) {
        harvest.setWorkersAt(location, workerCount);
    }

    public void harvest() {
        entityManager.playerOwner.gainEnergy(harvest.harvest(production.energyRate));
    }

    @Override
    public void finishTurn() {
        super.finishTurn();
        harvest();
    }

    public void destroy(){
        entityManager.destroyPower(this);
    }
}
