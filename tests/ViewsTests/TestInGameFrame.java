package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestInGameFrame Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests functionality of InGameFrame, which contains all in game views.
---------------------------------------------------------------------------------------*/

import GameMap.GameMap;
import Utility.Vec2i;
import Views.InGameFrame;
import Views.MapView;
import Views.UnitView;

public class TestInGameFrame {

    public static void main(String[] args) {
        GameMap map = GameMap.getInstance();
        map.initialize(new Vec2i(20,20));
        InGameFrame frame = new InGameFrame();
        frame.addView(new MapView("Map Overview"));
        frame.addView(new UnitView("Unit Overview"));
    }
}
