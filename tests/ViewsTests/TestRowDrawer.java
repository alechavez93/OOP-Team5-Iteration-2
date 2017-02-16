package ViewsTests;
/*--------------------------------------------------------------------------------------
|	TestRowDrawer Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Views.*;
import Utilities.Coordinate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class TestRowDrawer {
    static List<Tile> row1, row2, row3;
    private static class TestPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            RowDrawer.drawRow(g, row1);
            RowDrawer.drawRow(g, row2);
            RowDrawer.drawRow(g, row3);
        }
    }

    public static void main(String[] args) {
        //Set Tiles
        int cols = 12;
        row1 = new ArrayList<>();
        row2 = new ArrayList<>();
        row3 = new ArrayList<>();

        for (int i=1; i<=cols; i++){
            row1.add(new Tile(new Coordinate(1,i)));
        }

        for (int i=1; i<=cols; i++){
            row2.add(new Tile(new Coordinate(2,i)));
        }

        for (int i=1; i<=cols; i++){
            row3.add(new Tile(new Coordinate(3,i)));
        }


        JFrame frame = new JFrame("Game");
        JPanel panel = new TestPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        //Load it once
        //Clip it use
        //GET MONEY
//        BufferedImage image2 = ImageUtil.loadImage("gem.jpg");
//        Graphics g = image2.getGraphics();
//        Polygon p = TileDrawer.getHexagon(new PixelPoint(image2.getWidth()/2,image2.getHeight()/2));
//        g.setClip(p);
    }
}
