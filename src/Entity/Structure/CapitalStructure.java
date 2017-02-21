package Entity.Structure;

/*--------------------------------------------------------------------------------------
|    CapitalStructure Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Capital is built by Colonist. It can harvest energy, food, and ore
|   which can be produced into power, nutrients, and metal by the workers at the Capital.
|   Capital can also produce Explorers and Workers. Its the only structure with the
|   capability of healing. The game ends when Capital is destroyed.
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;

public class CapitalStructure extends Structure {

//    private int productionRate;
//    private Worker workerCount;
//    private int workRadius;

    public CapitalStructure(int instanceID, MapCoordinate location) {
        super(GameLibrary.CAPITAL, instanceID, location);
    }


}
