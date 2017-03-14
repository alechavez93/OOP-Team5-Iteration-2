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
    private List<Tile> path;
    private int cumulative;

    public ReinforceArmy(Unit unit, Army destination, List<Tile> path){
        super(GameLibrary.REINFORCE, unit);
        this.destination = destination;
        this.path = path;
        cumulative = 0;
        destination.addReinforcement((Unit) affected);
    }

    @Override
    public void execute() {
        if(path.get(0).getMovementCost() <= affected.getMovement()){
            affected.setLocation(new MapCoordinate(path.get(0).getPos()));
            path.remove(0);
            cumulative = 0;
        }else{
            cumulative += affected.getMovement();
            if(path.get(0).getMovementCost() <= cumulative){
                affected.setLocation(new MapCoordinate(path.get(0).getPos()));
                path.remove(0);
                cumulative = 0;
            }
        }
        if(path.size() == 0) isFinished = true;
    }
}
