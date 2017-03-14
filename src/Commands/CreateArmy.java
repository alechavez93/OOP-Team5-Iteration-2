package Commands;

import Entity.*;
import Entity.Army.Army;
import Entity.Unit.Unit;
import GameLibrary.GameLibrary;
import Player.EntityManager;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    CreateArmy Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class CreateArmy extends Command{

    //TODO: make this into something instant

    public CreateArmy(Entity affected) {
        super(GameLibrary.CREATE_ARMY, affected);
        }
    @Override
    public void execute() {
        EntityManager entityManager = affected.getEntityManager();

        Army army = new Army(entityManager.nextArmyIndex(),affected.getLocation(), entityManager, (Unit) affected);
        entityManager.addArmy(army);
        ((Unit) affected).setInArmy(true);
        isFinished = true;
    }

}
