package Views;
/*--------------------------------------------------------------------------------------
|	TechTreeView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Displays a visual representation of the Technology Tree.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TechTreeView extends View{

    BufferedImage background;

    private CyclingState state;
    public static final int MARGIN = PixelMap.MARGIN;
    private GraphicsFactory graphicsFactory;

    public TechTreeView(String name, CyclingState state){
        super(name);
        this.state = state;
        graphicsFactory = GraphicsFactory.getInstance();
        setSize(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        background = graphicsFactory.getGraphics("TECH");
        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT, null);
    }
}
