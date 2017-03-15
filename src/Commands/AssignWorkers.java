package Commands;

import Entity.*;
/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    AssignWorkers Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class AssignWorkers extends Command {

    // A worker will perform both harvest and producing. Will decide on order later.

    public AssignWorkers(String name, Entity entity){

        super(name, entity);
    }

    @Override
    public void execute() {

    }
}
