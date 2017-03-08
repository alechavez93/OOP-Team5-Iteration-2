package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    Soldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameMap.MapCoordinate;
import Player.EntityManager;

public abstract class Soldier extends Unit {

    public Soldier(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(name, instanceID, location, entityManager);
    }

    public void takeDamage(Entity entity){
        this.currentHealth -= (entity.getAttack() - this.getArmor());
        System.out.println(entity.getAttack() - this.getArmor() + " damage was taken by " + this.getName());
        if(this.getDirection() == entity.getDirection().getOpposite() && this.getState() == "Defend"){
            System.out.println(this.getName() + " defended successfully!");
            entityManager.retaliate(this, entity);
        }
    }
}
