package Commands;

import Entity.Army.RallyPoint;
import Entity.Structure.Structure;
import GameLibrary.GameLibrary;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    Dropoff Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Dropoff extends Command{


    private RallyPoint rallyPoint;
    private Structure structure;
    private int workerCount;

    public Dropoff(RallyPoint rallyPoint, Structure structure, int workerCount){
        super(GameLibrary.PICKUP, rallyPoint);
        this.rallyPoint = rallyPoint;
        this.structure = structure;
        this.workerCount = workerCount;
        execute();
    }

    @Override
    public void execute() {
        if(rallyPoint.getLocation().equals(structure.getLocation())){
            rallyPoint.dropoffWorker(structure, workerCount);
            isFinished = true;
        }
        else{
            System.out.println("rally location: " + rallyPoint.getLocation().getColumn() + ", " + rallyPoint.getLocation().getRow());
            System.out.println("structure location: " + structure.getLocation().getColumn() + ", "  + structure.getLocation().getRow());
            System.out.println("Something went wrong in Pickupworker");
        }

    }
}
