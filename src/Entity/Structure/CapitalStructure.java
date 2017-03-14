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

import Entity.Army.Army;
import Entity.Resource;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.Unit;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class CapitalStructure extends Structure {

    private int healAmount;

    public CapitalStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.CAPITAL, instanceID, location, entityManager);

        production = new Production(1,1,1,1,1,1,1,1,0);
        workers.setNumberOfWorkers(5);
        this.healAmount = 10;
        defense = 3;
        armor = 5;
        maxHealth = 150;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 24;
    }

    public ExplorerUnit createExplorerUnit() {
        //TODO: put command in a queue instead
        return new ExplorerUnit(entityManager.nextExplorerIndex(), this.getLocation(), entityManager);
    }

    /*public void assignHarvest(int workerCount, Resource resource, MapCoordinate location) {
        resource.decrementAmount(productionRate*workerCount);
    }*/

    public void harvestFood(int workerCount, MapCoordinate location){
        //TODO: use foodRate
    }

    public void harvestOre(int wokerCount, MapCoordinate location){
        //TODO: use oreRate
    }

    public void harvestEnergy(int workerCount, MapCoordinate location){
        //TODO: use energyRate
    }

/*    public void assignProduce(int workerCount, Resource resource) {
        resource.incrementAmount( productionRate*workerCount);
    }*/

    public void producePower(int workerCount){
        //TODO: decrease energy, increase power. use powerRate
    }

    public void produceNutrients(int workerCount){
        //TODO: same. use nutrientsRate
    }

    public void produceMetal(int workerCount){
        //TODO: same. use metalRate
    }

    public void breedWorkers(int workerCount) {
        //TODO: fix the rate
        workers.incrementNumberOfWorkers(production.breedingRate*workerCount);
    }

    public void heal(Unit unit) {
        unit.setCurrentHealth(unit.getCurrentHealth() + healAmount);
    }

    public void heal(Army army) { army.setCurrentHealth(army.getCurrentHealth() + healAmount); }

    public void destroy(){
        entityManager.destroyCapital(this);
    }

    public int getWorkRadius() { return workRadius; }

}
