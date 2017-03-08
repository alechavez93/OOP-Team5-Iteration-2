package Utility;

/**
 * Created by CustomerPC on 2/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    Direction Class: Created by CustomerPC on 2/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|                   )
|
---------------------------------------------------------------------------------------*/

public enum Direction {
        //Set up as Column/Row, don't ask
        NorthEast(30,1,-1),
        North(90,0,-1),
        NorthWest(150,-1,-1),
        SouthWest(210,-1,0),
        South(270,0,1),
        SouthEast(330,1,0);


    private final int dirAngle;
    private final int x;
    private final int y;

    Direction(int dirAngle, int x, int y) {
        this.dirAngle = dirAngle;
        this.x = x;
        this.y = y;
    }

    public int getAngle() {
        return dirAngle;
    }

    public Vec2i getHex(boolean offset) {
        return new Vec2i((offset && x != 0) ? y+1:y, x);
    }

    public Direction getOpposite() {
        int opposite = (dirAngle < 180) ? dirAngle + 180 : dirAngle - 180;

        return Direction.values()[opposite/60]; //wew
    }
}
