package Views;
/*--------------------------------------------------------------------------------------
|	UnitView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the overview of all the Units in a Player's possession.
---------------------------------------------------------------------------------------*/


import Entity.Entity;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import Game.CyclingState;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;
import Utility.GraphicsFactory;
import Views.Drawers.EntityDrawer;
import Views.Drawers.OptionDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class UnitView extends View{

    private CyclingState state;
    private GraphicsFactory graphicsFactory;
    int count = 0;
    public static final int MARGIN = PixelMap.MARGIN;

    public UnitView(String name, CyclingState state){
        super(name);
        this.state = state;
        graphicsFactory = GraphicsFactory.getInstance();
    }

    public void CyclingState(CyclingState state){
        this.state = state;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        EntityManager entityManager = state.inTurn.getEntityManager();
//        entityManager.addMelee(new MeleeSoldier(count, new MapCoordinate(2,2), entityManager));
//        entityManager.addRange(new RangeSoldier(count++, new MapCoordinate(2,2), entityManager));

        //Print Melee Units
        List<Entity> list = entityManager.getMeleeUnitList();
        printEntityList(g, list, 0);

        //Print Ranged Units
        list = entityManager.getRangeUnitList();
        printEntityList(g, list, 2);

        //Print Explorer Units
        list = entityManager.getExplorerUnitList();
        printEntityList(g, list, 4);

        //Print Worker Count
        int workerCount = 0;
        PixelPoint point = new PixelPoint((PixelMap.TILE_WIDTH+PixelMap.TILE_WIDTH/2),PixelMap.UNIT_HEIGHT+PixelMap.STRUCTURE_HEIGHT*6);
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2);
        BufferedImage worker = graphicsFactory.getGraphics(GameLibrary.WORKER);
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 2*OptionDrawer.FONT_SIZE));
        g.drawImage(worker, point.x, point.y, PixelMap.STRUCTURE_HEIGHT, PixelMap.STRUCTURE_HEIGHT, null);
        g.drawString(workerCount+"/100", point.x+PixelMap.STRUCTURE_HEIGHT+5*MARGIN, point.y+PixelMap.STRUCTURE_HEIGHT/2+2*MARGIN);

    }

    public void printEntityList(Graphics g, List<Entity> list, int rowMultiplier){
        PixelPoint position = null;

        for(int i=0; i<10; i++){
            position = new PixelPoint((PixelMap.TILE_WIDTH+PixelMap.TILE_WIDTH/2)*(i+1),PixelMap.UNIT_HEIGHT+PixelMap.STRUCTURE_HEIGHT*rowMultiplier);
            if(i<list.size()){
                EntityDrawer.drawEntity(g, position, list.get(i), graphicsFactory);
            }else{
                EntityDrawer.drawEntity(g, position, i);
            }
        }
        position.x += PixelMap.TILE_WIDTH;
        if(list.size() == 0) return;
        OptionDrawer.drawStats(g, list.get(0), position, graphicsFactory);
    }
}