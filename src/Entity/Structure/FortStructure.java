package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    FortStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class FortStructure extends Structure {

    public FortStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.FORT, instanceID, location);
    }

}
