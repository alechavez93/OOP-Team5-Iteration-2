package Utility;

/**
 * Created by CustomerPC on 2/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    Direction Class: Created by CustomerPC on 2/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public enum Direction {
        //Set up as Column/Row, don't ask
        North(0,0,-1),
        NorthEast(60,1,-1),
        SouthEast(120,1,0),
        South(180,0,1),
        SouthWest(240,-1,0),
        NorthWest(300,-1,-1);


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
