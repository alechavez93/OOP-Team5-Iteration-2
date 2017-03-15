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

import Entity.Unit.ExplorerUnit;
import Entity.Unit.Unit;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.GameMap;
import GameMap.MapCoordinate;
import GameMap.Tile;
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
        int total = production.foodRate * workerCount;
        entityManager.playerOwner.gainFood(total);
        //assuming food is never exhausted and it is a renewable resource
    }

    public void harvestOre(int workerCount, MapCoordinate location){
        int requestedAmount = production.oreRate * workerCount;
        Tile tile = GameMap.getInstance().getTile(location);
        int availableAmount = tile.getResources().getOre();
        if(availableAmount > requestedAmount){
            entityManager.playerOwner.gainFood(requestedAmount);
            tile.getResources().decrementOre(requestedAmount);
        }
        else{
            entityManager.playerOwner.gainOre(availableAmount);
            tile.getResources().decrementOre(availableAmount);
        }
    }

    public void harvestEnergy(int workerCount, MapCoordinate location){
        int requestedAmount = production.energyRate * workerCount;
        Tile tile = GameMap.getInstance().getTile(location);
        int availableAmount = tile.getResources().getEnergy();
        if(availableAmount > requestedAmount){
            entityManager.playerOwner.gainEnergy(requestedAmount);
            tile.getResources().decrementEnergy(requestedAmount);
        }
        else{
            entityManager.playerOwner.gainEnergy(availableAmount);
            tile.getResources().decrementEnergy(availableAmount);
        }
    }

/*    public void assignProduce(int workerCount, Resource resource) {
        resource.incrementAmount( productionRate*workerCount);
    }*/

    public void producePower(int workerCount){
        entityManager.playerOwner.gainPower(production.powerRate * workerCount);
    }

    public void produceNutrients(int workerCount){
        entityManager.playerOwner.gainNutrients(production.nutrientsRate * workerCount);
    }

    public void produceMetal(int workerCount){
        entityManager.playerOwner.gainMetal(production.metalRate * workerCount);
    }

    public void breedWorkers(int workerCount) {
        workers.incrementNumberOfWorkers(production.breedRate*workerCount/2);
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
