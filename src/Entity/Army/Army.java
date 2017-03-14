package Entity.Army;
/*--------------------------------------------------------------------------------------
|	Army Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Encapsulates a battle group and a list of the reinforcing units.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Unit.*;
import GameLibrary.GameLibrary;
import Game.Game;
import GameMap.GameMap;
import GameMap.MapCoordinate;
import GameMap.Path;
import GameMap.AStarPathFinder;
import Player.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class Army extends Entity{

    private List<Unit> battleGroup;
    private List<UnitPath> reinforcement;
    private RallyPoint rallyPoint;
    private Path path;
    private int meleeAttack;
    private int rangeAttack;
    private boolean isAttacking;
    private boolean atRallyPoint;

    private class UnitPath {
        public Path path;
        public Unit unit;

        public UnitPath(Path p, Unit u) {
            this.path = p;
            this.unit = u;
        }
    }

    public Army(int instanceID, MapCoordinate location, EntityManager entityManager, Unit initial) {
        super(GameLibrary.ARMY_MODE, instanceID, location, entityManager);
        battleGroup = new ArrayList<>();
        reinforcement = new ArrayList<>();
        this.battleGroup.add(initial);
        this.rallyPoint = new RallyPoint(initial.getLocation(), initial.getEntityManager());
        isAttacking = false;
        updateStats();
    }

    public RallyPoint getRallyPoint() {
        return rallyPoint;
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
            currentHealth += unit.getCurrentHealth();
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
        for(UnitPath u: reinforcement){
            u.unit.destroy();
        }
        entityManager.destroyArmy(this);
    }

    public void addReinforcement(Unit unit){
        Path p = null;
        unit.getEntityManager().removeEntity(unit);
        if(!unit.getLocation().equals(getLocation())) {
            p = (new AStarPathFinder()).createPath(unit.getLocation(), rallyPoint.getLocation());
            unit.isMoving(true);
        }
        UnitPath up = new UnitPath(p, unit);
        reinforcement.add(up);

    }

    public void updateArmyReinforcement(){
        List<UnitPath> arrived = new ArrayList<>();
        for(UnitPath u: reinforcement){
            if(u.unit.getLocation().equals(getLocation())){
                u.unit.isMoving(false);
                battleGroup.add(u.unit);
                arrived.add(u);
                currentHealth += u.unit.getCurrentHealth();
                updateStats();
            }
        }

        for(UnitPath removed: arrived){
            reinforcement.remove(removed);
        }
    }

    public void finishTurn() {
        super.finishTurn();
        processMovement();
    }

    public void processMovement() {
        if(!atRallyPoint) {
            if(!path.isValid()) {}
                //path.recreate(getLocation());
            int speed = movement;
            while(speed > 0) {
                GameMap.getInstance().shiftEntity(this,path.next());
                speed -= GameMap.getInstance().getTile(getLocation()).getMovementCost();
            }
            atRallyPoint = getLocation().equals(rallyPoint.getLocation());
        } else {
            //Don't want to reinforce until battleGroup is actually there
            updateArmyReinforcement();
            for(UnitPath u : reinforcement) {
                if(!u.path.isValid()) {}
                //path.recreate(getLocation());
                int speed = u.unit.movement;
                while(speed > 0) {
                    GameMap.getInstance().shiftEntity(u.unit,u.path.next());
                    speed -= GameMap.getInstance().getTile(getLocation()).getMovementCost();
                }
            }
        }
    }

    public void moveRallypoint(MapCoordinate newLoc) {
        rallyPoint.setLocation(newLoc);
        atRallyPoint = getLocation().equals(newLoc);
        if(!atRallyPoint) {
            path = (new AStarPathFinder()).createPath(getLocation(),newLoc);
        }
    }

}
