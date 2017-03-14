package Commands;
/*--------------------------------------------------------------------------------------
|	PowerUp Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the ability for an Entity to Power Up.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameLibrary.GameLibrary;

public class PowerUp extends Command {
    int turnCount = 2;

    public PowerUp(Entity affected){
        super(GameLibrary.POWER_UP, affected);
    }

    @Override
    public void execute() {
        turnCount--;
        affected.powerUp();
        if(turnCount == 0){
            isFinished = true;
        }
    }
}