package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    ColonistUnit Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Colonist is responsible for building a capital which creates 5 workers
|   and 2 melee soldiers. There can only be one instance (more can not be created).
|   Stat Balance Note:
|       Low Movement (should not be able to outrun Soldiers)
---------------------------------------------------------------------------------------*/

import Entity.Structure.CapitalStructure;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class ColonistUnit extends Unit {

    public ColonistUnit(int instanceID, MapCoordinate location) {
        super(GameLibrary.COLONIST, instanceID, location);
        movement = 1;
        maxHealth = 10;
        currentHealth = maxHealth;
        visibilityRadius = 2;
        upkeep = 2;
    }

    public CapitalStructure createCapitalStructure(int instanceID) {
        return new CapitalStructure(instanceID, this.getLocation());
    }

    public MeleeSoldier createMeleeSoldier(int instanceID) {
        return new MeleeSoldier(instanceID, this.getLocation());
    }

    // MAKE WORKER METHOD NEEDS TO BE CALLED BY ENTITY MANAGER FOR
    

}
