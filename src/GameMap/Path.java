package GameMap;

/*--------------------------------------------------------------------------------------
|   GameMap.Path Class: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Represents a path through a stack of Directions.
|---------------------------------------------------------------------------------------*/

import Utility.Direction;

import java.util.Stack;

public class  Path {

    private Stack<Direction> path;
    private PathFinder creator;
    private MapCoordinate start;
    private MapCoordinate end;


    public Path(Stack<Direction> path, MapCoordinate start, MapCoordinate end) {
        this.path = path;
        this.start = start;
        this.end = end;
    }

    public Direction next() {
        return path.pop();
    }

    //Test this
    public boolean isValid() {
        Stack<Direction> copy = (Stack<Direction>)path.clone();
        Tile marker = GameMap.getInstance().getTile(end);
        while(!copy.empty()) {
            if(marker.isImpassable())
                return false;
            Direction d = copy.pop().getOpposite();
            marker = GameMap.getInstance().getNeighborTile(marker, d);
        }
        return true;
    }

    public boolean isEnd() { return path.empty(); }

    public void recreate(MapCoordinate curPos) {
        this.path = creator.createPath(curPos, end).path;
        this.start = curPos;
    }

    //Getters
    public MapCoordinate getStart() { return new MapCoordinate(start); }
    public MapCoordinate getEnd() { return new MapCoordinate(end); }
}
