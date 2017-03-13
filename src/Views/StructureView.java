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
        entityManager.addFarm(new FarmStructure(count, new MapCoordinate(2,2), entityManager));
        entityManager.addMine(new MineStructure(count, new MapCoordinate(2,3), entityManager));
        entityManager.addFort(new FortStructure(count, new MapCoordinate(2,4), entityManager));
        entityManager.addObservation(new ObservationStructure(count, new MapCoordinate(2,5), entityManager));
        entityManager.addUniversity(new UniversityStructure(count++, new MapCoordinate(3,5), entityManager));


        //Print Farms
        java.util.List<Entity> list = entityManager.getFarmList();
        printEntityList(g, list, 0);

        //Print Mines
        list = entityManager.getMineList();
        printEntityList(g, list, 2);

        //Print Forts
        list = entityManager.getFortList();
        printEntityList(g, list, 4);

        //Print Towers
        list = entityManager.getObservationList();
        printEntityList(g, list, 6);

        //Print Universities
        list = entityManager.getUniversityList();
        printEntityList(g, list, 8);
    }

    public void printEntityList(Graphics g, java.util.List<Entity> list, int rowMultiplier){
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
        OptionDrawer.drawStats(g, list.get(0), position, graphicsFactory);
    }
}
