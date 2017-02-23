package Entity.Army;

/*--------------------------------------------------------------------------------------
|    RallyPoint Class: Created by Kevin on 2/21/17.
|---------------------------------------------------------------------------------------
|   Description:
|       Marks the destination point of a Army. Can be moved, and if so the army will
|       begin to move to the new RallyPoint destination.
|
---------------------------------------------------------------------------------------*/

import GameMap.MapCoordinate;

public class RallyPoint {

    private Army army;
    private MapCoordinate location;

    RallyPoint(Army army, MapCoordinate location){

        this.army = army;
        this.location = location;
    }

    public void setLocation(MapCoordinate location) {
        this.location = location;
    }

    public MapCoordinate getLocation() {
        return location;
    }
}
