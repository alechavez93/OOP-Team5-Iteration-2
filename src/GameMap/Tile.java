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
import GameLibrary.GameLibrary;
import Utility.Vec2i;
import Entity.Entity;
import Entity.EntityEffect;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Tile {
    private String name;
    private MapCoordinate pos;
    private int movementCost;
    private boolean isImpassable = false;
    private HarvestResources resources = null;

    private final GameLibrary.TileType type;

    private List<Entity> entityList = new LinkedList<Entity>();
    private List<EntityEffect> affectList = new LinkedList<EntityEffect>();


    public Entity[] getOccupyingEntities() { return entityList.toArray(new Entity[entityList.size()]); }

    public void addEntity(Entity entity) {
        entityList.add(entity);
        entity.setLocation(pos);
        if(!affectList.isEmpty()) {
            for(EntityEffect a : affectList)
                a.apply(entity);
        }
    }
    public void addArmyUnits(List<Unit> list) {
        entityList.addAll(list);
        for(Unit u : list) {
            u.setLocation(pos);
            if(!affectList.isEmpty()) {
                for(EntityEffect a : affectList)
                    a.apply(u);
            }
        }
    }

    public void addEffect(EntityEffect e) {
        affectList.add(e);
    }

    public void removeEffect(EntityEffect e) {
        affectList.remove(e);
    }

    public void removeEntity(Entity entity) { entityList.remove(entity); }

    public void removeArmyUnits(List<Unit> list) { entityList.removeAll(list); }


    //Factory Methods
    private Tile(String name, Vec2i pos, int movement, boolean isImpassable) {
        this.name = name;
        this.pos = new MapCoordinate(pos);
        this.movementCost = movement;
        this.isImpassable = isImpassable;
        this.resources = new HarvestResources(100,100,100);
        this.type = null;
        //activeItem = null;
    }

    private Tile(GameLibrary.TileType t, Vec2i pos) {
        this.name = t.name;
        this.pos = new MapCoordinate(pos);
        this.movementCost = t.movementCost;
        this.isImpassable = t.impassable;
        this.type = t;
        this.resources = new HarvestResources(100,100,100);
        //activeItem = null;
    }

    static public Tile makeTile(GameLibrary.TileType t, Vec2i pos) {
        return new Tile(t, pos);
    }

    //Currently only for testing
    static public Tile makeRandomTile(Vec2i pos, Random rng) {

        GameLibrary.TileType t = null;
        //Resource r = null;

        int random = rng.nextInt(8);
        switch(random) {
            case 0: case 1: case 2:
                t = GameLibrary.TileType.GRASS;
                break;
            case 3: case 4:
                t = GameLibrary.TileType.JUNGLE;
                break;
            case 5:
                t = GameLibrary.TileType.MOUNTAIN;
                 break;
            case 6:
                t = GameLibrary.TileType.WATER;
                break;
            case 7:
                t = GameLibrary.TileType.SAND;
                break;
        }
        return makeTile(t, pos);
    }


    //Getters
    public String getName() { return name; }
    public MapCoordinate getPos() { return new MapCoordinate(pos); }
    public int getMovementCost() { return movementCost;}
    public HarvestResources getResources() { return resources; }
    public GameLibrary.TileType getTileType() { return type; }
    public boolean isImpassable() { return isImpassable; }
    //public DamageEffect getActiveEffect() { return activeEffect; }

    //Setters
    /*
    public void setActiveEffect(DamageEffect effect) { activeEffect = effect; }
    */
    public void setImpassable(boolean impassable) { isImpassable = impassable; }
}
