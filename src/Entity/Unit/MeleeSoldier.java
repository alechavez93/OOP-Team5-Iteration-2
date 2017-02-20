package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    MeleeSoldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;

public class MeleeSoldier extends Soldier {

    public MeleeSoldier(int instanceID, Coordinate location) {
        super("MELEE SOLDIER", instanceID, location);
        attack = 3;
        defense = 3;
        armor = 1;
        movement = 2;
        maxHealth = 20;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 1;
        upkeep = 5;
    }
}
