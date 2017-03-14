package Technology;

import Entity.*;

/**
 * Created by test on 03/11/2017.
 */

/*--------------------------------------------------------------------------------------
|    Technology Module: Created by test on 03/11/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public abstract class  Technology {
    protected String techType;

    public Technology(String techType){
        this.techType = techType;
    }

    public void visit(Entity entity){

    };


}
