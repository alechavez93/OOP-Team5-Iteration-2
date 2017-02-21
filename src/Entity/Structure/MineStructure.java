package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    MineStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Mine is built by Workers. It can only harvest pre
|   which can be produced into metal by the Workers staffed at the Mine.
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class MineStructure extends Structure {

    public MineStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.MINE, instanceID, location);
    }

}
