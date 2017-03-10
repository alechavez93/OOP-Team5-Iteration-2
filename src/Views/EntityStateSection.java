package Views;
/*--------------------------------------------------------------------------------------
|	EntityStateSection Class: Created by Alejandro Chavez on 3/10/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the selected Entity's state for the player to check in real time.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Game.CyclingState;
import Utility.GraphicsFactory;
import Views.Drawers.OptionDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EntityStateSection extends JPanel{

    GraphicsFactory graphicsFactory;
    CyclingState cyclingState;

    public EntityStateSection(){
        setLayout(null);
        setBounds(PixelMap.SCREEN_WIDTH/2, ViewPort.VIEWPORT_HEIGHT, PixelMap.SCREEN_WIDTH/4, PixelMap.SCREEN_HEIGHT-ViewPort.VIEWPORT_HEIGHT);
        graphicsFactory = GraphicsFactory.getInstance();
        setBackground(new Color(255, 255, 255));
        setVisible(true);
    }

    public void setCyclingState(CyclingState cyclingState){ this.cyclingState = cyclingState; }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawRect(5, 5, getWidth()-10, getHeight()-10);

        Entity entity = cyclingState.selectedEntity;

        BufferedImage icon = graphicsFactory.getGraphics(GraphicsFactory.ATTACK_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, 50), icon, entity.getAttack()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.DEFENSE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, 125), icon, entity.getDefense()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.ARMOR_ICON);
        OptionDrawer.drawOption(g, new PixelPoint(PixelMap.TILE_WIDTH/2, 200), icon, entity.getArmor()+"");

        icon = graphicsFactory.getGraphics(GraphicsFactory.RANGE_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(PixelMap.TILE_WIDTH*1.5), 50), icon, entity.getRangeRadius()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.MOVEMENT_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(PixelMap.TILE_WIDTH*1.5), 125), icon, entity.getMovement()+"");
        icon = graphicsFactory.getGraphics(GraphicsFactory.VISION_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(PixelMap.TILE_WIDTH*1.5), 200), icon, entity.getVisibilityRadius()+"");

        icon = graphicsFactory.getGraphics(GraphicsFactory.HEALTH_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(PixelMap.TILE_WIDTH*2.5), 50), icon, entity.getCurrentHealth()+"/"+entity.getMaxHealth());
        icon = graphicsFactory.getGraphics(GraphicsFactory.UPKEEP_ICON);
        OptionDrawer.drawOption(g, new PixelPoint((int)(PixelMap.TILE_WIDTH*2.5), 125), icon, entity.getUpkeep()+"");

        icon = graphicsFactory.getGraphics(entity.getName());
        int width = PixelMap.UNIT_HEIGHT*3, height = PixelMap.UNIT_HEIGHT*3, x = (int)(PixelMap.TILE_WIDTH*3.8), y = 50;
        g.drawRect(x-5, y-5, width+10, height+10);
        g.drawImage(icon, x, y, width, height, null);
    }

}
