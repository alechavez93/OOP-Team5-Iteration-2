package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    Structure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Abstract Structure class
|       Needs a transfer workers function for all structures to inherit once the structure is built
---------------------------------------------------------------------------------------*/

import Entity.*;
import GameMap.MapCoordinate;
import Player.EntityManager;
import Technology.StructureTechnology.StructureTechnology;

public abstract class Structure extends Entity{
    Production production;
    Worker workers;
    int workRadius;

    public Structure(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(name, instanceID, location, entityManager);
        this.workers = new Worker(0);
        this.workRadius = 1;
        this.production = new Production(0,0,0,0,0,0,0,0,0);

    }

    public void acceptTech(StructureTechnology tech){
        tech.visit(this);
    }

/*    public void upgrade(String string){

    }*/

    public void upgradeFoodRate() {
        this.production.foodRate *= 1.1;
    }

    public void upgradeEnergyRate() {
        this.production.energyRate *= 1.1;
    }

    public void upgradeOreRate() {
        this.production.oreRate *= 1.1;
    }

    public void upgradePowerRate() {
        this.production.energyRate *= 1.1;
    }

    public void upgradeNutrientsRate() {
        this.production.nutrientsRate *= 1.1;
    }

    public void upgradeMetalRate() {
        this.production.metalRate *= 1.1;
    }

    public void upgradeBreedRate() {
        this.production.breedRate *= 1.1;
    }

    public void upgradeExplorerRate() {
        this.production.explorerRate *= 1.1;
    }

    public void upgradeSolderRate() {
        this.production.soldierRate *= 1.1;
    }

    public Worker getWorkers() {
        return workers;
    }

    public void setWorkers(Worker workers) { this.workers = workers; }

    public void processUpkeep(){
        if(!entityManager.spendResources(0,upkeep,0)){
            degrade();
        }
    }

    public Production getProduction() { return production; }

}
