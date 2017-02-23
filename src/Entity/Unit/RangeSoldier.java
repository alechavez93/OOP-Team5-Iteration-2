package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    RangeSoldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class RangeSoldier extends Soldier {

    public RangeSoldier(int instanceID, MapCoordinate location) {
        super(GameLibrary.RANGED, instanceID, location);
        attack = 3;
        defense = 2;
        armor = 1;
        movement = 2;
        maxHealth = 20;
        currentHealth = maxHealth;
        rangeRadius = 2;
        visibilityRadius = 2;
        upkeep = 5;
    }
}
