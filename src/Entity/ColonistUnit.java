package Entity;

/*--------------------------------------------------------------------------------------
|    ColonistUnit Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Colonist is responsible for building a capital which creates 5 workers
|   and 2 melee soldiers. There can only be one instance (more can not be created).
|   Stat Balance Note:
|       Low Movement (should not be able to outrun Soldiers)
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;

public class ColonistUnit extends Unit {

    public ColonistUnit(int instanceID, Coordinate location) {
        super("COLONIST UNIT", instanceID, location);
        movement = 1;
        maxHealth = 10;
        currentHealth = maxHealth;
        visibilityRadius = 1;
        upkeep = 2;
    }

}
