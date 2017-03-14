package Entity.Army;
/*--------------------------------------------------------------------------------------
|	Army Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Encapsulates a battle group and a list of the reinforcing units.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Unit.*;
import GameMap.MapCoordinate;
import Player.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class Army extends Entity{

    private List<Unit> battleGroup;
    private List<Unit> reinforcement;
    private RallyPoint rallyPoint;
    private int meleeAttack;
    private int rangeAttack;
    private boolean isAttacking;

    public Army(String name, int instanceID, MapCoordinate location, EntityManager entityManager, Unit initial) {
        super(name, instanceID, location, entityManager);
        battleGroup = new ArrayList<>();
        reinforcement = new ArrayList<>();
        this.battleGroup.add(initial);
        this.rallyPoint = new RallyPoint(initial.getLocation(), initial.getEntityManager());
        isAttacking = false;
        updateStats();
    }

    private void updateAttack(){
        meleeAttack = 0;
        rangeAttack = 0;
        for(Unit unit: battleGroup){
            if(unit instanceof MeleeSoldier){
                meleeAttack += unit.getAttack();
            }else if(unit instanceof RangeSoldier){
                rangeAttack += unit.getAttack();
            }
        }
    }

    private  void updateTotalStats(){
        resetStats();
        int minSpeed = 5;
        int maxVisibility = 0;
        int minRange = 3;
        //Regular Stats
        for(Unit unit: battleGroup){
            //Update speed
            if(unit.getMovement() < minSpeed) minSpeed = unit.getMovement();
            //Update visibility
            if(unit.getVisibilityRadius() > maxVisibility) maxVisibility = unit.getVisibilityRadius();
            //Update range
            if(unit instanceof Soldier && unit.getRangeRadius() < minRange ) minRange = unit.getRangeRadius();
            attack += unit.getAttack();
            defense += unit.getDefense();
            armor += unit.getArmor();
            maxHealth += unit.getMaxHealth();
            upkeep += unit.getUpkeep();
        }

        //Movement for the Army
        movement = minSpeed;
        //Visibility for the army
        visibilityRadius = maxVisibility;
        //Ranged for army
        rangeRadius = minRange;
    }

    public void updateStats(){
        updateAttack();
        updateTotalStats();
    }

    @Override
    public void destroy(){
        for(Unit unit: battleGroup){
            unit.destroy();
        }
        for(Unit unit: reinforcement){
            unit.destroy();
        }
        entityManager.destroyArmy(this);
    }

    public void addReinforcement(Unit unit){
        reinforcement.add(unit);
    }

    public void updateArmyReinforcement(){
        List<Unit> arrived = new ArrayList<>();
        for(Unit unit: reinforcement){
            if(unit.getLocation().equals(getLocation())){
                battleGroup.add(unit);
                arrived.add(unit);
                currentHealth += unit.getCurrentHealth();
                updateStats();
            }
        }
        for(Unit removed: arrived){
            reinforcement.remove(removed);
        }
    }
}
