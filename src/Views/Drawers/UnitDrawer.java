package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	UnitDrawer Class: Created by Alejandro Chavez on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description: Is in charge of drawing respective units for a Player. UnitDrawer also
|   does a mapping between directions and angles based on origin being x-axis.
---------------------------------------------------------------------------------------*/

import Entity.Unit.Unit;
import Utility.Direction;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UnitDrawer {

    public static void drawUnit(Graphics g, Unit unit){
        g.setClip(null);
        PixelPoint center = PixelMap.mapCoordinate(unit.getLocation());
        PixelPoint facingPos = getFacingPos(center, unit.getDirection());
        PixelPoint pos = getFinalPos(unit, center);
        BufferedImage unitImg = GraphicsFactory.getInstance().getUnit(unit.getName());

        //Drawing Unit and Marker
        g.drawImage(unitImg, pos.x, pos.y, null);
        drawMarker(g, PixelMap.UNIT_MARKER_RADIUS, facingPos);
    }

    private static void drawMarker(Graphics g, int radius, PixelPoint center){
        System.out.println("Trying to draw marker");
        g.setColor(new Color(0,0,255));
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawOval(center.x-radius, center.y-radius, radius*2, radius*2);
    }

    private static PixelPoint getFinalPos(Unit unit, PixelPoint center){
        PixelPoint facingPos = getFacingPos(center, unit.getDirection());
        return new PixelPoint(facingPos.x-PixelMap.UNIT_HEIGHT/2, facingPos.y-PixelMap.UNIT_HEIGHT/2);
    }

    //Returns the possible points for drawing depending which direction the combat unit is facing
    private static PixelPoint getFacingPos(PixelPoint center, Direction facing){
        System.out.println(facing);
        double r = PixelMap.TILE_HEIGHT/2.6;
        double angle = getCommonSenseAngle(facing);
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
}
