package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestStructureDrawer Class: Created by Alejandro Chavez on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests the functionality of Structure Drawer class.
---------------------------------------------------------------------------------------*/

import Entity.Structure.*;
import GameLibrary.GameLibrary;
import GameMap.*;
import GameMap.Tile;
import Player.EntityManager;
import Player.Player;
import Utility.Vec2i;
import Views.PixelMaps.PixelMap;
import Views.Drawers.StructureDrawer;
import Views.Drawers.TileDrawer;

import javax.swing.*;
import java.awt.*;

public class TestStructureDrawer {
    private static class TestPanel extends JPanel {
        @Override
        public void paint(Graphics g) {

            int startRow = 1, startCol = 1;
            Structure capital = new CapitalStructure(0, new MapCoordinate(startRow,startCol), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            Structure farm = new FarmStructure(1, new MapCoordinate(startRow,startCol+1), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            Structure fort = new FortStructure(2, new MapCoordinate(startRow,startCol+2), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            Structure plant = new PowerStructure(3, new MapCoordinate(startRow,startCol+3), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            Structure mine = new MineStructure(4, new MapCoordinate(startRow,startCol+4), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            Structure tower = new ObservationStructure(5, new MapCoordinate(startRow,startCol+5), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            Structure university = new UniversityStructure(6, new MapCoordinate(startRow,startCol+6), new EntityManager(new Player(0, new MapCoordinate(3,3))));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(startCol,startRow)));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.SAND, new Vec2i(startCol,startRow+1)));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(startCol,startRow+2)));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(startCol,startRow+3)));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(startCol,startRow+4)));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.SAND, new Vec2i(startCol,startRow+5)));
            TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(startCol,startRow+6)));
            StructureDrawer.drawStructure(g, capital);
            StructureDrawer.drawStructure(g, farm);
            StructureDrawer.drawStructure(g, fort);
            StructureDrawer.drawStructure(g, plant);
            StructureDrawer.drawStructure(g, mine);
            StructureDrawer.drawStructure(g, tower);
            StructureDrawer.drawStructure(g, university);
        }
    }

    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(10,10));
        JFrame frame = new JFrame("Game");
        JPanel panel = new TestStructureDrawer.TestPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
