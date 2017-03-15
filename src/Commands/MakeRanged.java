package Commands;

import Entity.Structure.FortStructure;
import GameLibrary.GameLibrary;

/**
 * Created by test on 03/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    MakeRanged Module: Created by test on 03/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MakeRanged extends MakeSoldier {

    public MakeRanged(FortStructure fortStructure){
        super(fortStructure, GameLibrary.RANGED);
    }
}
