package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    UniversityStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Technology;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class UniversityStructure extends Structure {

    public UniversityStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.UNIVERSITY, instanceID, location);
    }

    public Technology completeResearch(){
        Technology tech = new Technology();
        return tech;
    }
}
