package Views.PixelMaps;
/*--------------------------------------------------------------------------------------
|	PixelPoint Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

public class PixelPoint{
    public int x, y;

    public PixelPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PixelPoint getCopy(){
        return new PixelPoint(x, y);
    }
}
