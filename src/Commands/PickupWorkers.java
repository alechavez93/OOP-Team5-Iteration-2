package Commands;

import Entity.Army.Army;
import Entity.Army.RallyPoint;
import Entity.Structure.Structure;
import GameLibrary.GameLibrary;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    PickupWorkers Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Used to pick up workers from a structure
---------------------------------------------------------------------------------------*/

public class PickupWorkers extends Command{
    private RallyPoint rallyPoint;
    private  Structure structure;
    private int workerCount;

    public PickupWorkers(RallyPoint rallyPoint, Structure structure, int workerCount){
        super(GameLibrary.PICKUP, rallyPoint);
        this.rallyPoint = rallyPoint;
        this.structure = structure;
        this.workerCount = workerCount;
        execute();
    }

    @Override
    public void execute() {
        if(rallyPoint.getLocation().equals(structure.getLocation())){
            rallyPoint.pickupWorker(structure, workerCount);
            isFinished = true;
        }
        else{
            System.out.println("rally location: " + rallyPoint.getLocation().getColumn() + ", " + rallyPoint.getLocation().getRow());
            System.out.println("structure location: " + structure.getLocation().getColumn() + ", "  + structure.getLocation().getRow());
            System.out.println("Something went wrong in Pickupworker");
        }

    }
}
