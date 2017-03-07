package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    CapitalStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|       + Capital is built by Colonist.
|       Harvest energy, food, and ore
|       Produce power, nutrients, and metal
|       Staffed by Workers (Workers harvest and produce)
|       Heals damaged units
|       + Create Explorers
|       Create Workers
|       Game ends when Capital is destroyed
|       NOTE: + indicates implemented functions
---------------------------------------------------------------------------------------*/

import Entity.Unit.ExplorerUnit;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.HarvestResources;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class CapitalStructure extends Structure {

    private int productionRate;
    private Worker workers;
    private int workRadius;

    public CapitalStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.CAPITAL, instanceID, location, entityManager);
        this.productionRate = 10;
        this.workRadius = 1;
    }

    public ExplorerUnit createExplorerUnit(int instanceID) {
        return new ExplorerUnit(instanceID, this.getLocation(), entityManager);
    }

    // CREATE WORKER UNITS

    public void harvest(HarvestResources resource) {
        resource.decrementEnergy( productionRate*workers.getNumberOfWorkers());
    }

    public void produce(ProduceResources resource) {
        resource.increment( productionRate*workers.getNumberOfWorkers());
    }

    public Worker breed(Worker count) {

    }

    public void destroy(){
        entityManager.destroyCapital(this);
    }

    public int getProductionRate() { return productionRate; }
    public Worker getWorkerCount() { return workerCount; }
    public int getWorkRadius() { return workRadius; }

}
