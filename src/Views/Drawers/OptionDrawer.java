package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	OptionDrawer Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Draws an option name with an icon [not required], and a value next to it.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OptionDrawer {

    public static final int FONT_SIZE = PixelMap.UNIT_HEIGHT/2+PixelMap.UNIT_HEIGHT/5;

    public static void drawOption(Graphics g, PixelPoint point, BufferedImage icon, String name, String value, Color color){
        g.setColor(color);
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, FONT_SIZE));
        g.drawImage(icon, point.x, point.y, null);
        g.drawString(name+"\t"+value, point.x+icon.getWidth()+icon.getWidth()/4, point.y+(int)(0.70*(double)icon.getHeight()));
    }

    public static void drawOption(Graphics g, PixelPoint point, BufferedImage icon, String value){
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, FONT_SIZE));
        g.drawImage(icon, point.x, point.y, null);
        g.drawString(value, point.x+icon.getWidth()+icon.getWidth()/4, point.y+(int)(0.75*(double)icon.getHeight()));
    }

    public static void drawStats(Graphics g, Entity entity, PixelPoint position, GraphicsFactory graphicsFactory){
        g.drawRect(position.x, position.y-PixelMap.MARGIN, (int)(PixelMap.TILE_WIDTH*3.5), (int)(PixelMap.AFTER_SPACE*3.5));

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
