package Views;
/*--------------------------------------------------------------------------------------
|	CyclingSection Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the view part of the cycling and selection of commands. It
|   also displays some indicators such as Player in turn, Resources, etc.
---------------------------------------------------------------------------------------*/


import Game.CyclingState;
import Utility.GraphicsFactory;
import Views.Drawers.OptionDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CyclingSection extends JPanel{

    GraphicsFactory graphicsFactory;
    CyclingState cyclingState;

    public CyclingSection(){
        setLayout(null);
        setBounds(0, ViewPort.VIEWPORT_HEIGHT, PixelMap.SCREEN_WIDTH/2, PixelMap.SCREEN_HEIGHT-ViewPort.VIEWPORT_HEIGHT);
        graphicsFactory = GraphicsFactory.getInstance();
        setVisible(true);
    }

    public void setCyclingState(CyclingState cyclingState){ this.cyclingState = cyclingState; }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawRect(5, 5, getWidth()-10, getHeight()-10);
        paintCyclingState(g);
        paintResources(g);
    }


    private void paintCyclingState(Graphics g){
        //Player
        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.PLAYER_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE), icon, "Player: ", cyclingState.inTurn.getName(), new Color(10,119,16));
        System.out.println(PixelMap.TILE_HEIGHT);

        //Game Mode
        icon = graphicsFactory.getGraphics(GraphicsFactory.MODE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE), icon, "Game Mode: ", cyclingState.gameMode, new Color(0,0,254));

        //Mode Type
        icon = graphicsFactory.getGraphics(GraphicsFactory.TYPE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*2), icon, "Mode Type: ", cyclingState.modeType, new Color(136,137,46));

        //Entity
        icon = graphicsFactory.getGraphics(GraphicsFactory.ID_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*3), icon, "Entity Id: ", cyclingState.selectedEntity.getInstanceID()+"", new Color(254,0,0));

        //Command
        icon = graphicsFactory.getGraphics(GraphicsFactory.COMMAND_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*4), icon, "Command: ", cyclingState.selectedCommand, new Color(254,0,254));
    }


    private void paintResources(Graphics g){
        g.setColor(new Color(0,0,0));

        //Food
        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.FOOD_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH*5, PixelMap.INIT_SPACE), icon, cyclingState.inTurn.getFood()+"");

        //Ore
        icon = graphicsFactory.getGraphics(GraphicsFactory.ORE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH*5, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE), icon, cyclingState.inTurn.getOre()+"");

        //Energy
        icon = graphicsFactory.getGraphics(GraphicsFactory.ENERGY_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH*5, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*2), icon, cyclingState.inTurn.getEnergy()+"");
    }
}
