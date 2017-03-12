package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    UniversityStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|       University is built by Workers.
|       Produce technological advances
|       Staffed by Workers
|       Only ONE tech advance can be researched at one time
|       NOTE: + indicates implemented functions
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Technology;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class UniversityStructure extends Structure {

    public UniversityStructure(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.UNIVERSITY, instanceID, location, entityManager);
    }

    public Technology completeResearch(){
        Technology tech = new Technology();
        return tech;
    }

    public void destroy(){
        entityManager.destroyUniversity(this);
    }
}
