package Player;

import GameMap.FogOfWar;
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
    private FogOfWar fog;
    private int pID;
    private String name;
    private EntityManager entityManager;
    private ItemManager itemManager;
    private TechManager techManager;
    private int food;
    private int ore;
    private int energy;
    private int nutrients;
    private int metal;
    private int power;
    private Fog fogOfWar;

    public Player(int id, MapCoordinate location){
        this.pID = id;
        this.entityManager = new EntityManager(this);
        entityManager.init(location);
        //itemManager = new ItemManager(this);
        techManager = new TechManager(this);
        this.food = 300;
        this.ore = 400;
        this.energy = 300;
        this.fog = new FogOfWar();
        fog.calculateVisibility(entityManager.getAllEntities());
        this.nutrients = 0;
        this.metal = 0;
        this.power = 0;
        fogOfWar = new Fog(this);
    }

    public Player(int id, String name, MapCoordinate location){
        this.pID = id;
        this.name = name;
        this.entityManager = new EntityManager(this);
        entityManager.init(location);
        this.fog = new FogOfWar();
        fog.calculateVisibility(entityManager.getAllEntities());
        //itemManager = new ItemManager(this);
        //techManager = new TechManager(this);
        this.food = 300;
        this.ore = 300;
        this.energy = 300;
        fogOfWar = new Fog(this);
        this.fog = new FogOfWar();
        fog.calculateVisibility(entityManager.getAllEntities());

    }

    public Fog getFog() {
        return fogOfWar;
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
    public int getNutrients() { return this.nutrients; }
    public int getMetal() { return this.metal; }
    public int getPower() { return this.power; }


    public void gainFood(int amount) { this.food += amount; }
    public void gainEnergy(int amount) { this.energy += amount; }
    public void gainOre(int amount) {this.ore += amount; }
    public void printResources() { System.out.println("Food: " + food + ", Ore: " + ore + ", Energy: " + energy); }
    public void gainNutrients(int amount) { this.nutrients += amount; }
    public void gainMetal(int amount) { this.metal += amount; }
    public void gainPower(int amount) { this.power += amount; }

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

    public boolean spendNutrients(int amount){
        if( this.nutrients > amount){
            this.nutrients -= amount;
            return true;
        }
        return false;
    }

    public boolean spendMetal(int amount){
        if( this.metal > amount){
            this.metal -= amount;
            return true;
        }
        return false;
    }

    public boolean spendPower(int amount){
        if( this.power > amount){
            this.power -= amount;
            return true;
        }
        return false;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
    public TechManager getTechManager() { return techManager; }
    public FogOfWar getFogOfWar() { return fog; }

    public void endTurn(){
//        itemManager.finishTurn();
        entityManager.finishTurn();
        fog.calculateVisibility(entityManager.getAllEntities());
        fog.calculateProspect(entityManager.getExplorerUnitList());
//        techManager.finishTurn();
        //do other stuff maybe
    }

    //public int getCapitalCount(){ return entityManager.getCapitalCount();}

    }

