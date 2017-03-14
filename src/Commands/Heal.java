package Commands;

/*--------------------------------------------------------------------------------------
|    Heal Class: Created by Tonny Xie on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Structure.CapitalStructure;
import Entity.Unit.Unit;
import GameLibrary.GameLibrary;
import GameMap.*;
import GameMap.MapCoordinate;

public class Heal extends Command{

    public Heal(CapitalStructure capital) {
        super(GameLibrary.HEAL_UNIT, capital);
    }

    @Override
    public void execute() {
        MapCoordinate location = affected.getLocation();
        Tile tile = GameMap.getInstance().getTile(location);
        for (Entity entity: tile.getOccupyingEntities()) {
            if (entity instanceof Unit) {
                ((CapitalStructure) affected).healUnit((Unit)entity);
                entity.getEntityManager().playerOwner.spendFood(GameLibrary.HEAL_FOOD_COST);
            }
        }
        isFinished = true;
    }
}
