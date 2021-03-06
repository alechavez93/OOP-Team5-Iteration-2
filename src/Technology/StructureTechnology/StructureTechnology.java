package Technology.StructureTechnology;

import Entity.Structure.*;
import Entity.Entity;
import static GameLibrary.GameLibrary.*;

import Technology.Technology;

/**
 * Created by test on 03/12/2017.
 */

/*--------------------------------------------------------------------------------------
|    StructureTechnology Module: Created by test on 03/12/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class StructureTechnology extends Technology {

    public StructureTechnology(String techType){
        super(techType);
    }

    public void visit(Entity entity){

    }

    public void visit(Structure structure){
        if(techType == ENERGY) { structure.upgradeEnergyRate(); }
        if(techType == FOOD) { structure.upgradeFoodRate(); }
        if(techType == ORE) { structure.upgradeOreRate(); }
        if(techType == POWER) { structure.upgradePowerRate(); }
        if(techType == NUTRIENT) { structure.upgradeNutrientsRate(); }
        if(techType == METAL) { structure.upgradeMetalRate(); }
        if(techType == BREED) { structure.upgradeBreedRate(); }
        if(techType == EXPLORER) { structure.upgradeExplorerRate(); }
        if(techType == SOLDIER) { structure.upgradeSolderRate(); }
    }
}
