package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestUnitDrawer Class: Created by Alejandro Chavez on 3/6/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Structure.*;
import Entity.Unit.Soldier.RangeSoldier;
import Entity.Unit.Unit;
import GameLibrary.GameLibrary;
import GameMap.GameMap;
import GameMap.MapCoordinate;
import GameMap.Tile;
import Player.EntityManager;
import Player.Player;
import Utility.Vec2i;
import Views.PixelMaps.PixelMap;
import Views.Drawers.StructureDrawer;
import Views.Drawers.TileDrawer;
import Views.Drawers.UnitDrawer;

import javax.swing.*;
import java.awt.*;

public class TestUnitDrawer {
    private static class TestPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            int startRow = 1, startCol = 1;
            EntityManager em = new EntityManager(new Player(0, new MapCoordinate(3,3)));
            Structure capital = new CapitalStructure(0, new MapCoordinate(startRow,startCol), em);
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(startCol,startRow)));
            StructureDrawer.drawStructure(g, capital);
            Unit ranged = new RangeSoldier(0, capital.getLocation(), em);
            UnitDrawer.drawUnit(g, ranged);
        }
    }

    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(10,10));
        JFrame frame = new JFrame("Game");
        JPanel panel = new TestPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
