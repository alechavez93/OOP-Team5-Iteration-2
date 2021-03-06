package Commands;
/*--------------------------------------------------------------------------------------
|	CancelOrders Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Cancels all issued commands contained by an Entity.
---------------------------------------------------------------------------------------*/

import Entity.Army.RallyPoint;
import Entity.Entity;
import GameLibrary.GameLibrary;

public class CancelOrders extends Command{

    public CancelOrders(Entity affected){

        super(GameLibrary.CANCEL, affected);
        this.execute();
    }

    @Override
    public void execute() {
        affected.cancelOrders();
        isFinished = true;
    }
}
