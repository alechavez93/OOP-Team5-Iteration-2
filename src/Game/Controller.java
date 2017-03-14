package Game;
/*--------------------------------------------------------------------------------------
|	Controller Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Game.KeyCommands.KeyCommand;
import Utility.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Controller implements KeyListener {

    private HashMap<KeyAssign, KeyCommand> keyConfig;
    private CyclingState cyclingState;
    private boolean ctrlHeld;
    private boolean shiftHeld;
    private boolean altHeld;

    public Controller(CyclingState cycle) {
        this.cyclingState = cycle;
        ctrlHeld = false;
        shiftHeld = false;
        altHeld = false;
    }

    private class KeyAssign {
        public boolean ctrlHeld;
        public boolean shiftHeld;
        public boolean altHeld;
        public KeyEvent keyEvent;

        KeyAssign(KeyEvent e, boolean ctrl, boolean shift, boolean alt) {
            keyEvent = e;
            ctrlHeld = ctrl;
            shiftHeld = shift;
            altHeld = alt;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_SHIFT:
                shiftHeld = true;
                break;
            case KeyEvent.VK_CONTROL:
                ctrlHeld = true;
                break;
            case KeyEvent.VK_ALT:
                altHeld = true;
                break;
            default:
                hardCodeMess(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_SHIFT:
                shiftHeld = false;
                break;
            case KeyEvent.VK_CONTROL:
                ctrlHeld = false;
                break;
            case KeyEvent.VK_ALT:
                altHeld = false;
                break;
        }
    }

    private void hardCodeMess(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_NUMPAD1:
                cyclingState.moveCursor(Direction.SouthWest);
                break;
            case KeyEvent.VK_NUMPAD2:
                cyclingState.moveCursor(Direction.South);
                break;
            case KeyEvent.VK_NUMPAD3:
                cyclingState.moveCursor(Direction.SouthEast);
                break;
            case KeyEvent.VK_NUMPAD7:
                cyclingState.moveCursor(Direction.NorthWest);
                break;
            case KeyEvent.VK_NUMPAD8:
                cyclingState.moveCursor(Direction.North);
                break;
            case KeyEvent.VK_NUMPAD9:
                cyclingState.moveCursor(Direction.NorthEast);
                break;
            case KeyEvent.VK_UP:
                if(ctrlHeld) {
                    cyclingState.cycleMode(false);
                } else {
                    cyclingState.cycleCommands(false);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(ctrlHeld) {
                    cyclingState.cycleMode(true);
                } else {
                    cyclingState.cycleCommands(true);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(ctrlHeld) {
                    cyclingState.cycleType(false);
                } else {
                    cyclingState.cycleInstances(false);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(ctrlHeld) {
                    cyclingState.cycleType(true);
                } else {
                    cyclingState.cycleInstances(true);
                }
                break;
        }
    }
}
