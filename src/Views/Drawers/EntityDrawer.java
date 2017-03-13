package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	EntityDrawer Class: Created by Alejandro Chavez on 3/12/2017.
|---------------------------------------------------------------------------------------
|   Description: In charge of Drawing general entities at generic locations. Used by
|   the Views.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Unit.Unit;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EntityDrawer {

    public static final int MARGIN = PixelMap.MARGIN;

    //Drawers for the different Views other than the MapView
    //--------------------------------------------------------------------------------------------------
    public static void drawEntity(Graphics g, PixelPoint point, Entity entity, GraphicsFactory graphicsFactory){
        BufferedImage img = graphicsFactory.getGraphics(entity.getName());
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, OptionDrawer.FONT_SIZE));
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2);
        g.drawImage(img, point.x, point.y, PixelMap.STRUCTURE_HEIGHT, PixelMap.STRUCTURE_HEIGHT, null);
        g.drawString(entity.getInstanceID()+"",point.x+PixelMap.TILE_WIDTH/8, point.y+PixelMap.TILE_WIDTH/2+PixelMap.TILE_WIDTH/3);
        //Draw the health bar
        drawHealthBar(g, new PixelPoint(point.x, point.y+(int)(1.2*PixelMap.STRUCTURE_HEIGHT)), entity);
    }

    public static void drawEntity(Graphics g, PixelPoint point, int number){
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 2*OptionDrawer.FONT_SIZE));
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2);
        g.drawString(number+"",point.x+(PixelMap.STRUCTURE_HEIGHT+30)/2-OptionDrawer.FONT_SIZE, point.y+(PixelMap.STRUCTURE_HEIGHT+30)/2);
    }

    public static void drawHealthBar(Graphics g, PixelPoint point, Entity entity){
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+2* MARGIN,  OptionDrawer.FONT_SIZE+2* MARGIN);
        g.setColor(new Color(86,128,4));
        g.fillRect(point.x, point.y, (int)((double)entity.getCurrentHealth()/(double)entity.getMaxHealth()*PixelMap.STRUCTURE_HEIGHT), OptionDrawer.FONT_SIZE);
        g.setColor(new Color(0,0,0));
    }
}
