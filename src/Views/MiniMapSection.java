package Views;
/*--------------------------------------------------------------------------------------
|	MiniMapSection Class: Created by Alejandro Chavez on 3/10/2017.
|---------------------------------------------------------------------------------------
|   Description: Contains the minimap and location of the viewport in context.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import GameMap.GameMap;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MiniMapSection extends JPanel{
    GraphicsFactory graphicsFactory;
    CyclingState cyclingState;
    public static BufferedImage map = null;

    public MiniMapSection(){
        setLayout(null);
        setBounds(PixelMap.SCREEN_WIDTH/2+PixelMap.SCREEN_WIDTH/4, ViewPort.VIEWPORT_HEIGHT, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT-ViewPort.VIEWPORT_HEIGHT);
        graphicsFactory = GraphicsFactory.getInstance();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if(map == null) updateMiniMap();
        g.drawRect(5, 5, getWidth()-10, getHeight()-10);
        g.drawImage(map, 5, 5, getWidth()-10, getHeight()-10, null);
        g.setColor(new Color(0,255,255));
        int width = (6*PixelMap.TILE_WIDTH*GameMap.getInstance().getSize().x)/ViewPort.VIEWPORT_WIDTH, height = (PixelMap.TILE_HEIGHT*GameMap.getInstance().getSize().y)/ViewPort.VIEWPORT_HEIGHT;
        width = getWidth()/width; height = getHeight()/height; height -= (int)(height/3.5);
        System.out.println("width:"+width+"\nheight:"+height);
        PixelPoint origin = new PixelPoint(0,0);
        origin.x = (int)((double)getWidth() * (double)ViewPort.scroller.x/((double)(6*PixelMap.TILE_WIDTH*GameMap.getInstance().getSize().x)));
        origin.y = (int)((double)getHeight()* (double)ViewPort.scroller.y/((1.05)*(double)PixelMap.TILE_HEIGHT*GameMap.getInstance().getSize().y));
        g.drawRect(origin.x,origin.y,width,height);
    }

    public static void updateMiniMap(){
        map = new BufferedImage((int)(6*PixelMap.TILE_WIDTH*GameMap.getInstance().getSize().x), (int)((1.05)*PixelMap.TILE_HEIGHT*GameMap.getInstance().getSize().y), BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics test = map.getGraphics();
        ViewPort.paintViewPort(test);
    }
}
