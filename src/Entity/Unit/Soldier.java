package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    Soldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.*;
import GameMap.MapCoordinate;
import Player.EntityManager;

public abstract class Soldier extends Unit {

    public Soldier(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(name, instanceID, location, entityManager);
    }



    public void takeDamage(Entity entity, String mode){
        int damage = 0;
        if(mode == "Attack") { damage = entity.getAttack(); }
        if(mode == "Defend") { damage = entity.getDefense(); }
        if(damage == 0) { System.out.println("Something went wrong in takeDamage"); }
        this.currentHealth -= damage - this.getArmor();
        //System.out.println(damage - this.getArmor() + " damage was taken by Player " + this.getEntityManager().playerOwner.getpID() + "'s " + this.getName());

        //System.out.println("target's direction: " + getDirection() + ", attacker's direction:: " + entity.getDirection());

        if(this.currentHealth <= 0){
            System.out.println("Player " + this.getEntityManager().playerOwner.getpID() + "'s " + this.getName() + " died");
            destroy();
            return;
        }

        if(this.getDirection() == entity.getDirection().getOpposite() && this.getState() == "Defend"){
            //System.out.println(this.getName() + " defended successfully!");
            entityManager.retaliate(this, entity);
        }
    }
}
