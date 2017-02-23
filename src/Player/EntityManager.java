package Player;

import Entity.*;
import Entity.Army.Army;
import Entity.Structure.*;
import Entity.Unit.*;
import GameMap.*;
import Utility.Coordinate;

import javax.swing.border.EtchedBorder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

    private List<Army> armyList;

    private HashSet hashset;

    private int maxUnitCount = 25;
    private int maxStructureCount = 10;


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
        armyList = new ArrayList<Army>();
        hashset = new HashSet<Integer>();
    }

    public void init(MapCoordinate location){

        ColonistUnit c0 = new ColonistUnit(nextColonistIndex(), location);
        this.addColonist(c0);
        placeEntity(c0);

        ExplorerUnit e0 = new ExplorerUnit(nextExplorerIndex(), new MapCoordinate(location.getRow()+1, location.getColumn()));
        this.addExplorer(e0);
        placeEntity(e0);

        ExplorerUnit e1 = new ExplorerUnit(nextExplorerIndex(), location);
        this.addExplorer(e1);
        placeEntity(e1);
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
        colonistUnitList.add(colonist);
        hashset.add(colonist.getInstanceID());

        colonistUnitCount++;
        unitCount++;
    }

    public void addExplorer(ExplorerUnit explorer){
        explorerUnitList.add(explorer);
        hashset.add(explorer.getInstanceID()+10);

        explorerUnitCount++;
        unitCount++;
    }

    public void addMelee(MeleeSoldier melee){
        meleeUnitList.add(melee);
        hashset.add(melee.getInstanceID()+20);

        meleeUnitCount++;
        unitCount++;
    }

    public void addRange(RangeSoldier range){
        rangeUnitList.add(range);
        hashset.add(range.getInstanceID()+30);

        rangeUnitCount++;
        unitCount++;
    }

    public void addCapital(CapitalStructure capital){
        capitalList.add(capital);
        hashset.add(capital.getInstanceID() + 100);

        capitalCount++;
        structureCount++;
    }

    public void addFarm(FarmStructure farm){
        farmList.add(farm);
        hashset.add(farm.getInstanceID() + 110);

        farmCount++;
        structureCount++;
    }

    public void addFort(FortStructure fort){
        fortList.add(fort);
        hashset.add(fort.getInstanceID() + 120);

        fortCount++;
        structureCount++;
    }

    public void addMine(MineStructure mine){
        mineList.add(mine);
        hashset.add(mine.getInstanceID() + 130);

        mineCount++;
        structureCount++;
    }

    public void addObservation(ObservationStructure observation){
        observationList.add(observation);
        hashset.add(observation.getInstanceID() + 140);

        observationCount++;
        structureCount++;
    }

    public void addPower(PowerStructure power){
        powerList.add(power);
        hashset.add(power.getInstanceID() + 150);

        powerCount++;
        structureCount++;
    }

    public void addUniversity(UniversityStructure university){
        universityList.add(university);
        hashset.add(university.getInstanceID() + 160);

        universityCount++;
        structureCount++;
    }

    public void addArmy(Army army){
        armyList.add(army);
        hashset.add(army.getInstanceID() + 200);

        armyCount++;
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

    public void destroyColonist(ColonistUnit colonist){
        hashset.remove(colonist.getInstanceID());
        removeEntity(colonist);
    }

    public void destroyExplorer(ExplorerUnit explorer){
        hashset.remove(explorer.getInstanceID() + 10);
        removeEntity(explorer);
    }

    public void destroyMelee(MeleeSoldier melee){
        hashset.remove(melee.getInstanceID());
        removeEntity(melee);
    }

    public void destroyRange(RangeSoldier range){
        hashset.remove(range.getInstanceID());
        removeEntity(range);
    }

    public void destroyCapital(CapitalStructure capital){
        hashset.remove(capital.getInstanceID() + 100);
        removeEntity(capital);
    }

    public void destroyFarm(FarmStructure farm){
        hashset.remove(farm.getInstanceID() + 110);
        removeEntity(farm);
    }

    public void destroyFort(FortStructure fort){
        hashset.remove(fort.getInstanceID() + 120);
        removeEntity(fort);
    }

    public void destroyMine(MineStructure mine){
        hashset.remove(mine.getInstanceID() + 130);
        removeEntity(mine);
    }

    public void destroyObserver(ObservationStructure observer){
        hashset.remove(observer.getInstanceID() + 140);
        removeEntity(observer);
    }

    public void destroyPower(PowerStructure power){
        hashset.remove(power.getInstanceID() + 150);
        removeEntity(power);
    }

    public void destroyUniversity(UniversityStructure university){
        hashset.remove(university.getInstanceID() + 160);
        removeEntity(university);
    }

    public void destroyArmy(Army army){
        hashset.remove(army.getInstanceID() + 200);
        removeArmy(army);
    }

    public void removeArmy(Army army){
        Tile t = GameMap.getInstance().getTile(army.getLocation().getRow(), army.getLocation().getColumn());
        t.addEntity(entity);
    }

/*--------------------------------------------------------------------------------------
|    List of positions in the hashset
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
                return i%10;
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
//                return i%10;
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
                return i%10;
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
        return nextStructureIndex(200, 210);
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

}
