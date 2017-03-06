package Views;
/*--------------------------------------------------------------------------------------
|	UnitDrawer Class: Created by Alejandro Chavez on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description: Is in charge of drawing respective units for a Player.
---------------------------------------------------------------------------------------*/

import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import Entity.Unit.Unit;
import Utility.Direction;
import Utility.GraphicsFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UnitDrawer {

    public static void drawUnit(Graphics g, Unit unit){
        g.setClip(null);
        PixelPoint center = PixelMap.mapCoordinate(unit.getLocation());
        PixelPoint pos = getFacingPos(unit, center);
        BufferedImage unitImg = GraphicsFactory.getInstance().getUnit(unit.getName());
        g.drawImage(unitImg, pos.x, pos.y, null);
    }

    private static void drawMarker(int radius, PixelPoint center){

    }

//    private static PixelPoint getFacingPos(RangeSoldier ranged, PixelPoint center){
//        return null;
//    }
//
//    private static PixelPoint getFacingPos(MeleeSoldier melee, PixelPoint center){
//        return null;
//    }

    private static PixelPoint getFacingPos(Unit unit, PixelPoint center){
        return new PixelPoint(center.x-PixelMap.UNIT_HEIGHT/2, center.y+PixelMap.TILE_HEIGHT/4);
    }

    //Returns the possible points for drawing depending which direction the combat unit is facing
    private static PixelPoint[] getSides(PixelPoint center, Direction facing){
        return null;
    }

}
