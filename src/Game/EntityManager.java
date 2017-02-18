package Game;

/*--------------------------------------------------------------------------------------
|    EntityManager Class: Created by Tonny Xie on 2/18/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    int meleeSoldierListCount;

    int capitalStructureListCount;

    int meleeSoldierListMaxCount;
    int capitalStructureListMaxCount;

    List<Entity> meleeSoldierList;


    List<Entity> capitalStructureList;


    public EntityManager() {

        meleeSoldierList = new ArrayList<Entity>();

        capitalStructureList = new ArrayList<Entity>();
    }

    public void createCapitalStructure() {

    }

    private int findNextID(List<Entity> entityList, int count, int maxCount) {
        boolean valid = false;

        if (count < maxCount) {
            valid = true;
        }

        if (valid) {
            if (entityList.size() == 0) {

            }
        }
    }
}
