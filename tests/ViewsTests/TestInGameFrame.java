package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestInGameFrame Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests functionality of InGameFrame, which contains all in game views.
---------------------------------------------------------------------------------------*/

import Game.Control.InGameController;
import Game.CyclingState;
import GameMap.*;
import Player.EntityManager;
import Player.Player;
import Utility.GraphicsFactory;
import Utility.MapLoader;
import Views.*;

public class TestInGameFrame {

    public static void main(String[] args) {
        char[][] cMap = MapLoader.getCharMap("sample");
        GameMap map = GameMap.getInstance();
        map.initialize(cMap);
        GraphicsFactory.getInstance();
        Player p = new Player(0, new MapCoordinate(3,3));
        EntityManager em = new EntityManager(p);
        p.getFogOfWar().calculateVisibility(p.getEntityManager().getAllEntities());

        InGameFrame frame = new InGameFrame();
        CyclingState state = new CyclingState();
        frame.addView(new MapView("Map Overview", state));
        frame.addView(new UnitView("Unit Overview", state));
        frame.addView(new StructureView("Structure Overview", state));
        frame.addView(new TechTreeView("Tech Tree", state));

        frame.addKeyListener(new InGameController(frame, state));
    }
}
