package Commands;
/*--------------------------------------------------------------------------------------
|	Decommission Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of all the Decommission commands for different entities.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import GameLibrary.GameLibrary;

public class Decommission extends Command {

    public Decommission(Entity affected){
        super(GameLibrary.DECOMMISSION, affected);
    }

    @Override
    public void execute() {
        affected.destroy();
        isFinished = true;
    }
}
