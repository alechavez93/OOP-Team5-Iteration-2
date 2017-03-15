package Commands;

import Entity.Structure.FortStructure;
import GameLibrary.GameLibrary;

/**
 * Created by test on 03/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    MakeMelee Module: Created by test on 03/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MakeMelee extends MakeSoldier {

    public MakeMelee(FortStructure fortStructure){
        super(fortStructure, GameLibrary.MELEE);
    }
}
