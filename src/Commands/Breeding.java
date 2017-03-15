package Commands;

import Entity.Entity;
import Entity.Structure.CapitalStructure;
import GameLibrary.GameLibrary;
import Player.EntityManager;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    Breeding Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Breeding extends Command {
    private int workAmount;
    private int workerCount;

    public Breeding(CapitalStructure capitalStructure, int workerCount){
        super(GameLibrary.BREEDING, capitalStructure);
        this.workerCount = workerCount;
        this.workAmount = calculate(capitalStructure.getEntityManager());
    }

    @Override
    public void execute() {
        EntityManager entityManager = affected.getEntityManager();
        workAmount -= ((CapitalStructure) affected).getProduction().getBreedingRate() * workerCount;

        if(workAmount > 0) return;

        ((CapitalStructure) affected).breedWorkers(workerCount);

        isFinished = true;
    }

    public int calculate( EntityManager entityManager){
        if(entityManager.spendResources(GameLibrary.WORKER_FOOD, GameLibrary.WORKER_ORE, GameLibrary.WORKER_ENRGY)){
            return GameLibrary.BREEDING_TURNS;
        }
        return -1;
    }

}
