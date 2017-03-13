package Technology;

import Entity.Worker;
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

public class WorkerTechnology extends  Technology{

    public WorkerTechnology(String researchType){
        super(researchType);
    }

    public void visit(Worker worker){
        if(researchType == DENSITY) { worker.upgradeDensity(); }
        if(researchType == RADIUS) { worker.upgradeRadius(); }
    }
}
