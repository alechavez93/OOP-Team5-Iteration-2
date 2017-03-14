package Entity.Unit;

/*--------------------------------------------------------------------------------------
|    ExplorerUnit Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Explorer is responsible for revealing terrain (makes tiles visible) and
|   when in prospecting mode, reveals nearby resources. If Explorer is prospecting,
|   movement speed is "significantly" lowered.
|   Stat Balance Note:
|       High Movement (when not prospecting)
|       High Visibility (compared to other units)
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

public class ExplorerUnit extends Unit {

    private boolean prospectMode = false;

    public ExplorerUnit(int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(GameLibrary.EXPLORER, instanceID, location, entityManager);
        movement = 5;
        maxHealth = 10;
        currentHealth = maxHealth;
        visibilityRadius = 4;
        upkeep = 12;
    }

    public void toggleProspectMode() {
        if (!prospectMode) {
            visibilityRadius = 2;
            movement = 2;
            prospectMode = true;
        } else {
            visibilityRadius = 4;
            movement = 5;
            prospectMode = false;
        }
    }

    public void destroy(){
        entityManager.destroyExplorer(this);
    }
}
