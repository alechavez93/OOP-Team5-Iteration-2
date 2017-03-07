package Views;
/*--------------------------------------------------------------------------------------
|	UnitDrawer Class: Created by Alejandro Chavez on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description: Is in charge of drawing respective units for a Player.
---------------------------------------------------------------------------------------*/

import Entity.Unit.Unit;
import Utility.Direction;
import Utility.GraphicsFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UnitDrawer {

    public static void drawUnit(Graphics g, Unit unit){
        g.setClip(null);
        PixelPoint center = PixelMap.mapCoordinate(unit.getLocation());
        PixelPoint pos = getFinalPos(unit, center);
        BufferedImage unitImg = GraphicsFactory.getInstance().getUnit(unit.getName());
        g.drawImage(unitImg, pos.x, pos.y, null);
    }

    private static void drawMarker(int radius, PixelPoint center){
        //First get color of the player in turn
    }

    private static PixelPoint getFinalPos(Unit unit, PixelPoint center){
        PixelPoint facingPos = getFacingPos(center, unit.getDirection());
        return new PixelPoint(facingPos.x-PixelMap.UNIT_HEIGHT/2, facingPos.y+PixelMap.UNIT_HEIGHT/2);
    }

    //Returns the possible points for drawing depending which direction the combat unit is facing
    private static PixelPoint getFacingPos(PixelPoint center, Direction facing){
        System.out.println(facing);
        int r = PixelMap.TILE_HEIGHT/2;
        double angle = 200;
        System.out.println("newX: "+(r*Math.cos(Math.toRadians(angle))));
        System.out.println("newY: "+(r*Math.sin(Math.toRadians(angle))));
        int x = (int)(center.x + r * Math.cos(Math.toRadians(angle)));
        int y = (int)(center.y - r * Math.sin(Math.toRadians(angle)));
        return new PixelPoint(x, y);
    }

}
