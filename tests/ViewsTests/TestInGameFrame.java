package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestInGameFrame Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests functionality of InGameFrame, which contains all in game views.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import GameMap.*;
import Player.EntityManager;
import Player.Player;
import Utility.GraphicsFactory;
import Utility.MapLoader;
import Utility.Vec2i;
import Views.InGameFrame;
import Views.MapView;
import Views.StructureView;
import Views.UnitView;

public class TestInGameFrame {

    public static void main(String[] args) {
        char[][] cMap = MapLoader.getCharMap("sample");
        GameMap map = GameMap.getInstance();
        map.initialize(cMap, new Vec2i(cMap.length, cMap[0].length));
        GraphicsFactory.getInstance();
        EntityManager em = new EntityManager(new Player(0, new MapCoordinate(3,3) ));

        InGameFrame frame = new InGameFrame();
        CyclingState state = new CyclingState();
        frame.addView(new MapView("Map Overview", state));
        frame.addView(new UnitView("Unit Overview", state));
        frame.addView(new StructureView("Structure Overview", state));
    }
}
