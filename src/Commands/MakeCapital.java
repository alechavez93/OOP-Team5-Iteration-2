package Commands;

/*--------------------------------------------------------------------------------------
|    MakeCapital Class: Created by Tonny Xie on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Unit.ColonistUnit;
import GameLibrary.GameLibrary;
import Player.EntityManager;

public class MakeCapital extends Command {

    public MakeCapital(ColonistUnit colonist) {
        super(GameLibrary.BUILD_CAPITAL, colonist);
    }

    @Override
    public void execute() {
        EntityManager entityManager = affected.getEntityManager();

        //System.out.println("Consuming: ");
        //entityManager.playerOwner.printResources();
//        System.out.println("FOOD: " + GameLibrary.CAPITAL_FOOD + GameLibrary.MELEE_FOOD * 2);
        //System.out.println1111
        if (entityManager.spendResources(GameLibrary.CAPITAL_FOOD, GameLibrary.CAPITAL_ORE, GameLibrary.CAPITAL_ENERGY)) {
            entityManager.addCapital(((ColonistUnit) affected).createCapitalStructure());
            //entityManager.playerOwner.printResources();
        }
        if (entityManager.spendResources(GameLibrary.MELEE_FOOD, GameLibrary.MELEE_ORE, GameLibrary.MELEE_ENERGY)){
            //entityManager.playerOwner.printResources();
            entityManager.addMelee(((ColonistUnit)affected).createMeleeSoldier());
        }
        if (entityManager.spendResources(GameLibrary.MELEE_FOOD, GameLibrary.MELEE_ORE, GameLibrary.MELEE_ENERGY)){
            //entityManager.playerOwner.printResources();
            entityManager.addMelee(((ColonistUnit)affected).createMeleeSoldier());
        }
        //entityManager.playerOwner.printResources();


        affected.destroy();
        isFinished = true;
    }
}
