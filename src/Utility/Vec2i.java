package Utility;

/*--------------------------------------------------------------------------------------
|   Utility.Vec2i Class: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Barebone 2D integer vector. No need for dedicated getters/setters.
|---------------------------------------------------------------------------------------*/

public class Vec2i {
    public int x;
    public int y;

    //Constructors
    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2i(Vec2i v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vec2i() {
        x = y = 0;
    }




    public Vec2i add(Vec2i v) { return new Vec2i(v.x + x, v.y + y); }
    public Vec2i sub(Vec2i v) { return new Vec2i(x - v.x, y - v.y); }
    public boolean equals(Vec2i v) { return (x == v.x) && (y == v.y);}

    public int dot(Vec2i v) { return (v.x*x + v.y*y); }
    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

}
