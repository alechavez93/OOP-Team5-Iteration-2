package Entity;

/*--------------------------------------------------------------------------------------
|    GlobalEntities Class: Created by Tonny Xie on 3/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
---------------------------------------------------------------------------------------*/

public class GlobalEntities {
    private static GlobalEntities ourInstance = new GlobalEntities();

    public static GlobalEntities getInstance() {
        return ourInstance;
    }

    private GlobalEntities() {

        

    }
}
