package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    CapitalStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|       + Capital is built by Colonist.
|       + Harvest energy, food, and ore
|       + Produce power, nutrients, and metal
|       + Staffed by Workers (Workers harvest and produce)
|       + Heals damaged units
|       + Create Explorers
|       + Create Workers
|       Game ends when Capital is destroyed
|       NOTE: + indicates implemented functions
---------------------------------------------------------------------------------------*/

import Entity.Resource;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.Unit;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class CapitalStructure extends Structure {

    private int productionRate;
    private Worker workers;
    private int workRadius;

    private int healAmount;

    public CapitalStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.CAPITAL, instanceID, location, entityManager);
        this.productionRate = 1;
        this.workers = new Worker(5);
        this.workRadius = 1;
        this.healAmount = 10;
    }

    public ExplorerUnit createExplorerUnit(int instanceID) {
        return new ExplorerUnit(instanceID, this.getLocation(), entityManager);
    }

    public void assignHarvest(int workerCount, Resource resource, MapCoordinate location) {
        resource.decrementAmount(productionRate*workerCount);
    }

    public void assignProduce(int workerCount, Resource resource) {
        resource.incrementAmount( productionRate*workerCount);
    }

    public void breedWorkers(int workerCount) {
        workers.setNumberOfWorkers(workers.getNumberOfWorkers() + productionRate*workerCount);
    }

    public void healUnit(Unit unit) {
        unit.setCurrentHealth(unit.getCurrentHealth() + healAmount);
    }

    public void destroy(){
        entityManager.destroyCapital(this);
    }

    public int getProductionRate() { return productionRate; }
    public int getWorkRadius() { return workRadius; }

}
