package Commands;

/*--------------------------------------------------------------------------------------
|    Heal Class: Created by Tonny Xie on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.Army.Army;
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
                System.out.println("Healing Player " + entity.getEntityManager().playerOwner.getpID() + "'s Unit: " + entity.getName() + entity.getInstanceID());
                ((CapitalStructure) affected).heal((Unit)entity);
                entity.getEntityManager().playerOwner.spendFood(GameLibrary.HEAL_FOOD_COST);
            }
            if (entity instanceof Army) {
                System.out.println("Healing Player " + entity.getEntityManager().playerOwner.getpID() + "'s Army: " + entity.getName() + entity.getInstanceID());
                ((CapitalStructure) affected).heal((Army)entity);
                entity.getEntityManager().playerOwner.spendFood(GameLibrary.HEAL_FOOD_COST);
            }
        }
        isFinished = true;
    }
}
