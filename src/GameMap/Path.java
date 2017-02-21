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

    public boolean isValid() {
        //TODO: Make path checker in case of terrain changes
        return !path.empty();
    }

    //Attempt to recreate path and return result
    public Path recreate() {
        return creator.recreatePath(this);
    }

    //Getters
    public MapCoordinate getStart() { return new MapCoordinate(start); }
    public MapCoordinate getEnd() { return new MapCoordinate(end); }
}
