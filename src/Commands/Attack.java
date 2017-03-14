package Commands;
/*--------------------------------------------------------------------------------------
|	Attack Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Does not finish until the queue has another Command waiting to be executed.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class Attack extends Command{

    private MapCoordinate attacked;

    public Attack(Entity affected, MapCoordinate attacked){
        super(GameLibrary.ATTACK, affected);
        this.attacked = attacked;
        isFinished = false;
    }

    @Override
    public void execute() {
        EntityManager entityManager = affected.getEntityManager();
        entityManager.attack(affected, attacked);
    }
}
