package Technology.StructureTechnology;

import Entity.Structure.*;
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

    public void visit(Structure structure){
        if(researchType == ENERGY) { structure.upgradeEnergyRate(); }
        if(researchType == FOOD) { structure.upgradeFoodRate(); }
        if(researchType == ORE) { structure.upgradeOreRate(); }
        if(researchType == POWER) { structure.upgradePowerRate(); }
        if(researchType == NUTRIENT) { structure.upgradeNutrientsRate(); }
        if(researchType == METAL) { structure.upgradeMetalRate(); }
        if(researchType == BREEDING) { structure.upgradeBreedingRate(); }
        if(researchType == EXPLORER) { structure.upgradeExplorerRate(); }
        if(researchType == SOLDIER) { structure.upgradeSolderRate(); }
    }
}
