package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    MeleeSoldier Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class MeleeSoldier extends Soldier {

    public MeleeSoldier(int instanceID,MapCoordinate location) {
        super(GameLibrary.MELEE, instanceID, location);
        attack = 3;
        defense = 3;
        armor = 1;
        movement = 2;
        maxHealth = 20;
        currentHealth = maxHealth;
        rangeRadius = 1;
        visibilityRadius = 2;
        upkeep = 5;
    }
}
