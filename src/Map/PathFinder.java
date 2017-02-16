package Map;

import Utility.Vec2i;

/*--------------------------------------------------------------------------------------
|   Map.PathFinder Interface: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Interface for Map.PathFinder Strategy
|---------------------------------------------------------------------------------------*/

public interface PathFinder {
    Path createPath(MapCoordinate start, MapCoordinate end);
    Path recreatePath(Path p);
}
