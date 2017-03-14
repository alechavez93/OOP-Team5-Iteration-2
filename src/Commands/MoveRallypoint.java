package Commands;


import Entity.Army.Army;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class MoveRallypoint extends Command {

    private MapCoordinate newPos;

    public MoveRallypoint(Army affected, MapCoordinate coord) {
        super(GameLibrary.MOVE, affected);
        newPos = coord;
    }

    public void execute() {

        ((Army)affected).moveRallypoint(newPos);
    }
}
