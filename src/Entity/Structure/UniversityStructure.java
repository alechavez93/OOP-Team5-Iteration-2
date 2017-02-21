package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    UniversityStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: University is built by Workers. It produces technological advances
|   using the Workers staffed at the University. Only one technological advance can be
|   researched per University at a time.
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
