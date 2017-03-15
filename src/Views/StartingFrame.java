package Views;
/*--------------------------------------------------------------------------------------
|	StartingFrame Class: Created by Alejandro Chavez on 3/12/2017.
|---------------------------------------------------------------------------------------
|   Description: Starting Frame that initializes the Game. They
|
---------------------------------------------------------------------------------------*/

import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartingFrame extends JFrame{

    Background background;

    class Background extends JPanel{
        public Background(){
            setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            BufferedImage img = GraphicsFactory.getInstance().getGraphics(GraphicsFactory.BACKGROUND_SRC);
            g.drawImage(img, 0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT, null);

        }
    }

    public StartingFrame(){
        setTitle("Game");
        setSize(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        background = new Background();
        add(background);

        setVisible(true);
    }

}
