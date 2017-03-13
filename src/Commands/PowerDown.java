package Commands;
/*--------------------------------------------------------------------------------------
|	PowerDown Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the ability for an Entity to Power Down.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameLibrary.GameLibrary;

public class PowerDown extends Command {

    public PowerDown(Entity affected){
        super(GameLibrary.POWER_DOWN, affected);
    }

    @Override
    public void execute() {
        affected.powerDown();
        isFinished = true;
    }
}
