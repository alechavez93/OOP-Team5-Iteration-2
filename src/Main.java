/*--------------------------------------------------------------------------------------
|	Main Class: Created by Alejandro Chavez on 2/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Sample Main
---------------------------------------------------------------------------------------*/

import Game.Control.InGameController;
import Game.CyclingState;
import Game.Game;
import GameLibrary.GameLibrary;
import GameMap.*;
import Utility.GraphicsFactory;
import Utility.MapLoader;
import Views.*;

public class Main {
    public static void main(String[] args) {
        char[][] cMap = MapLoader.getCharMap("sample");
        GameMap map = GameMap.getInstance();
        map.initialize(cMap);
        GraphicsFactory.getInstance();
        Game game = Game.getInstance();
        CyclingState state = new CyclingState();

        state.inTurn = game.getActivePlayer();
        state.gameMode = GameLibrary.UNIT_MODE;
        state.modeType = GameLibrary.COLONIST;
        state.selectedEntity = state.inTurn.getEntityManager().getColonistList().get(0);
        state.selectedCommand = GameLibrary.REINFORCE;

        game.setState(state);

        InGameFrame frame = new InGameFrame();
        frame.addView(new MapView("Map Overview", state));
        frame.addView(new UnitView("Unit Overview", state));
        frame.addView(new StructureView("Structure Overview", state));
        frame.addView(new TechTreeView("Tech Tree", state));

        InGameController controller = new InGameController(frame, state);
        frame.addKeyListener(controller);
        frame.setVisible(false);

        StartingFrame start = new StartingFrame();
        start.addKeyListener(controller);
        start.setVisible(true);
        controller.setStartingFrame(start);

    }
}
