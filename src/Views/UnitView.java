package Views;
/*--------------------------------------------------------------------------------------
|	UnitView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the overview of all the Units in a Player's possession.
---------------------------------------------------------------------------------------*/


import Entity.Entity;
import Entity.Unit.ColonistUnit;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import Entity.Unit.Unit;
import Game.CyclingState;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;
import Utility.GraphicsFactory;
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
    public static final int MARGIN = PixelMap.UNIT_HEIGHT/7;

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
        entityManager.addMelee(new MeleeSoldier(count++, new MapCoordinate(2,2), entityManager));
        entityManager.addRange(new RangeSoldier(count, new MapCoordinate(2,2), entityManager));
        entityManager.addColonist(new ColonistUnit(count, new MapCoordinate(2,2), entityManager));

        //Print Melee Units
        List<Entity> list = entityManager.getMeleeUnitList();
        printEntityList(g, list, 0);

        //Print Ranged Units
        list = entityManager.getRangeUnitList();
        printEntityList(g, list, 2);

        //Print Colonist Units
        list = entityManager.getColonistList();
        printEntityList(g, list, 4);

        //Print Explorer Units
        list = entityManager.getExplorerUnitList();
        printEntityList(g, list, 6);

        //Print Worker Count
        int workerCount = 0;
        PixelPoint point = new PixelPoint((PixelMap.TILE_WIDTH+PixelMap.TILE_WIDTH/2),PixelMap.UNIT_HEIGHT+PixelMap.STRUCTURE_HEIGHT*8);
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
                drawUnit(g, position, (Unit) list.get(i));
            }else{
                drawUnit(g, position, i);
            }
        }
        position.x += PixelMap.TILE_WIDTH;
        drawStats(g, list.get(0), position);
    }

    private void drawUnit(Graphics g, PixelPoint point, Unit unit){
        BufferedImage img = graphicsFactory.getGraphics(unit.getName());
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, OptionDrawer.FONT_SIZE));
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2);
        g.drawImage(img, point.x, point.y, PixelMap.STRUCTURE_HEIGHT, PixelMap.STRUCTURE_HEIGHT, null);
        g.drawString(unit.getInstanceID()+"",point.x+PixelMap.TILE_WIDTH/8, point.y+PixelMap.TILE_WIDTH/2+PixelMap.TILE_WIDTH/3);
        //Draw the health bar
        drawHealthBar(g, new PixelPoint(point.x, point.y+(int)(1.2*PixelMap.STRUCTURE_HEIGHT)), unit);
    }

    private void drawUnit(Graphics g, PixelPoint point, int number){
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 2*OptionDrawer.FONT_SIZE));
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2);
        g.drawString(number+"",point.x+(PixelMap.STRUCTURE_HEIGHT+30)/2-OptionDrawer.FONT_SIZE, point.y+(PixelMap.STRUCTURE_HEIGHT+30)/2);
    }

    private void drawHealthBar(Graphics g, PixelPoint point, Entity entity){
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+2* MARGIN,  OptionDrawer.FONT_SIZE+2* MARGIN);
        g.setColor(new Color(86,128,4));
        g.fillRect(point.x, point.y, (int)((double)entity.getCurrentHealth()/(double)entity.getMaxHealth()*PixelMap.STRUCTURE_HEIGHT), OptionDrawer.FONT_SIZE);
        g.setColor(new Color(0,0,0));
    }

    public void drawStats(Graphics g, Entity entity, PixelPoint position){
        g.drawRect(position.x, position.y-MARGIN, (int)(PixelMap.TILE_WIDTH*3.5), (int)(PixelMap.AFTER_SPACE*3.5));

        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.ATTACK_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(position.x+PixelMap.TILE_WIDTH/2, position.y), icon, entity.getAttack()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.DEFENSE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(position.x+PixelMap.TILE_WIDTH/2, position.y+PixelMap.AFTER_SPACE), icon, entity.getDefense()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.ARMOR_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(position.x+PixelMap.TILE_WIDTH/2, position.y+PixelMap.AFTER_SPACE*2), icon, entity.getArmor()+"");

        icon = graphicsFactory.getGraphics(GraphicsFactory.RANGE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(position.x+PixelMap.TILE_WIDTH*1.5), position.y), icon, entity.getRangeRadius()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.MOVEMENT_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(position.x+PixelMap.TILE_WIDTH*1.5), position.y+PixelMap.AFTER_SPACE), icon, entity.getMovement()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.VISION_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(position.x+PixelMap.TILE_WIDTH*1.5), position.y+PixelMap.AFTER_SPACE*2), icon, entity.getVisibilityRadius()+"");

        icon = graphicsFactory.getGraphics(GraphicsFactory.HEALTH_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(position.x+PixelMap.TILE_WIDTH*2.5), position.y), icon, entity.getMaxHealth()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.UPKEEP_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(position.x+PixelMap.TILE_WIDTH*2.5), position.y+PixelMap.AFTER_SPACE), icon, entity.getUpkeep()+"");
    }
}