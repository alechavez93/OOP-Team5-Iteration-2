package GameMap;

/*--------------------------------------------------------------------------------------
|   GameMap.Tile Class: Created by CustomerPC on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Represents a single map location and its associated data.
|   GameMap.Tile data is generally immutable with data modification achieved
|   through Effects/Items. A GameMap.Tile holds a List of Entity objects that can be
|   added to and removed from.
|---------------------------------------------------------------------------------------*/

//import Item.Item;
import Entity.Unit.Unit;
import Utility.Vec2i;
import Entity.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Tile {
    private String name;
    private MapCoordinate pos;
    private int movementCost;
    private boolean isImpassable = false;

    //private Effect activeEffect;
    private List<Entity> entityList = new LinkedList<Entity>();


    public Entity[] getOccupyingEntities() { return entityList.toArray(new Entity[entityList.size()]); }

    public void addEntity(Entity entity) {
        entityList.add(entity);
        //if(activeEffect != null)
        //    activeEffect.execute(entity);
        //if(activeItem != null)
        //    activeItem.triggerItemEffect();
    }
    public void addArmyUnits(List<Unit> list) {
        entityList.addAll(list);
    }

    public void removeEntity(Entity entity) { entityList.remove(entity); }
    public void removeArmyUnits(List<Unit> list) { entityList.removeAll(list); }


    //Factory Methods
    private Tile(String name, Vec2i pos, int movement) {
        this.name = name;
        this.pos = new MapCoordinate(pos);
        this.movementCost = movement;
        //activeItem = null;
    }

    static public Tile makeGrassTile(Vec2i pos) {
        return new Tile("Grass", pos, 1);
    }

    static public Tile makeJungleTile(Vec2i pos) {
        return new Tile("Jungle", pos, 3);
    }

    static public Tile makeMountainTile(Vec2i pos) {
        Tile t = new Tile("Mountain", pos, 999);
        t.isImpassable = true;
        return t;
    }

    //Currently only for testing
    static public Tile makeRandomTile(Vec2i pos, Random rng) {

        Tile t = null;
        //Resource r = null;

        int random = rng.nextInt(6);
        switch(random) {
            case 0: case 1: case 2:
                t = makeGrassTile(pos);
                break;
            case 3: case 4:
                t = makeJungleTile(pos);
                break;
            case 5:
                t = makeMountainTile(pos);
                 break;
        }
        return t;
    }


    //Getters
    public String getName() { return name; }
    public MapCoordinate getPos() { return new MapCoordinate(pos); }
    public int getMovementCost() { return movementCost;}
    public boolean isImpassable() { return isImpassable; }
    //public Effect getActiveEffect() { return activeEffect; }

    //Setters
    /*
    public void setActiveEffect(Effect effect) { activeEffect = effect; }
    */
    public void setImpassable(boolean impassable) { isImpassable = impassable; }
}
