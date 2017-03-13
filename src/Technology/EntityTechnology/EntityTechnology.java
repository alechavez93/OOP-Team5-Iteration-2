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

    public EntityTechnology(String researchType){
        super(researchType);
    }

    public void visit(Entity entity){
        if(researchType == VISIBILITY){ entity.upgradeVision(); }
        if(researchType == ATTACK) { entity.upgradeAttack(); }
        if(researchType == DEFENSE) { entity.upgradeDefense(); }
        if(researchType == ARMOR) { entity.upgradeArmor(); }
        if(researchType == SPEED) { entity.upgradeSpeed(); }
        if(researchType == HEALTH) { entity.upgradeHealth(); }
        if(researchType == EFFICIENCY) { entity.upgradeEfficiency(); }
    }

}
