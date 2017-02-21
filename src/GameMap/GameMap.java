package GameMap;
import Utility.Direction;
import Utility.Vec2i;

import java.util.Iterator;

/*--------------------------------------------------------------------------------------
|   GameMap.GameMap Class: Created by Andrew on 2/2/2017.
|---------------------------------------------------------------------------------------
|   Description: Responsible for managing the play-surface of the game. Has a matrix
|   of hexagonal GameMap.Tile objects of size (0 => x > sizeX, 0 => y > sizeY) with an
|   odd column offset.
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
            Tile t = tileGrid[iter.x][iter.y];
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
            //Random rng = new Random();
            for(int iii=0; iii < size.x; iii++) {
                for(int jjj=0; jjj < size.y; jjj++) {
                    //tileGrid[iii][jjj] = Tile.makeRandomTile(new Vec2i(iii, jjj), rng);\
                    tileGrid[iii][jjj] = Tile.makeGrassTile(new Vec2i(iii, jjj));
                }
            }
            isInitialized = true;
        } else {
            throw new IllegalStateException("GameMap is already initialized");
        }
    }

    /**
     / Generates a matrix of integers that represent the movement costs of the map Tiles.
     */
    /*
    public int[][] generateMoveCostMatrix() {
        if(!isInitialized)
            throw new IllegalStateException("GameMap is not initialized");
        int[][] matrix = new int[size.x][size.y];
        for(int iii=0; iii < size.x; iii++) {
            for(int jjj=0; jjj < size.y; jjj++) {
                Tile t = tileGrid[iii][jjj];
                matrix[iii][jjj] = (t.isImpassable()) ? 999 : t.getMovementCost();
            }
        }
        return matrix;
    }
    */

    public Tile[] getAllNeighbors(Vec2i pos) {
        Tile[] t = new Tile[Direction.values().length];
        int iii = 0;
        for(Direction d : Direction.values()) {
            t[iii++] = getNeighborTile(pos, d);
        }
        return t;
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
    public Tile getTile(int x, int y) {
        if(!isInitialized)
            throw new IllegalStateException("GameMap is not initialized");
        if((x >= size.x || y >= size.y) || (x < 0 || y < 0))
            throw new IndexOutOfBoundsException();
        return tileGrid[x][y];
    }

    public Tile getTile(Vec2i pos) {
        return getTile(pos.x, pos.y);
    }
    public Tile getTile(MapCoordinate coord) { return getTile(coord.getColumn(), coord.getRow());}

    public Vec2i getSize() {
        if(!isInitialized)
            throw new IllegalStateException("GameMap is not initialized");
        return new Vec2i(size);
    }

    public Tile getNeighborTile(Vec2i pos, Direction dir) {
        return getTile(pos.add(dir.getHex(pos.x % 2 == 1)));
    }
    public Tile getNeighborTile(MapCoordinate coord, Direction dir) {
        return getTile(coord.getVector().add(dir.getHex(coord.isOffset()))); //wew
    }
    public Tile getNeighborTile(Tile tile, Direction dir) {
        return getNeighborTile(tile.getPos(), dir);
    }

    public Iterator getIterator() { return new MapIter(); }
}
