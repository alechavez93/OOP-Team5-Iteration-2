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

    public static void main(String[] args) {
        char[][] cMap = MapLoader.getCharMap("sample");
        GameMap map = GameMap.getInstance();
        map.initialize(cMap, new Vec2i(cMap.length, cMap[0].length));
        ViewPort.initialize(new PixelPoint(0,0));
        JFrame frame = new JFrame("Game");
        frame.setLayout(null);
        frame.setBounds(0,0,PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        ViewPort viewPort = ViewPort.getInstance();
//        viewPort.setLayout(new BoxLayout());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(viewPort.getOrigin().x, viewPort.getOrigin().y, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.add(viewPort);
        frame.add(panel);
        frame.setVisible(true);
    }
}
