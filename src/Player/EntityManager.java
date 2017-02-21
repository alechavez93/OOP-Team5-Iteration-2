package Player;

import Entity.*;
import Entity.Structure.*;
import Entity.Unit.*;
import Utilities.Coordinate;

import javax.swing.border.EtchedBorder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    int maxUnitCount = 25;

    //not sure if this is still needed
    //HashMap<String, List<Entity>> entityMap;


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

    public void init(Coordinate location){

        ColonistUnit c0 = new ColonistUnit(nextColonistIndex(), location);
        this.addColonist(c0);

        ExplorerUnit e0 = new ExplorerUnit(nextExplorerIndex(), new Coordinate(location.getRow()+1, location.getCol()));
        this.addExplorer(e0);

        ExplorerUnit e1 = new ExplorerUnit(nextExplorerIndex(), location);
        this.addExplorer(e1);
    }

    public ColonistUnit newColonist(Coordinate coordinate){
        int index = nextColonistIndex();
        if(index != -1){
            ColonistUnit colonist = new ColonistUnit(index, coordinate );
            return colonist;
        }
        return null;
        //System.out.println("Invalid request");
    }

    public ExplorerUnit newExplorer(Coordinate coordinate){
        int index = nextExplorerIndex();
        if(index != -1){
            ExplorerUnit explorer = new ExplorerUnit(index, coordinate );
            return explorer;
        }
        return null;
        //System.out.println("Invalid request");
    }


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


    //functions to find the next available (unique) index

    public int nextColonistIndex() {
        if (unitCount >= maxUnitCount)
            return -1;

        for (int i = 0; i < 10; i++) {
            if (!hashset.contains(i)) {
                return i % 10;
            }
        }
        return -1;
    }

    public int nextExplorerIndex(){
        if(unitCount >= maxUnitCount)
            return -1;

        for(int i = 10; i < 20; i ++){
            if( !hashset.contains(i) ){
                //System.out.println("found index at :" + i);
                return i%10;
            }
        }

        //System.out.println("something happened");
        return -1;
    }

    public int nextMeleeIndex(){
        if(unitCount >= maxUnitCount)
            return -1;

        for(int i = 20; i < 30; i ++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextRangeIndex(){
        if(unitCount >= maxUnitCount)
            return -1;

        for(int i = 30; i < 40; i ++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextCapitalIndex(){
        for(int i = 100; i < 110; i++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextFarmIndex(){
        for(int i = 110; i < 120; i++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextFortIndex(){
        for(int i = 120; i < 130; i++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextMineIndex(){
        for(int i = 130; i < 140; i++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextObservationIndex(){
        for(int i = 140; i < 150; i++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextPowerIndex(){
        for(int i = 150; i < 160; i++){
            if( !hashset.contains(i) )
                return i%10;
        }
        return -1;
    }

    public int nextUniversityIndex(){
        for(int i = 160; i < 170; i++){
            if( !hashset.contains(i) )
                return i%10;
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
}
