package Player;

import Entity.*;
import Entity.Army.Army;
import Entity.Structure.*;
import Entity.Unit.*;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import GameLibrary.GameLibrary;
import GameMap.*;
import Technology.EntityTechnology.EntityTechnology;
import Technology.StructureTechnology.StructureTechnology;
import Technology.Technology;
import Utility.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Thomas on 02/19/2017.
 */

/*--------------------------------------------------------------------------------------
|    EntityManager Module: Created by Thomas on 02/19/2017.
|---------------------------------------------------------------------------------------
|   Description: Used to hold Units, Structures, and Armies for each Player
|
---------------------------------------------------------------------------------------*/

public class EntityManager {

    public Player playerOwner;
//not sure if these need to be public or private
    private int colonistUnitCount;
    private int explorerUnitCount;
    private int meleeUnitCount;
    private int rangeUnitCount;
    private int unitCount;
    private int structureCount;
    private int armyCount;
    private int capitalCount;
    private int farmCount;
    private int fortCount;
    private int mineCount;
    private int observationCount;
    private int powerCount;
    private int universityCount;

    private List<Entity> colonistUnitList;
    private List<Entity> explorerUnitList;
    private List<Entity> meleeUnitList;
    private List<Entity> rangeUnitList;
    private List<Entity> capitalList;
    private List<Entity> farmList;
    private List<Entity> mineList;
    private List<Entity> powerList;
    private List<Entity> fortList;
    private List<Entity> observationList;
    private List<Entity> universityList;

    private List<Entity> armyList;

    private HashSet hashset;

    private int maxUnitCount = 25;
    private int maxStructureCount = 10;
    private int maxArmyCount = 10;


    public EntityManager(Player owner){
        this.playerOwner = owner;
        this.colonistUnitCount = 0;
        this.explorerUnitCount = 0;
        this.meleeUnitCount = 0;
        this.rangeUnitCount = 0;
        this.unitCount = 0;
        this.structureCount = 0;
        this.capitalCount = 0;
        this.farmCount = 0;
        this.fortCount = 0;
        this.mineCount = 0;
        this.observationCount = 0;
        this.powerCount = 0;
        this.universityCount = 0;

        colonistUnitList = new ArrayList<Entity>();
        explorerUnitList = new ArrayList<Entity>();
        meleeUnitList = new ArrayList<Entity>();
        rangeUnitList = new ArrayList<Entity>();
        capitalList = new ArrayList<Entity>();
        farmList = new ArrayList<Entity>();
        mineList = new ArrayList<Entity>();
        powerList = new ArrayList<Entity>();
        fortList = new ArrayList<Entity>();
        observationList = new ArrayList<Entity>();
        universityList = new ArrayList<Entity>();
        armyList = new ArrayList<Entity>();
        hashset = new HashSet<Integer>();
    }

    public void init(MapCoordinate location){

        ColonistUnit c0 = new ColonistUnit(nextColonistIndex(), location, this);
        this.addColonist(c0);

        ExplorerUnit e0 = new ExplorerUnit(nextExplorerIndex(), location, this);
        this.addExplorer(e0);
        e0.setDirection(Direction.NorthEast);

        ExplorerUnit e1 = new ExplorerUnit(nextExplorerIndex(), location, this);
        this.addExplorer(e1);
        e1.setDirection(Direction.NorthWest);
    }

    public void finishTurn(){
        List<Entity> everything = getAllEntities();
        ListIterator<Entity> entityListIterator = everything.listIterator();
        while ( entityListIterator.hasNext()){
            entityListIterator.next().finishTurn();
        }
        for(Entity entity: armyList){
            ((Army) entity).getRallyPoint().processQueue();
        }
    }

    public void accept( EntityTechnology technology){
        List<Entity> everything = getAllEntities();
        ListIterator<Entity> entityListIterator = everything.listIterator();
        while ( entityListIterator.hasNext()){
            entityListIterator.next().acceptTech(technology);
        }
    }

