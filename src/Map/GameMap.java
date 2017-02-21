package Map;
import Utility.Direction;
import Utility.Vec2i;

import java.util.Iterator;

/*--------------------------------------------------------------------------------------
|   GameMap.GameMap Class: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Responsible for managing the play-surface of the game. Has a matrix
|   of hexagonal GameMap.Tile objects of size (0 => x > sizeX, 0 => y > sizeY) with an
|   odd column offset. All vector methods assume (Row, Column) order.
|---------------------------------------------------------------------------------------*/

public class GameMap {
    //TODO: Proper singleton design pattern
    static GameMap singleton = null;

    private Vec2i size;
    private Tile[][] tileGrid;
    private boolean isInitialized = false;

    private class MapIter implements Iterator<Tile> {

        private Vec2i iter = new Vec2i();

        public boolean hasNext() {
            return iter.y < size.y;
        }

        public Tile next() {
            Tile t = tileGrid[iter.y][iter.x];
            iter.x++;
            if (iter.x == size.x) {
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
                    tileGrid[iii][jjj] = Tile.makeGrassTile(new Vec2i(jjj, iii));
                }
            }
        } else {
            throw new IllegalStateException("GameMap is already initialized");
        }
    }


    /*
    //For testing purposes
    public void hardCodeInit() {
        char hardCode[] = {
                'm','g','g','g','m',
                'j','j','g','j','j',
                'm','g','m','g','m',
                'j','j','g','j','j',
                'm','g','g','g','m'
        };

        if(!isInitialized) {
            this.size = new Vec2i(5,5);
            tileGrid = new Tile[size.x][size.y];
            for(int iii=0; iii < size.x; iii++) {
                for(int jjj=0; jjj < size.y; jjj++) {
                    switch(hardCode[iii + jjj*size.x]) {
                        case 'g':
                            Resource f = new Resource(Resource.ResourceType.Food, 3);
                            tileGrid[iii][jjj] = Tile.makeGrassTile(new Vec2i(iii,jjj), f);
                            break;
                        case 'j':
                            Resource w = new Resource(Resource.ResourceType.Wood, 3);
                            tileGrid[iii][jjj] = Tile.makeJungleTile(new Vec2i(iii,jjj), w);
                            break;
                        case 'm':
                            tileGrid[iii][jjj] = Tile.makeMountainTile(new Vec2i(iii,jjj), null);
                            break;
                    }
                }
            }
            isInitialized = true;
        } else {
            throw new IllegalStateException("GameMap is already initialized");
        }
    }
    */


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
        return getTile(pos.add(dir.getHex(pos.x % 2 == 1)));
    }
    public Tile getNeighborTile(MapCoordinate coord, Direction dir) {
        return getNeighborTile(coord.getVector(), dir);
    }
    public Tile getNeighborTile(Tile tile, Direction dir) {
        return getNeighborTile(tile.getPos(), dir);
    }

    public Tile[] getAllNeighbors(Vec2i pos) {
        Tile[] t = new Tile[Direction.values().length];
        byte iii = 0; //If your tiles have more than 128 neighbors its time to re-evaluate your life
        for(Direction d : Direction.values()) {
            if(isValidNeighbor(pos, d))
                t[iii++] = getNeighborTile(pos, d);
        }
        return t;
    }

    public Iterator getIterator() { return new MapIter(); }

    private boolean isValidNeighbor(Vec2i pos, Direction dir) {
        pos = pos.add(dir.getHex(pos.x % 2 == 1));
        return !(pos.x < 0 || pos.y < 0 || pos.x >= size.y || pos.y >= size.x);
    }
}
