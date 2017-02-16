package Views;
/*--------------------------------------------------------------------------------------
|	PixelMap Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;

import java.awt.*;

public class PixelMap {

    private static final double SCREEN_RATIO = 0.9;
    private static final int HORIZONTAL_MULTIPLIER = 20;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = (int)(screenSize.getWidth()*SCREEN_RATIO), SCREEN_HEIGHT = (int)(screenSize.getHeight()*SCREEN_RATIO);
    public static final int TILE_WIDTH = SCREEN_WIDTH/HORIZONTAL_MULTIPLIER;
    public static final int TILE_HEIGHT = (int)(1.73*TILE_WIDTH);

    public static PixelPoint mapCoordinate(Coordinate coor){
        int width_offset = (int)(TILE_WIDTH * 1.5);
        int height_offset = (int)(0.5*TILE_HEIGHT);

        //If even Col
        if(coor.getCol() % 2 == 0){
            return new PixelPoint(coor.getCol()*width_offset, coor.getRow()*TILE_HEIGHT);
        }
        //If odd Col
        else{
            return new PixelPoint(coor.getCol()*width_offset, coor.getRow()*TILE_HEIGHT+height_offset);
        }
    }
}