    public void accept(StructureTechnology technology){

    }

    public void accept(Technology tech){

    }

    public List<Entity> getAllEntities(){
        List<Entity> totalList = new ArrayList<Entity>();
        addUnique(totalList, colonistUnitList);
        addUnique(totalList, explorerUnitList);
        addUnique(totalList, meleeUnitList);
        addUnique(totalList, rangeUnitList);
        totalList.addAll(capitalList);
        totalList.addAll(farmList);
        totalList.addAll(fortList);
        totalList.addAll(mineList);
        totalList.addAll(observationList);
        totalList.addAll(powerList);
        totalList.addAll(universityList);
        totalList.addAll(armyList);

        return totalList;

    }

    public void addUnique(List<Entity> totallist, List<Entity> entityList){
        for(Entity entity : entityList)
        if(!(((Unit) entity ).getInArmy())){
            totallist.add(entity);
        }
    }

/*
//not sure if this is needed
    public ColonistUnit newColonist(MapCoordinate coordinate){
        int index = nextColonistIndex();
        if(index != -1){
            ColonistUnit colonist = new ColonistUnit(index, coordinate );
            return colonist;
        }
        return null;
        //System.out.println("Invalid request");
    }

    public ExplorerUnit newExplorer(MapCoordinate coordinate){
        int index = nextExplorerIndex();
        if(index != -1){
            ExplorerUnit explorer = new ExplorerUnit(index, coordinate );
            return explorer;
        }
        return null;
        //System.out.println("Invalid request");
    }*/


    public void addColonist(ColonistUnit colonist){

        if(colonist.getInstanceID() == -1){
            System.out.println("invalid unit added. Process quit.");
            return;
        }

        colonistUnitList.add(colonist);
        hashset.add(colonist.getInstanceID());
        placeEntity(colonist);
        colonistUnitCount++;
        unitCount++;
    }

    public void addExplorer(ExplorerUnit explorer){

        if(explorer.getInstanceID() == -1){
            System.out.println("invalid unit added. Process quit.");
            return;
        }

        explorerUnitList.add(explorer);
        hashset.add(explorer.getInstanceID());
        placeEntity(explorer);
        explorerUnitCount++;
        unitCount++;
    }

    public void addMelee(MeleeSoldier melee){

        if(melee.getInstanceID() == -1){
            System.out.println("invalid unit added. Process quit.");
            return;
        }

        meleeUnitList.add(melee);
        hashset.add(melee.getInstanceID());
        placeEntity(melee);
        meleeUnitCount++;
        unitCount++;
    }

    public void addRange(RangeSoldier range){

        if(range.getInstanceID() == -1){
            System.out.println("invalid unit added. Process quit.");
            return;
        }

        rangeUnitList.add(range);
        hashset.add(range.getInstanceID());
        placeEntity(range);
        rangeUnitCount++;
        unitCount++;
    }

