package Commands;


import Entity.Army.Army;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class MoveRallypoint extends Command {

    private MapCoordinate newPos;
    private boolean firstExecute;

    public MoveRallypoint(Army affected, MapCoordinate coord) {
        super(GameLibrary.MOVE, affected);
        newPos = coord;
        firstExecute = true;
    }

    public void execute() {
        if(firstExecute) {
            ((Army) affected).moveRallypoint(newPos);
            firstExecute = false;
        } else {
            isFinished = ((Army) affected).getLocation().equals(newPos);
        }
    }
}
