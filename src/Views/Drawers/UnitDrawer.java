package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	UnitDrawer Class: Created by Alejandro Chavez on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description: Is in charge of drawing respective units for a Player. UnitDrawer also
|   does a mapping between directions and angles based on origin being x-axis.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Unit.Unit;
import Utility.Direction;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;
import Player.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UnitDrawer {

    public static final int MARGIN = PixelMap.MARGIN;

    public static void drawUnit(Graphics g, Unit unit){
        Player player = unit.getEntityManager().playerOwner;
        g.setClip(null);
        PixelPoint center = PixelMap.mapCoordinate(unit.getLocation());
        PixelPoint facingPos = getFacingPos(center, unit.getDirection());
        PixelPoint pos = getFinalPos(unit, center);
        BufferedImage unitImg = GraphicsFactory.getInstance().getUnit(unit.getName());

        //Drawing Unit and Marker
        g.drawImage(unitImg, pos.x, pos.y, PixelMap.UNIT_HEIGHT, PixelMap.UNIT_HEIGHT, null);
        drawMarker(g, PixelMap.UNIT_MARKER_RADIUS, facingPos, player);
    }


    private static void drawMarker(Graphics g, int radius, PixelPoint center, Player player){
        g.setColor(player.getColor());
        ((Graphics2D)g).setStroke(new BasicStroke(2));
        g.drawOval(center.x-radius, center.y-radius, radius*2, radius*2);
    }

    private static PixelPoint getFinalPos(Unit unit, PixelPoint center){
        PixelPoint facingPos = getFacingPos(center, unit.getDirection());
        return new PixelPoint(facingPos.x-PixelMap.UNIT_HEIGHT/2, facingPos.y-PixelMap.UNIT_HEIGHT/2);
    }

    //Returns the possible points for drawing depending which direction the combat unit is facing
    private static PixelPoint getFacingPos(PixelPoint center, Direction facing){
        double r = PixelMap.TILE_HEIGHT/2.6;
        double angle = getCommonSenseAngle(facing);
//        double angle = 330;
        int x = (int)(center.x + r * Math.cos(Math.toRadians(angle)));
        int y = (int)(center.y - r * Math.sin(Math.toRadians(angle)));
        return new PixelPoint(x, y);
    }

    //NE = 30, N = 90, NW = 150, SW = 210, S = 270, SE = 330
    public static int getCommonSenseAngle(Direction direction){
        if(direction == Direction.North) return 90;
        else if(direction == Direction.NorthEast) return 30;
        else if(direction == Direction.SouthEast) return 330;
        else if(direction == Direction.South) return 270;
        else if(direction == Direction.SouthWest) return 210;
        else if(direction == Direction.NorthWest) return 150;
        else return 0;
    }


    //Drawers for the different Views other than the MapView
    //--------------------------------------------------------------------------------------------------
    public static void drawUnit(Graphics g, PixelPoint point, Unit unit, GraphicsFactory graphicsFactory){
        BufferedImage img = graphicsFactory.getGraphics(unit.getName());
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, OptionDrawer.FONT_SIZE));
        g.drawRect(point.x- MARGIN, point.y- MARGIN, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2, PixelMap.STRUCTURE_HEIGHT+ MARGIN *2);
        g.drawImage(img, point.x, point.y, PixelMap.STRUCTURE_HEIGHT, PixelMap.STRUCTURE_HEIGHT, null);
        g.drawString(unit.getInstanceID()+"",point.x+PixelMap.TILE_WIDTH/8, point.y+PixelMap.TILE_WIDTH/2+PixelMap.TILE_WIDTH/3);
        //Draw the health bar
        drawHealthBar(g, new PixelPoint(point.x, point.y+(int)(1.2*PixelMap.STRUCTURE_HEIGHT)), unit);
    }

    public static void drawUnit(Graphics g, PixelPoint point, int number){
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
