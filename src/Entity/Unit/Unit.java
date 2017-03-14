package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    Unit Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Abstract Unit class
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameMap.MapCoordinate;
import Player.EntityManager;

public abstract class Unit extends Entity {
    private boolean inArmy;
    private boolean isMoving;

    public Unit(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(name, instanceID, location, entityManager);
        inArmy = false;
        isMoving = false;
    }

    public void upgradeSpeed() {
        movement++;
    }

    public void createArmy() {

    }

    public boolean getInArmy() { return inArmy; }

    public void setInArmy(boolean inArmy) { this.inArmy = inArmy; }


    public void processUpkeep() {
        if (!entityManager.spendResources(upkeep, 0, 0)) {
            degrade();
        }
    }

    public void isMoving(boolean isMoving) {this.isMoving = isMoving;}

    public void processQueue() {
        if(!isMoving)
            super.processQueue();
    }

}
