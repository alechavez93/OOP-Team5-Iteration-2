package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    RangeSoldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;

public class RangeSoldier extends Soldier {

    public RangeSoldier(int instanceID, Coordinate location) {
        super("RANGE SOLDIER", instanceID, location);
        attack = 3;
        defense = 2;
        armor = 1;
        movement = 2;
        maxHealth = 20;
        currentHealth = maxHealth;
        rangeRadius = 2;
        visibilityRadius = 1;
        upkeep = 5;
    }
}
