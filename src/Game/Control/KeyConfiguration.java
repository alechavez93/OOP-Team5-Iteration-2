package Game.Control;
/*--------------------------------------------------------------------------------------
|	KeyConfiguration Class: Created by Alejandro Chavez on 3/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Contains a configuration of the controller.
---------------------------------------------------------------------------------------*/

import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyConfiguration {

    //Numeric KeyPad
    private int northKey, northEastKey, southEastKey, southKey, southWestKey, northWestKey;
    public static final String NORTH_KEY = "NORTH", NORTH_EAST_KEY = "NORTH EAST", SOUTH_EAST_KEY = "SOUTH EAST", SOUTH_KEY = "SOUTH", SOUTH_WEST_KEY = "SOUTH WEST", NORTH_WEST_KEY = "NORTH WEST";

    //Cycling Keys
    private int cycleUp, cycleDown, cycleRight, cycleLeft;
    public static final String CYCLE_UP = "CYCLE UP", CYCLE_DOWN = "CYCLE DOWN", CYCLE_RIGHT = "CYCLE RIGHT", CYCLE_LEFT = "CYCLE LEFT";

    //Id shortcuts
    private int zero, one, two, three, four, five, six, seven, eight, nine;
    public static final String ZERO = "ZERO", ONE = "ONE", TWO = "TWO", THREE = "THREE", FOUR = "FOUR", FIVE = "FIVE", SIX = "SIX", SEVEN = "SEVEN", EIGHT = "EIGHT", NINE = "NINE";

    //Special Keys
    private int mode, activate, endTurn, center;
    public static final String MODE = "MODE", ACTIVATE = "ACTIVATE COMMAND", END_TURN = "END TURN", CENTER = "CENTER";

    private Map<String, Integer> control;

    //Default constructor for default configuration
    public KeyConfiguration(){
        //Config keypad
        northKey = KeyEvent.VK_NUMPAD8;
        northWestKey = KeyEvent.VK_NUMPAD7;
        southWestKey = KeyEvent.VK_NUMPAD1;
        southKey = KeyEvent.VK_NUMPAD2;
        southEastKey = KeyEvent.VK_NUMPAD3;
        northEastKey = KeyEvent.VK_NUMPAD9;
        center = KeyEvent.VK_NUMPAD5;

        //Config cycling
        cycleUp = KeyEvent.VK_UP;
        cycleDown = KeyEvent.VK_DOWN;
        cycleLeft = KeyEvent.VK_LEFT;
        cycleRight = KeyEvent.VK_RIGHT;

        //Config shortcuts
        zero = KeyEvent.VK_0;
        one = KeyEvent.VK_1;
        two = KeyEvent.VK_2;
        three = KeyEvent.VK_3;
        four = KeyEvent.VK_4;
        five = KeyEvent.VK_5;
        six = KeyEvent.VK_6;
        seven = KeyEvent.VK_7;
        eight = KeyEvent.VK_8;
        nine = KeyEvent.VK_9;

        //Special Keys
        mode = KeyEvent.VK_CONTROL;
        activate = KeyEvent.VK_ENTER;
        endTurn = KeyEvent.VK_SPACE;
    }

    public KeyConfiguration(Map<String, Integer> control) {
        this.control = control;
        //Config keypad
        northKey = control.get(NORTH_KEY);
        northWestKey = control.get(NORTH_WEST_KEY);
        southWestKey = control.get(SOUTH_WEST_KEY);
        southKey = control.get(SOUTH_KEY);
        southEastKey = control.get(SOUTH_EAST_KEY);
        northEastKey = control.get(NORTH_EAST_KEY);
        center = control.get(CENTER);

        //Config cycling
        cycleUp = control.get(CYCLE_UP);
        cycleDown = control.get(CYCLE_DOWN);
        cycleLeft = control.get(CYCLE_LEFT);
        cycleRight = control.get(CYCLE_RIGHT);

        //Config shortcuts
        zero = control.get(ZERO);
        one = control.get(ONE);
        two = control.get(TWO);
        three = control.get(THREE);
        four = control.get(FOUR);
        five = control.get(FIVE);
        six = control.get(SIX);
        seven = control.get(SEVEN);
        eight = control.get(EIGHT);
        nine = control.get(NINE);

        //Special Keys
        mode = control.get(MODE);
        activate = control.get(ACTIVATE);
        endTurn = control.get(END_TURN);
    }

    public int getNorthKey() { return northKey; }
    public int getNorthEastKey() { return northEastKey; }
    public int getSouthEastKey() { return southEastKey; }
    public int getSouthKey() { return southKey; }
    public int getSouthWestKey() { return southWestKey; }
    public int getNorthWestKey() { return northWestKey; }
    public int getCycleUp() { return cycleUp; }
    public int getCycleDown() { return cycleDown; }
    public int getCycleRight() { return cycleRight; }
    public int getCycleLeft() { return cycleLeft; }
    public int getZero() { return zero; }
    public int getOne() { return one;}
    public int getTwo() { return two; }
    public int getThree() { return three; }
    public int getFour() { return four; }
    public int getFive() { return five; }
    public int getSix() { return six; }
    public int getSeven() { return seven; }
    public int getEight() { return eight; }
    public int getNine() { return nine; }
    public int getMode() { return mode; }
    public int getActivate() { return activate; }
    public int getEndTurn() { return endTurn; }
    public int getCenter() { return center; }

    public Map<String, Integer> getControl() { return control; }
}
