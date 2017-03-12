package Views.PixelMaps;
/*--------------------------------------------------------------------------------------
|	PixelMap Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Maps normal coordinates to pixel coordinates and maintains pixel
|   proportions to automatically adjust to screen size.
---------------------------------------------------------------------------------------*/


import GameMap.MapCoordinate;
import Views.ViewPort;


import java.awt.*;

public class PixelMap {

    private static final double SCREEN_RATIO = 1.0;
    private static final int HORIZONTAL_MULTIPLIER = 20;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = (int)(screenSize.getWidth()*SCREEN_RATIO), SCREEN_HEIGHT = (int)(screenSize.getHeight()*SCREEN_RATIO);
    public static final int TILE_WIDTH = SCREEN_WIDTH/HORIZONTAL_MULTIPLIER;
    public static final int TILE_FULL_WIDTH = TILE_WIDTH*2;
    public static final int TILE_HEIGHT = (int)(1.73*TILE_WIDTH);
    public static final double STRUCTURE_TILE_HEIGHT = 0.5;
    public static final int STRUCTURE_HEIGHT = (int)(STRUCTURE_TILE_HEIGHT*(double)TILE_HEIGHT);
    public static final double UNIT_TILE_HEIGHT = 0.37;
    public static final int UNIT_HEIGHT = (int) ((double)STRUCTURE_HEIGHT*UNIT_TILE_HEIGHT);
    public static final int UNIT_MARKER_RADIUS = (int)((0.6)*UNIT_HEIGHT);
    public static final int TAB_WIDTH = TILE_WIDTH+TILE_WIDTH/3;
    public static final int TAB_HEIGHT = TAB_WIDTH/4;
    public static final int TAB_FONTSIZE = TAB_HEIGHT/2;
    public static final int ICON_SIZE = TILE_HEIGHT/5;
    public static final int INIT_SPACE = (int)((0.15)*(double)TILE_HEIGHT);
    public static final int AFTER_SPACE = INIT_SPACE + INIT_SPACE/2;


    //Plain Pixel Mapping based on position
    public static PixelPoint mapCoordinate(MapCoordinate coor){
        int width_offset = (int)(TILE_WIDTH * 1.5);
        int height_offset = (int)(0.5*TILE_HEIGHT);

        //If even Col
        if(coor.isOffset()){
            return new PixelPoint(coor.getColumn()*width_offset, coor.getRow()*TILE_HEIGHT);
        }
        //If odd Col
        else{
            return new PixelPoint(coor.getColumn()*width_offset, coor.getRow()*TILE_HEIGHT-height_offset);
        }
    }

    //Considers the viewport's origin
    public static PixelPoint mapCoordinate(MapCoordinate coor, ViewPort viewPort){
        int width_offset = (int)(TILE_WIDTH * 1.5);
        int height_offset = (int)(0.5*TILE_HEIGHT);
        PixelPoint origin = viewPort.getOrigin();

        //If even Col
        if(coor.isOffset()){
            return new PixelPoint(coor.getColumn()*width_offset - origin.x, coor.getRow()*TILE_HEIGHT - origin.y);
        }
        //If odd Col
        else{
            return new PixelPoint(coor.getColumn()*width_offset - origin.x, coor.getRow()*TILE_HEIGHT+height_offset - origin.y);
        }
    }
}
