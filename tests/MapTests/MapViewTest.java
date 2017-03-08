package MapTests;

import GameMap.GameMap;
import GameMap.Tile;
import Utility.Vec2i;
import Views.PixelMap;
import Views.TileDrawer;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by CustomerPC on 3/7/2017.
 */

/*--------------------------------------------------------------------------------------

|    MapViewTest Class: Created by CustomerPC on 3/7/2017.

|---------------------------------------------------------------------------------------

|   Description:

|

---------------------------------------------------------------------------------------*/

public class MapViewTest {
    private static class MapPanel extends JPanel {
        public void paint(Graphics g) {
            Iterator<Tile> iter = GameMap.getInstance().getIterator();
            while(iter.hasNext()) {
                TileDrawer.drawTile(g, iter.next());
            }
        }
    }

    private static char[][] testMap = {
            {'g','g','g','g','g'},
            {'g','s','w','j','m'},
            {'w','w','w','w','w'},
            {'s','g','w','j','m'},
    };

    public static void main(String[] args) {
        GameMap.getInstance().initialize(testMap, new Vec2i(4,5));

        JFrame frame = new JFrame("Game");
        JPanel panel = new MapPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
