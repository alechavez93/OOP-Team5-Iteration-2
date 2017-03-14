package Commands;
/*--------------------------------------------------------------------------------------
|	Defend Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Does not finish until the queue has another Command waiting to be executed.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameLibrary.GameLibrary;
import Player.EntityManager;
import Utility.Direction;

public class Defend extends Command{

    private Direction direction;

    public Defend(Entity affected, Direction direction){
        super(GameLibrary.DEFEND, affected);
        this.direction = direction;
        isFinished = false;
    }

    @Override
    public void execute() {
        EntityManager entityManager = affected.getEntityManager();
        entityManager.defend(affected, direction);
    }
}
