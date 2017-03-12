package Player;

import Entity.*;
import Entity.Unit.ColonistUnit;
import GameMap.MapCoordinate;
import Utility.Coordinate;

/**
 * Created by Thomas on 02/19/2017.
 */

/*--------------------------------------------------------------------------------------
|    Player Module: Created by Thomas on 02/19/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Player {
    private int pID;
    private EntityManager entityManager;
    private ItemManager itemManager;
    private TechManager techManager;
    private int food;
    private int stone;
    private int wood;

    public Player(int id, MapCoordinate location){
        this.pID = id;
        this.entityManager = new EntityManager(this);
        entityManager.init(location);
        //itemManager = new ItemManager(this);
        techManager = new TechManager(this);
        this.food = 500;
        this.stone = 500;
        this.wood = 500;

    }

    @Override
    public String toString() {
        return "Player " + pID;
    }

    public int getpID() { return this.pID; }
    public int getFood(){ return this.food; }
    public int getWood(){ return this.wood; }
    public int getStone(){ return this.stone; }


    public void gainFood(int amount) { this.food += amount; }
    public void gainWood(int amount) { this.wood += amount; }
    public void gainStone(int amount) {this.stone += amount; }

    public boolean spendFood(int amount){
        if( this.food > amount){
            this.food -= amount;
            return true;
        }
        return false;
    }

    public boolean spendStone(int amount){
        if( this.stone > amount){
            this.stone -= amount;
            return true;
        }
        return false;
    }

    public boolean spendWood(int amount){
        if( this.wood > amount){
            this.wood -= amount;
            return true;
        }
        return false;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void endTurn(){
        entityManager.finishTurn();
        //do other stuff maybe
    }

    //public int getCapitalCount(){ return entityManager.getCapitalCount();}

    }

