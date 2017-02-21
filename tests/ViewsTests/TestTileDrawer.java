package ViewsTests;/*--------------------------------------------------------------------------------------
|	ViewsTests.TestTileDrawer Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

import Utility.Coordinate;
import Views.PixelMap;
import Views.Tile;
import Views.TileDrawer;

import javax.swing.*;
import java.awt.*;

public class TestTileDrawer {
    private static class TestPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            TileDrawer.drawTile(g, new Tile(new Coordinate(3,3)));
//            TileDrawer.drawTile(g, new Tile(new Coordinate(3,4)));
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        JPanel panel = new TestPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}