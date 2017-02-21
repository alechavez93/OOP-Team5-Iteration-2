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
    static List<Tile> row1, row2, row3, row4, row5;
    private static class TestPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            RowDrawer.drawRow(g, row1);
            RowDrawer.drawRow(g, row2);
            RowDrawer.drawRow(g, row3);
            RowDrawer.drawRow(g, row4);
            RowDrawer.drawRow(g, row5);
        }
    }

    public static void main(String[] args) {
        //Set Tiles
        int cols = 100;
        row1 = new ArrayList<>();
        row2 = new ArrayList<>();
        row3 = new ArrayList<>();
        row4 = new ArrayList<>();
        row5 = new ArrayList<>();

        for (int i=1; i<=cols; i++){
            row1.add(new Tile(new Coordinate(1,i)));
        }

        for (int i=1; i<=cols; i++){
            row2.add(new Tile(new Coordinate(2,i)));
        }

        for (int i=1; i<=cols; i++){
            row3.add(new Tile(new Coordinate(3,i)));
        }

        for (int i=1; i<=cols; i++){
            row4.add(new Tile(new Coordinate(4,i)));
        }

        for (int i=1; i<=cols; i++){
            row5.add(new Tile(new Coordinate(5,i)));
        }


        JFrame frame = new JFrame("Game");
        JPanel panel = new TestPanel();
        frame.add(panel);
        frame.setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}