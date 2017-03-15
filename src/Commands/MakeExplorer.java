package Commands;

import Entity.Structure.CapitalStructure;
import Entity.Structure.Structure;
import Entity.Unit.ExplorerUnit;
import GameLibrary.GameLibrary;
import Player.EntityManager;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    MakeExplorer Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MakeExplorer extends Command {
    private CapitalStructure capitalStructure;
    private int workAmount;

    public MakeExplorer(CapitalStructure capitalStructure){
        super(GameLibrary.MAKE_EXPLORER, capitalStructure);
        this.capitalStructure = capitalStructure;
        workAmount = calculate(capitalStructure);
    }

    @Override
    public void execute() {
        EntityManager entityManager = capitalStructure.getEntityManager();
        workAmount -= capitalStructure.getWorkers().getNumberOfWorkers() * capitalStructure.getProduction().getExplorerRate();

        if(workAmount > 0) return;

        ExplorerUnit explorerUnit = capitalStructure.createExplorerUnit();
        entityManager.addExplorer(explorerUnit);

        isFinished = true;

    }

    public int calculate(CapitalStructure capitalStructure){
        EntityManager entityManager = capitalStructure.getEntityManager();

        if(entityManager.spendResources(GameLibrary.EXPLORER_FOOD, GameLibrary.EXPLORER_ORE, GameLibrary.EXPLORER_ENERGY)){
            return GameLibrary.EXPLORER_TURNS;
        }

        return -1;
    }
}
