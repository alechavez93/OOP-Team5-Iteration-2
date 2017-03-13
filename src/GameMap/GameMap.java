package GameMap;
import Entity.Unit.Unit;
import GameLibrary.GameLibrary;
import Utility.Direction;
import Utility.Vec2i;
import Entity.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*--------------------------------------------------------------------------------------
|   GameMap.GameMap Class: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Responsible for managing the play-surface of the game. Has a matrix
|   of hexagonal GameMap.Tile objects of size (0 => x > sizeX, 0 => y > sizeY) with an
|   odd column offset. All vector methods assume (Row, Column) order.
|---------------------------------------------------------------------------------------*/

public class GameMap {
    static GameMap singleton = null;

    private Vec2i size;
    private Tile[][] tileGrid;
    private boolean isInitialized = false;

    private class MapIter implements Iterator<Tile> {

        private Vec2i iter = new Vec2i();

        public boolean hasNext() {
            return iter.y < size.x;
        }

        public Tile next() {
            Tile t = tileGrid[iter.y][iter.x];
            iter.x++;
            if (iter.x == size.y) {
                iter.x = 0;
                iter.y++;
            }
            return t;
        }
    }

    private GameMap() { }
    public static GameMap getInstance() {
        if(singleton == null)
            singleton = new GameMap();
        return singleton;
    }

    public void initialize(Vec2i size) {
        if(!isInitialized) {
            this.size = size;
            tileGrid = new Tile[size.x][size.y];
            isInitialized = true;
            for(short iii=0; iii < size.x; iii++) {
                for(short jjj=0; jjj < size.y; jjj++) {
                    //tileGrid[iii][jjj] = Tile.makeRandomTile(new Vec2i(iii, jjj), rng);\
                    tileGrid[iii][jjj] = Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(jjj, iii));
                }
            }
        } else {
            throw new IllegalStateException("GameMap is already initialized");
        }
    }

    public void initialize(char[][] cMap) {

        if(!isInitialized) {
            this.size = new Vec2i(cMap[0].length, cMap.length);
            tileGrid = new Tile[size.x][size.y];
            isInitialized = true;
            for(short iii=0; iii < size.y; iii++) {
                for(short jjj=0; jjj < size.x; jjj++) {
                    for(GameLibrary.TileType tt : GameLibrary.TileType.values()) {
                        if(cMap[iii][jjj] == tt.charSymbol) {
                            tileGrid[jjj][iii] = Tile.makeTile(tt, new Vec2i(iii,jjj));
                            break;
                        }
                    }
                }
            }
        } else {
            throw new IllegalStateException("GameMap is already initialized");
        }
    }


    public void testInit(Vec2i size) {
        if(!isInitialized) {
            this.size = new Vec2i(size);
            tileGrid = new Tile[size.x][size.y];
            Random rng = new Random();
            isInitialized = true;

            for(int iii=0; iii < size.x; iii++) {
                for(int jjj=0; jjj < size.y; jjj++) {
                    tileGrid[iii][jjj] = Tile.makeRandomTile(new Vec2i(jjj, iii), rng);
                }
            }
            //makeCoherent();
        } else {
            throw new IllegalStateException("GameMap is already initialized");
        }
    }

    //VERY WIP DO NOT ADD TO PRODUCTION CODE
    private void makeCoherent() {
        Iterator<Tile> itr = getIterator();
        while(itr.hasNext()) {
            Tile t = itr.next();
            if(t.getTileType() == GameLibrary.TileType.WATER) {
                List<Tile> tt = getAllNeighbors(t.getPos().getVector(), 1);
                for(Tile ttt : tt) {
                    if(ttt == null || ttt.getTileType() == GameLibrary.TileType.WATER)
                        continue;
                    Vec2i v = ttt.getPos().getVector();
                    tileGrid[v.y][v.x] = Tile.makeTile(GameLibrary.TileType.SAND, ttt.getPos().getVector());
                }
            }
        }
    }


    //Getters
    public Tile getTile(int row, int column) {
        if(!isInitialized)
            throw new IllegalStateException("GameMap is not initialized");
        if((column >= size.x || row >= size.y) || (column < 0 || row < 0))
            throw new IndexOutOfBoundsException();
        return tileGrid[column][row];
    }

    public Tile getTile(Vec2i pos) { return getTile(pos.x, pos.y); }
    public Tile getTile(MapCoordinate coord) { return getTile(coord.getRow(), coord.getColumn());}

    public Vec2i getSize() {
        if(!isInitialized)
            throw new IllegalStateException("GameMap is not initialized");
        return new Vec2i(size);
    }

    public Tile getNeighborTile(Vec2i pos, Direction dir) {
        if(!isValidNeighbor(pos, dir))
            throw new IndexOutOfBoundsException();
        return getTile(pos.add(dir.getHex(pos.y % 2 == 1)));
    }
    public Tile getNeighborTile(MapCoordinate coord, Direction dir) {
        return getNeighborTile(coord.getVector(), dir);
    }
    public Tile getNeighborTile(Tile tile, Direction dir) {
        return getNeighborTile(tile.getPos(), dir);
    }

    public void shiftEntity(Entity entity, Direction d) {
        Tile t = getTile(entity.getLocation());
        t.removeEntity(entity);
        t = getNeighborTile(t, d);
        t.addEntity(entity);
        entity.setLocation(t.getPos());
    }

    public void shiftArmyUnits(List<Unit> units, Direction d) {
        Tile t = getTile(units.get(0).getLocation());
        t.removeArmyUnits(units);
        t = getNeighborTile(t, d);
        t.removeArmyUnits(units);
        for(Unit u : units) u.setLocation(t.getPos());
    }

    public List<Tile> getAllNeighbors(Vec2i pos, int radius) {
        int total = 0;
        for(int iii = 1; iii <= radius; iii++)
            total += iii;
        List<Tile> finalList = new ArrayList<Tile>(total*6);
        int pX = pos.y;
        int pZ = pos.x - (pos.y - (pos.y%2)) / 2;
        int x, y, z;
        for(x = -radius; x <= radius; x++) {
            for (y = Math.max(-radius, -x - radius); y <= (Math.min(radius, -x + radius)); y++) {
                z = -x-y;
                int xx = pX + x;
                Vec2i offCoord = new Vec2i((z + pZ) + (xx - (xx%2)) / 2, xx);
                if(offCoord.equals(pos))
                    continue;
                if((offCoord.y >= size.x || offCoord.x >= size.y) || (offCoord.y < 0 || offCoord.x < 0))
                    continue;
                finalList.add(getTile(offCoord));
            }
        }
        return finalList;
    }


    public Iterator<Tile> getIterator() { return new MapIter(); }

    private boolean isValidNeighbor(Vec2i pos, Direction dir) {
        pos = pos.add(dir.getHex(pos.y % 2 == 1));
        return !(pos.x < 0 || pos.y < 0 || pos.x >= size.y || pos.y >= size.x);
    }

    public static Direction directionTo(MapCoordinate origin, MapCoordinate destination) {
        Vec2i c = origin.getVector().sub(destination.getVector());
        if(c.y == 0)
            return (c.x > 0) ? Direction.South : Direction.North;
        if(c.y > 0)
            return (c.x == origin.getVector().y%2) ? Direction.SouthEast : Direction.NorthEast;
        return (c.x == origin.getVector().y%2) ? Direction.SouthWest : Direction.NorthWest;
    }
}