package ViewsTests;/*--------------------------------------------------------------------------------------
|	ViewsTests.TestTileDrawer Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

import GameMap.Tile;
import Utility.Vec2i;
import GameMap.GameMap;
import GameMap.Tile;
import Utility.Coordinate;
import Utility.Vec2i;
import Views.PixelMap;
import Views.TileDrawer;

import javax.swing.*;
import java.awt.*;

public class TestTileDrawer {
    private static class TestPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            TileDrawer.drawTile(g, Tile.makeGrassTile(new Vec2i(3,3)));
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