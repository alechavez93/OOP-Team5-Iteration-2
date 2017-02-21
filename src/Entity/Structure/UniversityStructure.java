package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    UniversityStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: University is built by Workers. It produces technological advances
|   using the Workers staffed at the University. Only one technological advance can be
|   researched per University at a time.
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class UniversityStructure extends Structure {

    public UniversityStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.UNIVERSITY, instanceID, location);
    }
}
