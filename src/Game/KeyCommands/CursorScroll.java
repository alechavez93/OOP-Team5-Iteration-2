package Game.KeyCommands;

import Game.CyclingState;
import Utility.Direction;

/**
 * Created by Customer-PC on 3/12/2017.
 */
public class CursorScroll implements KeyCommand{

    private CyclingState cycle;
    private Direction dir;

    public CursorScroll(CyclingState cycle, Direction dir) {
        this.cycle = cycle;
        this.dir = dir;
    }

    public void execute() {
        cycle.moveCursor(dir);
    }
}
