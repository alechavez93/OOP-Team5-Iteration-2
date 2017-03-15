package Commands;

import Entity.Structure.CapitalStructure;
import Entity.Structure.FortStructure;
import Entity.Structure.Structure;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
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

public class MakeSoldier extends Command {
    private FortStructure fortStructure;
    private int workAmount;
    private String type;

    public MakeSoldier(FortStructure fortStructure, String type){
        super(GameLibrary.MAKE_EXPLORER, fortStructure);
        this.fortStructure = fortStructure;
        this.type = type;
        workAmount = calculate(fortStructure, type);
    }

    @Override
    public void execute() {
        EntityManager entityManager = fortStructure.getEntityManager();
        workAmount -= fortStructure.getWorkers().getNumberOfWorkers() * fortStructure.getProduction().getSoldierRate();

        if(workAmount > 0) return;

        if(type.equals(GameLibrary.MELEE)) {
            MeleeSoldier meleeSoldier = fortStructure.createMeleeSoldier();
            entityManager.addMelee(meleeSoldier);
        }
        else if(type.equals(GameLibrary.RANGED)){
            RangeSoldier rangeSoldier = fortStructure.createRangeSoldier();
            entityManager.addRange(rangeSoldier);
        }

        isFinished = true;

    }

    public int calculate(FortStructure fortStructure, String type){
        EntityManager entityManager = fortStructure.getEntityManager();

        if(type.equals(GameLibrary.MELEE)){
            if(entityManager.spendResources(GameLibrary.MELEE_FOOD, GameLibrary.MELEE_ORE, GameLibrary.MELEE_ENERGY)){
                return GameLibrary.MELEE_TURNS;
            }
        }
        else if(type.equals(GameLibrary.RANGED)){
            if(entityManager.spendResources(GameLibrary.RANGED_FOOD, GameLibrary.RANGED_ORE, GameLibrary.RANGED_ENERGY)){
                return GameLibrary.RANGE_TURNS;
            }
        }
        return -1;
    }
}
