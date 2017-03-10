package Views;
/*--------------------------------------------------------------------------------------
|	CyclingSection Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the view part of the cycling and selection of commands. It
|   also displays some indicators such as Player in turn, Resources, etc.
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import Utility.GraphicsFactory;
import Views.Drawers.OptionDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CyclingSection extends JPanel{

    GraphicsFactory graphicsFactory;

    public CyclingSection(){
        setLayout(null);
        setBounds(0, ViewPort.VIEWPORT_HEIGHT, PixelMap.SCREEN_WIDTH/2, PixelMap.SCREEN_HEIGHT);
        graphicsFactory = GraphicsFactory.getInstance();
        setVisible(true);
//        setBackground(new Color(255,255,255));
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.ATTACK_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(0+50, 50), icon, 50+"");
        OptionDrawer.drawOption(g, new PixelPoint(0+50, 125), icon, "Attack:", 50+"", new Color(0,0,255));
        OptionDrawer.drawOption(g, new PixelPoint(0+50, 200), icon, "Lol:", 30+"", new Color(13,89,45));
    }
}
