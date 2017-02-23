package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    MineStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class MineStructure extends Structure {

    public MineStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.MINE, instanceID, location);
    }

}
