package Commands;
/*--------------------------------------------------------------------------------------
|	ReinforceArmy Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of Units reinforcing an Army.
---------------------------------------------------------------------------------------*/

import Entity.Army.Army;
import Entity.Unit.Unit;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import GameMap.Tile;

import java.util.List;

public class ReinforceArmy extends Command {

    private Army destination;
    private boolean firstExecute;

    public ReinforceArmy(Unit unit, Army destination){
        super(GameLibrary.REINFORCE, unit);
        this.destination = destination;
        firstExecute = true;
    }

    @Override
    public void execute() {
        destination.addReinforcement((Unit)affected);
        if(firstExecute) {
            destination.addReinforcement((Unit)affected);
            firstExecute = false;
        } else {
            isFinished = affected.getLocation().equals(destination.getRallyPoint().getLocation());
        }
    }
}
