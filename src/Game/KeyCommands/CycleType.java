package Game.KeyCommands;

import Game.CyclingState;

/**
 * Created by Customer-PC on 3/12/2017.
 */
public class CycleType implements KeyCommand{
    private CyclingState cycle;
    private boolean backward;

    public CycleType(CyclingState cycle, boolean backward) {
        this.cycle = cycle;
        this.backward = backward;
    }

    public void execute() {
        cycle.cycleType(backward);
    }
}
