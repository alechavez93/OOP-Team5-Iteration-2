package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestViewPort Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Test functionality of Viewport Class. Tests the Drawing, the bounds,
|   and the Pixel mappings.
---------------------------------------------------------------------------------------*/

import GameMap.GameMap;
import Utility.MapLoader;
import Utility.Vec2i;
import Views.*;
import Views.PixelMaps.*;
import javax.swing.*;
import java.awt.*;

public class TestViewPort {
    private static class TestPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            ViewPort.getInstance().paintLayerOne(g);
        }
    }


    public static void main(String[] args) {
        char[][] cMap = MapLoader.getCharMap("sample");
        GameMap map = GameMap.getInstance();
        map.initialize(cMap, new Vec2i(cMap.length, cMap[0].length));
        ViewPort.initialize(new PixelPoint(0,0));
        JFrame frame = new JFrame("Game");
        JPanel panel = new TestPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
