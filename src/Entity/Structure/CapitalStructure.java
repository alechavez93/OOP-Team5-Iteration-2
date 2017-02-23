package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    CapitalStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class CapitalStructure extends Structure {

//    private int productionRate;
//    private Worker workerCount;
//    private int workRadius;

    public CapitalStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.CAPITAL, instanceID, location);
    }


}
