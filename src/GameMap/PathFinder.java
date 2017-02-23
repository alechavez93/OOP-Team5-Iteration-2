package GameMap;

/*--------------------------------------------------------------------------------------
|   GameMap.PathFinder Interface: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Interface for GameMap.PathFinder Strategy
|---------------------------------------------------------------------------------------*/

public interface PathFinder {
    Path createPath(MapCoordinate start, MapCoordinate end);
    //Path recreatePath(Path p);
}
