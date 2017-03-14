package Commands;

/*--------------------------------------------------------------------------------------
|    MakeUnit Class: Created by Tonny Xie on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Structure.CapitalStructure;
import Entity.Structure.FortStructure;
import GameLibrary.GameLibrary;
import Player.EntityManager;

public class MakeUnit extends Command {

    private String type;
    private int workAmount;
    

    public MakeUnit(CapitalStructure capital, String type) {
        super(GameLibrary.MAKE_UNIT, capital);
        this.type = type;
    }

    public MakeUnit(FortStructure fort, String type) {
        super(GameLibrary.MAKE_UNIT, fort);
        this.type = type;
    }

    @Override
    public void execute() {
        EntityManager entityManager = affected.getEntityManager();

        if ((affected instanceof CapitalStructure) && (type.equals(GameLibrary.EXPLORER))){
            if (entityManager.spendResources(GameLibrary.EXPLORER_FOOD, GameLibrary.EXPLORER_ORE, GameLibrary.EXPLORER_ENERGY))
                entityManager.addExplorer(((CapitalStructure) affected).createExplorerUnit());
        }
        else if (affected instanceof FortStructure) {
            if (type.equals(GameLibrary.MELEE)) {
                if (entityManager.spendResources(GameLibrary.MELEE_FOOD, GameLibrary.MELEE_ORE, GameLibrary.MELEE_ENERGY))
                    entityManager.addMelee(((FortStructure) affected).createMeleeSoldier());
            }
            else if (type.equals(GameLibrary.RANGED)) {
                if (entityManager.spendResources(GameLibrary.RANGED_FOOD, GameLibrary.RANGED_ORE, GameLibrary.RANGED_ENERGY))
                    entityManager.addRange(((FortStructure) affected).createRangeSoldier());
            }
        }

        isFinished = true;
    }
}
