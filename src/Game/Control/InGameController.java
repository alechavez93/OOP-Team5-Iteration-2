package Game.Control;
/*--------------------------------------------------------------------------------------
|	InGameController Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Manages the game from the In-game side. Excludes starting window.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import Game.Game;
import GameLibrary.GameLibrary;
import Player.EntityManager;
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
//        game = Game.getInstance();
        keysPressed = new HashSet<>();
        keyConfiguration = new KeyConfiguration();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keysPressed.add(code);
        changeScreen(code);
        cycleModeType(code);
        cycleEntities(code);
        cycleCommands(code);
        specialKeys(code);
        frame.getMapView().refreshCyclinigSection();
        frame.getMapView().refreshEntityStateSection();
    }


    public void specialKeys(int code){
        if(code == keyConfiguration.getActivate())
            activateCommand();
        else if(code == keyConfiguration.getEndTurn())
            endTurn();
        else if(code == keyConfiguration.getCenter())
            centerSelectedEntity();
    }

    public void activateCommand(){
        //Implementation here
    }

    public void endTurn(){
        game.changeTurn();
        state.inTurn = game.getActivePlayer();
    }

    public void centerSelectedEntity(){
        //Implementation here
        frame.getMapView().refreshViewportSection();
        frame.getMapView().refreshMinimapSection();
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
//            case KeyEvent.VK_R:
//                System.out.println(code);
//                frame.setViewVisible(3);
//                break;
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
        if(keysPressed.contains(keyConfiguration.getMode())) return;
        if(code == keyConfiguration.getCycleUp() || code == keyConfiguration.getCycleDown()) return;
        cycleUnits(code);
        cycleStructures(code);
        cycleArmy(code);
    }


    public void cycleUnits(int code){
        EntityManager entityManager = state.inTurn.getEntityManager();
        Entity nextEntity = null;
        if(state.modeType.equals(MELEE)){
            nextEntity = cycleItem(code, entityManager.getMeleeUnitList(), state.selectedEntity);
        }
        else if(state.modeType.equals(RANGED)){
            nextEntity = cycleItem(code, entityManager.getRangeUnitList(), state.selectedEntity);
        }
        else if(state.modeType.equals(COLONIST)){
            nextEntity = cycleItem(code, entityManager.getColonistList(), state.selectedEntity);
        }
        else if(state.modeType.equals(EXPLORER)){
            nextEntity = cycleItem(code, entityManager.getExplorerUnitList(), state.selectedEntity);
        }
        if(nextEntity != null) state.selectedEntity =  nextEntity;
    }


    public void cycleStructures(int code){
        EntityManager entityManager = state.inTurn.getEntityManager();
        Entity nextEntity = null;
        if(state.modeType.equals(CAPITAL)){
            nextEntity = cycleItem(code, entityManager.getCapitalList(), state.selectedEntity);
        }
        else if(state.modeType.equals(FARM)){
            nextEntity = cycleItem(code, entityManager.getFarmList(), state.selectedEntity);
        }
        else if(state.modeType.equals(MINE)){
            nextEntity = cycleItem(code, entityManager.getMineList(), state.selectedEntity);
        }
        else if(state.modeType.equals(POWER_PLANT)){
            nextEntity = cycleItem(code, entityManager.getPowerList(), state.selectedEntity);
        }
        else if(state.modeType.equals(FORT)){
            nextEntity = cycleItem(code, entityManager.getFortList(), state.selectedEntity);
        }
        else if(state.modeType.equals(OBSERVATION_TOWER)){
            nextEntity = cycleItem(code, entityManager.getObservationList(), state.selectedEntity);
        }
        else if(state.modeType.equals(UNIVERSITY)){
            nextEntity = cycleItem(code, entityManager.getUniversityList(), state.selectedEntity);
        }
        if(nextEntity != null) state.selectedEntity =  nextEntity;
    }

    public void cycleArmy(int code){
        EntityManager entityManager = state.inTurn.getEntityManager();
        Entity nextEntity = null;
        if(state.modeType.equals(ENTIRE_ARMY)){
            nextEntity = cycleItem(code, state.selectedArmy.getEntireArmy(), state.selectedEntity);
        }
        else if(state.modeType.equals(BATTLE_GROUP)){
            nextEntity = cycleItem(code, state.selectedArmy.getBattleGroup(), state.selectedEntity);
        }
        else if(state.modeType.equals(REINFORCEMENTS)){
            nextEntity = cycleItem(code, state.selectedArmy.getReinforcement(), state.selectedEntity);
        }
        if(nextEntity != null) state.selectedEntity =  nextEntity;
    }


    public void cycleCommands(int code){
        if(keysPressed.contains(keyConfiguration.getMode())) return;
        if(code == keyConfiguration.getCycleRight() || code == keyConfiguration.getCycleLeft()) return;

        if(state.gameMode.equals(UNIT_MODE)){
            state.selectedCommand = cycleItem(code, UNIT_COMMANDS, state.selectedCommand);
        }
        else  if(state.gameMode.equals(STRUCTURE_MODE)){
            state.selectedCommand = cycleItem(code, STRUCTURE_COMMANDS, state.selectedCommand);
        }
        else  if(state.gameMode.equals(ARMY_MODE)){
            state.selectedCommand = cycleItem(code, ARMY_COMMANDS, state.selectedCommand);
        }
//        else  if(state.gameMode.equals(RALLY_POINT_MODE)){
//            state.selectedCommand = cycleItem(code, RALLY_POINT_COMMANDS, state.selectedCommand);
//        }
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
        if (list.size() == 0) return new NONE();
        if(code == keyConfiguration.getCycleUp() || code == keyConfiguration.getCycleRight())
            return nextItem(list, entity);
        if(code == keyConfiguration.getCycleDown() || code == keyConfiguration.getCycleLeft())
            return previousItem(list, entity);
        else return new NONE();
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
