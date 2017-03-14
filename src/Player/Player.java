package Player;

import GameMap.MapCoordinate;

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
    private String name;
    private EntityManager entityManager;
    private ItemManager itemManager;
    private TechManager techManager;
    private int food;
    private int ore;
    private int energy;

    public Player(int id, MapCoordinate location){
        this.pID = id;
        this.entityManager = new EntityManager(this);
        entityManager.init(location);
        //itemManager = new ItemManager(this);
        techManager = new TechManager(this);
        this.food = 300;
        this.ore = 400;
        this.energy = 300;

    }

    public Player(int id, String name, MapCoordinate location){
        this.pID = id;
        this.name = name;
        this.entityManager = new EntityManager(this);
        entityManager.init(location);
        //itemManager = new ItemManager(this);
        //techManager = new TechManager(this);
        this.food = 300;
        this.ore = 300;
        this.energy = 300;

    }

    @Override
    public String toString() {
        return "Player " + pID;
    }

    public int getpID() { return this.pID; }
    public int getFood(){ return this.food; }
    public int getEnergy(){ return this.energy; }
    public int getOre(){ return this.ore; }
    public String getName(){ return name; }


    public void gainFood(int amount) { this.food += amount; }
    public void gainEnergy(int amount) { this.energy += amount; }
    public void gainOre(int amount) {this.ore += amount; }
    public void printResources() { System.out.println("Food: " + food + ", Ore: " + ore + ", Energy: " + energy); }

    public boolean spendFood(int amount){
        if( this.food > amount){
            this.food -= amount;
            return true;
        }
        return false;
    }

    public boolean spendOre(int amount){
        if( this.ore > amount){
            this.ore -= amount;
            return true;
        }
        return false;
    }

    public boolean spendEnergy(int amount){
        if( this.energy > amount){
            this.energy -= amount;
            return true;
        }
        return false;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
    public TechManager getTechManager() { return techManager; }

    public void endTurn(){

//        itemManager.finishTurn();
        entityManager.finishTurn();
//        techManager.finishTurn();
        //do other stuff maybe
    }

    //public int getCapitalCount(){ return entityManager.getCapitalCount();}

    }

