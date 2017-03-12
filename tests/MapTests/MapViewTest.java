package MapTests;

import Entity.*;
import Entity.Unit.*;
import GameMap.*;
import Player.*;
import Utility.Direction;
import Utility.MapLoader;
import Utility.Vec2i;
import Views.PixelMaps.PixelMap;
import Views.Drawers.TileDrawer;
import Views.Drawers.UnitDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

/**
 * Created by CustomerPC on 3/7/2017.
 */



/*--------------------------------------------------------------------------------------
|    MapViewTest Class: Created by CustomerPC on 3/7/2017.
|---------------------------------------------------------------------------------------
|   Description: The code in this test class is horrid. Do not look up to it.
---------------------------------------------------------------------------------------*/



public class MapViewTest {
    private static Vec2i scroller;
    private static JFrame frame;
    private static Unit unit;
    private static Path path;

    private static class MapPanel extends JPanel {
        public void paint(Graphics g) {
            g.translate(-scroller.x, -scroller.y);

            Iterator<Tile> iter = GameMap.getInstance().getIterator();
            while(iter.hasNext()) {
                TileDrawer.drawTile(g, iter.next());
            }
            UnitDrawer.drawUnit(g, unit);
        }
    }

    private static class TestController implements KeyListener {

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            //System.out.printf(e.getKeyCode() + "");
            switch(code) {
                case KeyEvent.VK_LEFT:
                    scroller.x += -25;
                    break;
                case KeyEvent.VK_RIGHT:
                    scroller.x += 25;
                    break;
                case KeyEvent.VK_UP:
                    scroller.y += -25;
                    break;
                case KeyEvent.VK_DOWN:
                    scroller.y += 25;
                    break;
                case KeyEvent.VK_ENTER:
                    pathTest(path, unit);
                    break;
            }
            frame.repaint();
        }

        public void keyReleased(KeyEvent e) {

        }
    }


    private static char[][] testMap = {
            {'g','g','g','g','g'},
            {'g','s','w','j','m'},
            {'w','w','w','w','w'},
            {'s','g','w','j','m'},
    };

    public static void main(String[] args) {
        scroller = new Vec2i();
        char[][] test = MapLoader.getCharMap("sample");
        GameMap.getInstance().initialize(test);
        path = (new AStarPathFinder()).createPath(new MapCoordinate(2,2), new MapCoordinate(12,12));

        EntityManager em = new EntityManager(new Player(0, new MapCoordinate(2,2)));
        unit = new RangeSoldier(0, path.getStart(), em);
        frame = new JFrame("Game");
        JPanel panel = new MapPanel();
        frame.add(panel);
        frame.addKeyListener(new TestController());
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private static void pathTest(Path path, Unit unit) {
        if(path.isEnd())
            return;
        //if(!path.isValid())
        //    path.recreate(unit.getLocation());
        Tile t = GameMap.getInstance().getTile(unit.getLocation());
            //GameMap.getInstance().shiftEntity(unit, path.next());
            Direction d = path.next();
            GameMap.getInstance().shiftEntity(unit, d);
            System.out.printf(d.name() + " " + unit.getLocation().getColumn() + " " + unit.getLocation().getRow() + "\n");
    }
}