    public void addCapital(CapitalStructure capital){

        if(capital.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        capitalList.add(capital);
        hashset.add(capital.getInstanceID());
        placeEntity(capital);
        capitalCount++;
        structureCount++;
    }

    public void addFarm(FarmStructure farm){

        if(farm.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        farmList.add(farm);
        hashset.add(farm.getInstanceID());
        placeEntity(farm);
        farmCount++;
        structureCount++;
    }

    public void addFort(FortStructure fort){

        if(fort.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        fortList.add(fort);
        hashset.add(fort.getInstanceID());
        placeEntity(fort);
        fortCount++;
        structureCount++;
    }

    public void addMine(MineStructure mine){

        if(mine.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        mineList.add(mine);
        hashset.add(mine.getInstanceID());
        placeEntity(mine);
        mineCount++;
        structureCount++;
    }

    public void addObservation(ObservationStructure observation){

        if(observation.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        observationList.add(observation);
        hashset.add(observation.getInstanceID());
        placeEntity(observation);
        observationCount++;
        structureCount++;
    }

    public void addPower(PowerStructure power){

        if(power.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        powerList.add(power);
        hashset.add(power.getInstanceID());
        placeEntity(power);
        powerCount++;
        structureCount++;
    }

    public void addUniversity(UniversityStructure university){

        if(university.getInstanceID() == -1){
            System.out.println("invalid structure added. Process quit.");
            return;
        }

        universityList.add(university);
        hashset.add(university.getInstanceID());
        placeEntity(university);
        universityCount++;
        structureCount++;
    }

    public void addArmy(Army army){

        if(army.getInstanceID() == -1){
            System.out.println("invalid army added. Process quit.");
            return;
        }

        armyList.add(army);
        hashset.add(army.getInstanceID());
        //does army get placed on the tile? I think not
        armyCount++;
        placeEntity(army);
    }

    public void placeEntity(Entity entity){
        Tile t = GameMap.getInstance().getTile(entity.getLocation().getRow(), entity.getLocation().getColumn());
        t.addEntity(entity);
    }



    //removing or deleting entities
    public void removeEntity(Entity entity){
        Tile t = GameMap.getInstance().getTile(entity.getLocation().getRow(), entity.getLocation().getColumn());
        t.removeEntity(entity);
    }

/*    public void destroyEntity(Entity entity){
        removeEntity(entity);
        if(0 <= entity.getInstanceID() && entity.getInstanceID() < 10){
            colonistUnitCount--;
            unitCount--;
            colonistUnitList.remove(entity);
        }
        if(10 <= entity.getInstanceID() && entity.getInstanceID() < 20){
            explorerUnitCount--;
            unitCount--;
            explorerUnitList.remove(entity);
        }
        if(20 <= entity.getInstanceID() && entity.getInstanceID() < 30){
            meleeUnitCount--;
            unitCount--;
            meleeUnitList.remove(entity);
        }
        if(30 <= entity.getInstanceID() && entity.getInstanceID() < 40){
            rangeUnitCount--;
            unitCount--;
            rangeUnitList.remove(entity);
        }

    }*/

    public void destroyColonist(ColonistUnit colonist){
        //System.out.println("Second step");
        hashset.remove(colonist.getInstanceID());
        //System.out.println("ID: " + colonist.getInstanceID());
        removeEntity(colonist);
        colonistUnitList.remove(colonist);
        colonistUnitCount--;
        unitCount--;
    }

    public void destroyExplorer(ExplorerUnit explorer){
        hashset.remove(explorer.getInstanceID() + 10);
        removeEntity(explorer);
        explorerUnitList.remove(explorer);
        explorerUnitCount--;
        unitCount--;
    }

    public void destroyMelee(MeleeSoldier melee){
        hashset.remove(melee.getInstanceID());
        removeEntity(melee);
        meleeUnitList.remove(melee);
        meleeUnitCount--;
        unitCount--;
    }

    public void destroyRange(RangeSoldier range){
        hashset.remove(range.getInstanceID());
        removeEntity(range);
        rangeUnitList.remove(range);
        rangeUnitCount--;
        unitCount--;
    }

    public void destroyCapital(CapitalStructure capital){
        hashset.remove(capital.getInstanceID() + 100);
        removeEntity(capital);
        capitalList.remove(capital);
        capitalCount--;
        structureCount--;
    }

    public void destroyFarm(FarmStructure farm){
        hashset.remove(farm.getInstanceID() + 110);
        removeEntity(farm);
        farmList.remove(farm);
        farmCount--;
        structureCount--;
    }

    public void destroyFort(FortStructure fort){
        hashset.remove(fort.getInstanceID() + 120);
        removeEntity(fort);
        fortList.remove(fort);
        fortCount--;
        structureCount--;
    }

    public void destroyMine(MineStructure mine){
        hashset.remove(mine.getInstanceID() + 130);
        removeEntity(mine);
        mineList.remove(mine);
        mineCount--;
        structureCount--;
    }

    public void destroyObserver(ObservationStructure observer){
        hashset.remove(observer.getInstanceID() + 140);
        removeEntity(observer);
        observationList.remove(observer);
        observationCount--;
        structureCount--;
    }

    public void destroyPower(PowerStructure power){
        hashset.remove(power.getInstanceID() + 150);
        removeEntity(power);
        powerList.remove(power);
        powerCount--;
        structureCount--;
    }

    public void destroyUniversity(UniversityStructure university){
        hashset.remove(university.getInstanceID() + 160);
        removeEntity(university);
        universityList.remove(university);
        universityCount--;
        structureCount--;
    }

    public void destroyArmy(Army army){
        hashset.remove(army.getInstanceID() + 200);
        armyList.remove(army);
        armyCount--;
    }

    public void disbandArmy(Army army){
        //do something
    }


/*    public void removeArmy(Army army){
        Tile t = GameMap.getInstance().getTile(army.getRallyPoint().getLocation().getRow(), army.getRallyPoint().getLocation().getColumn());
        t.removeArmy(army);
        //maybe add back in each unit in the army? I'm not sure for now.
    }*/

/*--------------------------------------------------------------------------------------
|    List of positions in the HashSet. Entity's  instanceID will be the last digit
|---------------------------------------------------------------------------------------
|
|   0-9     colonist
|   10-19   explorer
|   20-29   melee
|   30-39   range
|
|   100-109 capital
|   110-119 farm
|   120-129 fort
|   130-139 mine
|   140-149 observer
|   150-159 power
|   160-169 university
|
|   200+    army
---------------------------------------------------------------------------------------*/


    //functions to find the next available (unique) index

    public int nextUnitIndex(int start, int end){
        if(unitCount >= maxUnitCount)
            return -1;
        for(int i = start; i < end; i ++){
            if( !hashset.contains(i) ){
                return i;
            }
        }
        return -1;
    }

    public int nextColonistIndex() {
        return nextUnitIndex(0, 10);
    }


    public int nextExplorerIndex(){
        return nextUnitIndex(10, 20);
    }

//  was originally
//    public int nextExplorerIndex(){
//        if(unitCount >= maxUnitCount)
//            return -1;
//
//        for(int i = 10; i < 20; i ++){
//            if( !hashset.contains(i) ){
//                //System.out.println("found index at :" + i);
//                return i;
//            }
//        }
//
//        //System.out.println("something happened");
//        return -1;
//    }

    public int nextMeleeIndex(){
        return nextUnitIndex(20, 30);
    }

    public int nextRangeIndex(){
        return nextUnitIndex(30, 40);
    }


    public int nextStructureIndex(int start, int end){
        if(structureCount >= maxStructureCount)
            return -1;
        for(int i = start; i < end; i ++){
            if( !hashset.contains(i) ){
                return i;
            }
        }
        return -1;
    }

    public int nextCapitalIndex(){
        return nextStructureIndex(100, 110);
    }

    public int nextFarmIndex(){
        return nextStructureIndex(110, 120);
    }

    public int nextFortIndex(){
        return nextStructureIndex(120, 130);
    }

    public int nextMineIndex(){
        return nextStructureIndex(130, 140);
    }

    public int nextObservationIndex(){
        return nextStructureIndex(140, 150);
    }

    public int nextPowerIndex(){
        return nextStructureIndex(150, 160);
    }

    public int nextUniversityIndex(){
        return nextStructureIndex(160, 170);
    }

    public int nextArmyIndex(){
        if(armyCount >= maxArmyCount)
            return -1;
        for(int i = 200; i < 210; i ++){
            if( !hashset.contains(i) ){
                return i;
            }
        }
        return -1;
    }


    //general getters

    public List<Entity> getColonistList(){
        return colonistUnitList;
    }


    public List<Entity> getExplorerUnitList(){
        return explorerUnitList;
    }

    public List<Entity> getMeleeUnitList(){
        return meleeUnitList;
    }

    public List<Entity> getRangeUnitList(){
        return rangeUnitList;
    }

    public List<Entity> getCapitalList(){
        return capitalList;
    }

    public List<Entity> getFarmList(){
        return farmList;
    }

    public List<Entity> getFortList(){
        return fortList;
    }

    public List<Entity> getMineList(){
        return mineList;
    }

    public List<Entity> getObservationList(){
        return observationList;
    }

    public List<Entity> getPowerList(){
        return powerList;
    }

    public List<Entity> getUniversityList(){
        return universityList;
    }

    public List<Entity> getArmyList() { return armyList; }

    public int getColonistUnitCount(){ return colonistUnitCount; }

    public int getExplorerUnitCount(){return explorerUnitCount; }

    public int getMeleeUnitCount(){ return meleeUnitCount; }

    public int getRangeUnitCount(){ return rangeUnitCount; }

    public int getUnitCount(){ return unitCount; }

    public int getStructureCount(){ return structureCount; }

    public int getArmyCount(){ return armyCount; }

    public int getCapitalCount(){ return capitalCount; }

    public int getFarmCount(){ return  farmCount; }

    public int getFortCount() { return fortCount; }

    public int getMineCount(){ return mineCount; }

    public int getObservationCount(){ return observationCount; }

    public int getPowerCount(){ return powerCount; }

    public int getUniversityCount(){ return universityCount; }

    public Direction calcDirection(Entity entity, MapCoordinate coordinate) {

        int x1 = entity.getLocation().getColumn();
        int y1 = entity.getLocation().getRow();
        int x2 = coordinate.getColumn();
        int y2 = coordinate.getRow();
        //System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2);

        if (x2 == x1 && y2 > y1 ) { return Direction.South; }
        if (x2 < x1 && y2 >= y1 ) { return Direction.SouthWest; }
        if (x2 > x1 && y2 > y1 )  { return Direction.SouthEast; }


        if ( x2 == x1 && y2 < y1 ) { return Direction.North; }
        if ( x2 < x1 && y2 < y1 )  { return Direction.NorthWest; }
        if ( x2 > x1 && y2 <= y1 ) { return Direction.NorthEast; }

        if (x2 == x1 && y2 == y1) { return entity.getDirection(); }

        System.out.println("Something broke in getDirection");
        return Direction.South;

    }


    //managing interactions between entities
    public void attack(Entity entity, MapCoordinate coordinate){
        Direction direction = calcDirection(entity, coordinate);
        entity.setDirection(direction);
        //System.out.println("Attacking direction: " + direction.getAngle());
        entity.setState(GameLibrary.ATTACK);
        Tile t = GameMap.getInstance().getTile(coordinate);
        //System.out.println("Player " + entity.getEntityManager().playerOwner.getpID() + "'s " + entity.getName() + " is attacking (" + t.getPos().getRow() + " , " + t.getPos().getColumn() + ")");
        //System.out.println(t.getOccupyingEntities().length + " targets attacked");
        for (Entity target : t.getOccupyingEntities()) {
            //System.out.println("Attacking " + entity.getName());
            target.takeDamage(entity, GameLibrary.ATTACK);
        }
    }

    public void defend(Entity entity, Direction direction){
        entity.setDirection(direction);
        entity.setState(GameLibrary.DEFEND);
    }

    public void retaliate(Entity defender, Entity Attacker){
        //System.out.println("Retaliate was called");
        Attacker.takeDamage(defender, GameLibrary.DEFEND);
    }

    public boolean spendResources(int food, int ore, int energy) {
        if ((playerOwner.getFood() > food) && (playerOwner.getOre() > ore) && (playerOwner.getEnergy() > energy)) {
            playerOwner.spendFood(food);
            playerOwner.spendOre(ore);
            playerOwner.spendEnergy(energy);
            return true;
        }
        return false;
    }

}
