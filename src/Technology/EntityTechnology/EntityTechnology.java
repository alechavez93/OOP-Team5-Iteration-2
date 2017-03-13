package Technology.EntityTechnology;

import Entity.Entity;
import Technology.*;

import static GameLibrary.GameLibrary.*;

/**
 * Created by test on 03/12/2017.
 */

/*--------------------------------------------------------------------------------------
|    EntityTechnology Module: Created by test on 03/12/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class EntityTechnology extends Technology {

    public EntityTechnology(String techType){
        super(techType);
    }

    public void visit(Entity entity){
        if(techType == VISIBILITY){ entity.upgradeVision(); }
        if(techType == ATTACK) { entity.upgradeAttack(); }
        if(techType == DEFENSE) { entity.upgradeDefense(); }
        if(techType == ARMOR) { entity.upgradeArmor(); }
        if(techType == SPEED) { entity.upgradeSpeed(); }
        if(techType == HEALTH) { entity.upgradeHealth(); }
        if(techType == EFFICIENCY) { entity.upgradeEfficiency(); }
    }

}
