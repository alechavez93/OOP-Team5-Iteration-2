package Commands;

import Entity.Unit.ExplorerUnit;
import GameLibrary.GameLibrary;
import Technology.EntityTechnology.ExplorerTechnology;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    ProspectMode Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ProspectMode extends Command {

    public ProspectMode(ExplorerUnit affected){
        super(GameLibrary.PROSPECT_MODE, affected);
    }

    @Override
    public void execute() {
        ((ExplorerUnit)affected).toggleProspectMode();
        isFinished = true;
    }
}
