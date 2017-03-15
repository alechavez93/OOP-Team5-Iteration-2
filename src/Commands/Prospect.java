package Commands;

import Entity.*;
import Entity.Unit.ExplorerUnit;
import GameLibrary.GameLibrary;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    Prospect Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Prospect extends Command {

    public Prospect(Entity affected){

        super(GameLibrary.PROSPECT_MODE, affected);
    }

    @Override
    public void execute() {
        ((ExplorerUnit) affected).toggleProspectMode();
        isFinished = true;


    }
}
