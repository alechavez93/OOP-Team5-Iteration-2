package Views;
/*--------------------------------------------------------------------------------------
|	MiniMapSection Class: Created by Alejandro Chavez on 3/10/2017.
|---------------------------------------------------------------------------------------
|   Description: Contains the minimap and location of the viewport in context.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;

import javax.swing.*;
import java.awt.*;

public class MiniMapSection extends JPanel{
    GraphicsFactory graphicsFactory;
    CyclingState cyclingState;

    public MiniMapSection(){
        setLayout(null);
        setBounds(PixelMap.SCREEN_WIDTH/2+PixelMap.SCREEN_WIDTH/4, ViewPort.VIEWPORT_HEIGHT, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT-ViewPort.VIEWPORT_HEIGHT);
        graphicsFactory = GraphicsFactory.getInstance();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawRect(5, 5, getWidth()-10, getHeight()-10);
    }
}
