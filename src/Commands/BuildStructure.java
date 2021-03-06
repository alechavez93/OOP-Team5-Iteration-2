package Commands;

import Entity.Army.Army;
import Entity.Army.RallyPoint;
import Entity.Structure.*;
import Entity.Worker;
import static GameLibrary.GameLibrary.*;
import Player.EntityManager;

/**
 * Created by test on 03/13/2017.
 */

/*--------------------------------------------------------------------------------------
|    BuildStructure Module: Created by test on 03/13/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class BuildStructure extends Command {
    private int workerCount;
    private String structureType;
    private int workAmount;

    public BuildStructure(Army army, String structureType){
        super(BUILD_STRUCTURE, army.getRallyPoint());
        this.workerCount = army.getRallyPoint().getWorker().getNumberOfWorkers();
        this.structureType = structureType;
        workAmount = calculate(structureType);
        //army.addCommand(this);
        if(workAmount != -1)
            System.out.println("something broke");


    }


    @Override
    public void execute() {

        EntityManager entityManager = rallyPoint.getEntityManager();
        Structure structure = null;

        workAmount -= workerCount;

        if(workAmount > 0) return;

        switch (structureType){
            case FARM:  structure = new FarmStructure(entityManager.nextFarmIndex(), rallyPoint.getLocation(), entityManager, workerCount);
                        entityManager.addFarm((FarmStructure) structure);
                        break;
            case MINE:  structure = new MineStructure(entityManager.nextMineIndex(), rallyPoint.getLocation(), entityManager, workerCount);
                        entityManager.addMine((MineStructure) structure);
                        break;
            case POWER: structure = new PowerStructure(entityManager.nextPowerIndex(), rallyPoint.getLocation(), entityManager, workerCount);
                        entityManager.addPower((PowerStructure) structure);
                        break;
            case FORT:  structure = new FortStructure(entityManager.nextFortIndex(), rallyPoint.getLocation(), entityManager, workerCount);
                        entityManager.addFort((FortStructure) structure);
                        break;
            case OBSERVATION_TOWER: structure = new ObservationStructure(entityManager.nextObservationIndex(), rallyPoint.getLocation(), entityManager, workerCount);
                        entityManager.addObservation((ObservationStructure) structure);
                        break;
            case UNIVERSITY: structure = new UniversityStructure(entityManager.nextUniversityIndex(), rallyPoint.getLocation(), entityManager, workerCount);
                        entityManager.addUniversity((UniversityStructure) structure);
                        break;
            default:   break;
        }

        structure.setWorkers(new Worker(workerCount));
        rallyPoint.getWorker().decrementNumberOfWorkers(workerCount);
        isFinished = true;

    }

    public int calculate(String structureType){
        EntityManager entityManager = rallyPoint.getEntityManager();

        if(structureType.equals(FARM) && entityManager.spendResources(FARM_FOOD, FARM_ORE, FARM_ENERGY))
            return FARM_TURNS;
        else if(structureType.equals(MINE) && entityManager.spendResources(MINE_FOOD, MINE_ORE, MINE_ENERGY))
            return MINE_TURNS;
        else if(structureType.equals(POWER) && entityManager.spendResources(POWER_FOOD, POWER_ORE, POWER_ENERGY))
            return POWER_TURNS;
        else if(structureType.equals(FORT) && entityManager.spendResources(FORT_FOOD, FORT_ORE, FORT_ENERGY))
            return FORT_TURNS;
        else if(structureType.equals(OBSERVATION_TOWER) && entityManager.spendResources(OBSERVATION_FOOD, OBSERVATION_ORE, OBSERVATION_ENERGY))
            return OBSERVATION_TURNS;
        else if(structureType.equals(UNIVERSITY) && entityManager.spendResources(UNIVERSITY_FOOD, UNIVERSITY_ORE, UNIVERSITY_ENERGY))
            return UNIVERSITY_TURNS;
        return -1;
    }
}
