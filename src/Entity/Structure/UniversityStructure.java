package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    UniversityStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class UniversityStructure extends Structure {

    public UniversityStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.UNIVERSITY, instanceID, location);
    }
}
