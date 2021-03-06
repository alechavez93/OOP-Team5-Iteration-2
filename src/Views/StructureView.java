package Views;
/*--------------------------------------------------------------------------------------
|	StructureView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Displays the States of all the Structures a Player has.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Structure.*;
import Game.CyclingState;
import GameMap.MapCoordinate;
import Player.EntityManager;
import Utility.GraphicsFactory;
import Views.Drawers.EntityDrawer;
import Views.Drawers.OptionDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;
import java.awt.*;

public class StructureView extends View{

    private int count = 0;
    private CyclingState state;
    public static final int MARGIN = PixelMap.MARGIN;
    private GraphicsFactory graphicsFactory;

    public StructureView(String name, CyclingState state){
        super(name);
        this.state = state;
        graphicsFactory = GraphicsFactory.getInstance();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        EntityManager entityManager = state.inTurn.getEntityManager();
//        entityManager.addFarm(new FarmStructure(count, new MapCoordinate(2,2), entityManager, 0));
//        entityManager.addMine(new MineStructure(count, new MapCoordinate(2,3), entityManager, 0));
//        entityManager.addFort(new FortStructure(count, new MapCoordinate(2,4), entityManager, 0));
//        entityManager.addObservation(new ObservationStructure(count, new MapCoordinate(2,5), entityManager, 0));
//        entityManager.addUniversity(new UniversityStructure(count++, new MapCoordinate(3,5), entityManager, 0));

        //Print Farms
        java.util.List<Entity> list = entityManager.getFarmList();
        printEntityList(g, list, 0, new FarmStructure(-1,null,null,0));

        //Print Mines
        list = entityManager.getMineList();
        printEntityList(g, list, 2, new MineStructure(-1,null,null,0));

        //Print Forts
        list = entityManager.getFortList();
        printEntityList(g, list, 4, new FortStructure(-1,null,null,0));

        //Print Towers
        list = entityManager.getObservationList();
        printEntityList(g, list, 6, new ObservationStructure(-1,null,null,0));

        //Print Universities
        list = entityManager.getUniversityList();
        printEntityList(g, list, 8, new UniversityStructure());

        //Print Universities
        list = entityManager.getCapitalList();
        printEntityList(g, list, 10, new CapitalStructure(-1, null, null));

//        list = entityManager.getCapitalList();
//        PixelPoint position = new PixelPoint((PixelMap.TILE_WIDTH+PixelMap.TILE_WIDTH/2)*(0+1),PixelMap.UNIT_HEIGHT+PixelMap.STRUCTURE_HEIGHT*10);
//        if(list.size() == 0)
//            EntityDrawer.drawEntity(g, position, new CapitalStructure(0,null, null), graphicsFactory);
//        else EntityDrawer.drawEntity(g, position, list.get(0), graphicsFactory);
    }

    public void printEntityList(Graphics g, java.util.List<Entity> list, int rowMultiplier, Entity sample){
        PixelPoint position = null;
        EntityDrawer.drawEntity(g, new PixelPoint(PixelMap.TILE_WIDTH - PixelMap.TILE_WIDTH/2 - PixelMap.TILE_WIDTH/4, PixelMap.UNIT_HEIGHT+PixelMap.STRUCTURE_HEIGHT*rowMultiplier), sample, graphicsFactory);
        for(int i=0; i<10; i++){
            position = new PixelPoint((PixelMap.TILE_WIDTH+PixelMap.TILE_WIDTH/2)*(i+1),PixelMap.UNIT_HEIGHT+PixelMap.STRUCTURE_HEIGHT*rowMultiplier);
            if(i<list.size()){
                EntityDrawer.drawEntity(g, position, list.get(i), graphicsFactory);
            }else if(!(sample instanceof CapitalStructure)){
                EntityDrawer.drawEntity(g, position, i);
            }
        }
        position.x += PixelMap.TILE_WIDTH;
        if(list.size() == 0) OptionDrawer.drawStats(g, sample, position, graphicsFactory);
        else OptionDrawer.drawStats(g, list.get(0), position, graphicsFactory);
    }
}
