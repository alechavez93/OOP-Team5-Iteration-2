package Map;

import Utility.Vec2i;

/**
 * Created by CustomerPC on 2/15/2017.
 */

/*--------------------------------------------------------------------------------------
|   MapCoordinate Class: Created by Andrew on 2/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Represents a location on the play-surface through a bounded
|   2D vector.
---------------------------------------------------------------------------------------*/

public class MapCoordinate {
    private Vec2i coord;
    private final Vec2i size;


    public MapCoordinate(Vec2i coord) {
        this.size = GameMap.getInstance().getSize();
        coord = new Vec2i();
        if(!this.setCoord(coord))
            throw new IndexOutOfBoundsException();
    }

    public MapCoordinate(int row, int column) {
        this.size = GameMap.getInstance().getSize();
        coord = new Vec2i();
        if(!this.setCoord(new Vec2i(row, column)));
            throw new IndexOutOfBoundsException();
    }

    public MapCoordinate(MapCoordinate coord) {
        this.coord = new Vec2i(coord.coord);
        this.size = coord.size;
    }




    public int getRow() { return coord.x; }
    public int getColumn() { return coord.y; }
    public Vec2i getVector() {return new Vec2i(coord);}
    public boolean isOffset() { return (coord.y%2 == 1);}

    public boolean setRow(int row){
        if(row < 0 || row >= size.y) //size is inverted
            return false;
        coord.x = row;
        return true;
    }

    public boolean setColumn(int col){
        if(col < 0 || col >= size.x) //size is inverted
            return false;
        coord.y = col;
        return true;
    }

    public boolean setCoord(Vec2i coord) {
        if(coord.x < 0 || coord.x >= size.y)
            return false;
        if(coord.y < 0 || coord.y >= size.x)
            return false;
        coord = new Vec2i(coord);
        return true;
    }
}
