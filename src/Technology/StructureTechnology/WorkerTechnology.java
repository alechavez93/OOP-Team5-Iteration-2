package Technology.StructureTechnology;

import Entity.Worker;
import Technology.Technology;

import static GameLibrary.GameLibrary.*;

/**
 * Created by test on 03/12/2017.
 */

/*--------------------------------------------------------------------------------------
|    WorkerTechnology Module: Created by test on 03/12/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class WorkerTechnology extends StructureTechnology{

    public WorkerTechnology(String techType){
        super(techType);
    }

    public void visit(Worker worker){
        if(techType == DENSITY) { worker.upgradeDensity(); }
        if(techType == RADIUS) { worker.upgradeRadius(); }
    }
}
