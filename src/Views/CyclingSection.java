package Views;
/*--------------------------------------------------------------------------------------
|	CyclingSection Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the view part of the cycling and selection of commands. It
|   also displays some indicators such as Player in turn, Resources, etc.
---------------------------------------------------------------------------------------*/


import Entity.*;
import Game.CyclingState;
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
    CyclingState state;

    public CyclingSection(){
        setLayout(null);
        setBounds(0, ViewPort.VIEWPORT_HEIGHT, PixelMap.SCREEN_WIDTH/2, PixelMap.SCREEN_HEIGHT-ViewPort.VIEWPORT_HEIGHT);
        graphicsFactory = GraphicsFactory.getInstance();
        setVisible(true);
    }

    public void setState(CyclingState state){ this.state = state; }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawRect(5, 5, getWidth()-10, getHeight()-10);
        paintCyclingState(g);
        paintResources(g);
        paintSelectedArmy(g);
    }


    private void paintCyclingState(Graphics g){
        //Player
        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.PLAYER_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE), icon, "Player: ", state.inTurn.getName(), new Color(10,119,16));

        //Game Mode
        icon = graphicsFactory.getGraphics(GraphicsFactory.MODE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE), icon, "Game Mode: ", state.gameMode, new Color(0,0,254));

        //Mode Type
        icon = graphicsFactory.getGraphics(GraphicsFactory.TYPE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*2), icon, "Mode Type: ", state.modeType, new Color(136,137,46));

        //Entity
        icon = graphicsFactory.getGraphics(GraphicsFactory.ID_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*3), icon, "Entity Id: ", state.selectedEntity.getName()+" "+ state.selectedEntity.getInstanceID()%10, new Color(254,0,0));

        //Command
        icon = graphicsFactory.getGraphics(GraphicsFactory.COMMAND_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*4), icon, "Command: ", state.selectedCommand, new Color(254,0,254));
    }


    private void paintResources(Graphics g){
        g.setColor(new Color(0,0,0));

        //Food
        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.FOOD_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH*4, PixelMap.INIT_SPACE), icon, state.inTurn.getFood()+"");

        //Ore
        icon = graphicsFactory.getGraphics(GraphicsFactory.ORE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH*4, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE), icon, state.inTurn.getOre()+"");

        //Energy
        icon = graphicsFactory.getGraphics(GraphicsFactory.ENERGY_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH*4, PixelMap.INIT_SPACE+PixelMap.AFTER_SPACE*2), icon, state.inTurn.getEnergy()+"");
    }



    private void paintSelectedArmy(Graphics g){
        Entity armyObj = state.selectedArmy == null? new NONE(): state.selectedArmy;
        BufferedImage army = graphicsFactory.getGraphics(GameLibrary.ARMY_MODE);
        PixelPoint position =  new PixelPoint(PixelMap.TILE_WIDTH*5, PixelMap.INIT_SPACE);
        OptionDrawer.drawStats(g, armyObj, position , graphicsFactory);

        int width = PixelMap.UNIT_HEIGHT*3, height = PixelMap.UNIT_HEIGHT*3, x = (int)(position.x+PixelMap.TILE_WIDTH*3.7), y = position.y;
        g.drawRect(x-5, y-5, width+10, height+10);
        System.out.println(army);
        g.drawImage(army, x, y, width, height, null);

    }
}
