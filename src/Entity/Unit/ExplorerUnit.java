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

import Utility.Coordinate;

public class ExplorerUnit extends Unit {

    public boolean prospectMode = false;

    public ExplorerUnit(int instanceID, Coordinate location) {
        super("EXPLORER", instanceID, location);
        movement = 5;
        maxHealth = 10;
        currentHealth = maxHealth;
        visibilityRadius = 2;
        upkeep = 2;
    }

    public void toggleProspectMode() {
        if (!prospectMode) {
            visibilityRadius = 1;
            movement = 2;
            prospectMode = true;
        } else {
            visibilityRadius = 2;
            movement = 5;
            prospectMode = false;
        }
    }

}
