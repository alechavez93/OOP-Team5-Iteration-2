package Game.Control;
/*--------------------------------------------------------------------------------------
|	InGameController Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Manages the game from the In-game side. Excludes starting window.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import Game.Game;
import GameLibrary.GameLibrary;
import Views.InGameFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Entity.*;

public class InGameController extends GameLibrary implements KeyListener {

    private Game game;
    private InGameFrame frame;
    private CyclingState state;
    private Set<Integer> keysPressed;
    private KeyConfiguration keyConfiguration;


    public InGameController(InGameFrame frame, CyclingState state){
        this.frame = frame;
        this.state = state;
        game = Game.getInstance();
        keysPressed = new HashSet<>();
        keyConfiguration = new KeyConfiguration();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keysPressed.add(code);
        changeScreen(code);
        cycleModeType(code);
        System.out.println(code);
        frame.getMapView().refreshCyclinigSection();
        frame.getMapView().refreshEntityStateSection();
    }


    public void changeScreen(int code){
        switch(code) {
            case KeyEvent.VK_Q:
                System.out.println(code);
                frame.setViewVisible(0);
                break;
            case KeyEvent.VK_W:
                System.out.println(code);
                frame.setViewVisible(1);
                break;
            case KeyEvent.VK_E:
                System.out.println(code);
                frame.setViewVisible(2);
                break;
        }
    }

    public void cycleModeType(int code){
        if(!keysPressed.contains(keyConfiguration.getMode())) return;
        if(code == keyConfiguration.getCycleUp() || code == keyConfiguration.getCycleDown())
            cycleMode(code);
        else if(code == keyConfiguration.getCycleRight() || code == keyConfiguration.getCycleLeft())
            cycleType(code);
    }

    public void cycleMode(int code){
        state.gameMode = cycleItem(code, MODES, state.gameMode);
        resetType();
    }

    public void cycleType(int code){
        if(state.gameMode == STRUCTURE_MODE){
            state.modeType = cycleItem(code, STRUCTURES, state.modeType);
        }
        else if(state.gameMode == UNIT_MODE){
            state.modeType = cycleItem(code, UNITS, state.modeType);
        }
        else if(state.gameMode == ARMY_MODE){
            state.modeType = cycleItem(code, ARMIES, state.modeType);
        }
    }

    public void cycleEntities(int code){

    }




    //Helpers
    private String cycleItem(int code, String[] array, String item){
        if(code == keyConfiguration.getCycleUp() || code == keyConfiguration.getCycleRight())
            return nextItem(array, item);
        if(code == keyConfiguration.getCycleDown() || code == keyConfiguration.getCycleLeft())
            return previousItem(array, item);
        else return "";
    }

    private String nextItem(String[] array, String item){
        int i = Arrays.asList(array).indexOf(item) + 1;
        if(i >= array.length)
            return array[0];
        return array[i];
    }

    private String previousItem(String[] array, String item){
        int i = Arrays.asList(array).indexOf(item) - 1;
        if(i < 0)
            return array[array.length - 1];
        return array[i];
    }


    private Entity cycleItem(int code, List<Entity> list, Entity entity){
        if(code == keyConfiguration.getCycleUp() || code == keyConfiguration.getCycleRight())
            return nextItem(list, entity);
        if(code == keyConfiguration.getCycleDown() || code == keyConfiguration.getCycleLeft())
            return previousItem(list, entity);
        else return null;
    }

    private Entity nextItem(List<Entity> list, Entity entity){
        int i = list.indexOf(entity) + 1;
        if(i >= list.size())
            return list.get(0);
        return list.get(i);
    }

    //Check Out for this
    private Entity previousItem(List<Entity> list, Entity entity){
        int i = list.indexOf(entity) - 1;
        if(i < 0)
            return list.get(list.size() - 1);
        if (list.get(i) == null)
            return null;
        return list.get(i);
    }


    //Reseters
    private void resetType(){
        if(state.gameMode == STRUCTURE_MODE) state.modeType = STRUCTURES[0];
        else if(state.gameMode == UNIT_MODE) state.modeType = UNITS[0];
        else if(state.gameMode == ARMY_MODE) state.modeType = ARMIES[0];
    }


    @Override public void keyReleased(KeyEvent e) { keysPressed.remove(e.getKeyCode()); }
    @Override public void keyTyped(KeyEvent e) {}
}
