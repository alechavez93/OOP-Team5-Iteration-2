package MapTests;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.Soldier.MeleeSoldier;
import Entity.Entity;
import Entity.Unit.Soldier.RangeSoldier;
import Entity.Unit.Unit;
import GameLibrary.GameLibrary;
import GameMap.*;
import Utility.Vec2i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class BlockOTests {

    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(15,10));
        testMap();
        testTile();
        testPath();
    }

    //TODO: Proper Neighbor Testing
    public static void testMap() {
        GameMap map = GameMap.getInstance();

        //Test basic iterator function
        Iterator<Tile> itr = map.getIterator();
        int iii = 0;
        while(itr.hasNext()) {
            itr.next();
            iii++;
        }
        assertEquals(150, iii);
        System.out.printf("Map: Basic Iterator funtionality test passed.\n");

        //Test iterator compliance
        itr = map.getIterator();
        Vec2i match = new Vec2i();
        while(itr.hasNext()) {
            assertTrue(match.equals(itr.next().getPos().getVector()));
            match.x++;
            if(match.x == 10) {
                match.x = 0;
                match.y++;
            }
        }
        System.out.printf("Map: Iterator compliance test passed.\n");

        //Test GetTile compliance
        for(match.x = 0; match.x < 10; match.x++) {
            for(match.y = 0; match.y < 10; match.y++) {
                assertTrue(match.equals(map.getTile(match.x, match.y).getPos().getVector()));
                assertTrue(match.equals(map.getTile(match).getPos().getVector()));
                assertTrue(match.equals(map.getTile(new MapCoordinate(match)).getPos().getVector()));
            }
        }
        System.out.printf("Map: GetTile compliance test passed.\n");

        List<Tile> tt = map.getAllNeighbors(new Vec2i(5,5), 2);
        for(Tile ttt : tt) {
            String pos = ttt.getPos().getVector().x + " " + ttt.getPos().getVector().y;
            System.out.printf(pos + "\n");
        }

    }

    public static void testTile() {
        Tile t = Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(3,3));

        //Test basic Tile compliance
        assertEquals(t.getName(), GameLibrary.TileType.GRASS.name);
        assertEquals(t.getMovementCost(), GameLibrary.TileType.GRASS.movementCost);
        assertTrue(t.getPos().getVector().equals(new Vec2i(3,3)));
        assertEquals(t.isImpassable(), GameLibrary.TileType.GRASS.impassable);
        System.out.printf("Basic Tile compliance test passed.\n");

        //Test add, get, and remove functionality on singular entity
        Entity e1 = new MeleeSoldier(1, new MapCoordinate(1,1), null);
        t.addEntity(e1);
        Entity[] expectedAr = {e1};
        Entity[] testAr = t.getOccupyingEntities();
        assertEquals(expectedAr[0], testAr[0]);
        MapCoordinate expected = new MapCoordinate(3,3);
        assertTrue(expected.equals(testAr[0].getLocation()));
        t.removeEntity(e1);
        assertTrue(t.getOccupyingEntities().length == 0);
        System.out.printf("Tile: Singular Entity add/get/remove compliance test passed.\n");

        //Test add, get, and remove functionality on multiple entities
        Entity e2 = new RangeSoldier(2, new MapCoordinate(1,1), null);
        ArrayList<Unit> chunk = new ArrayList<Unit>();
        chunk.add(new ExplorerUnit(3, new MapCoordinate(1,1), null));
        chunk.add(new ExplorerUnit(4, new MapCoordinate(1,1), null));
        t.addEntity(e1);
        t.addEntity(e2);
        t.addArmyUnits(chunk);
        testAr = t.getOccupyingEntities();
        ArrayList<Entity> testList = new ArrayList<Entity>(Arrays.asList(testAr));
        assertTrue(testList.contains(e1));
        assertTrue(testList.contains(e2));
        assertTrue(testList.contains(chunk.get(0)));
        assertTrue(testList.contains(chunk.get(1)));
        t.removeArmyUnits(chunk);
        testAr = t.getOccupyingEntities();
        testList = new ArrayList<Entity>(Arrays.asList(testAr));
        assertFalse(testList.contains(chunk.get(0)));
        assertFalse(testList.contains(chunk.get(1)));
        assertFalse(testAr.length == 0);
        System.out.printf("Tile: Multiple Entity add/get/remove compliance test passed.\n");
    }

    public static void testPath() {
        PathFinder finder = new AStarPathFinder();
        Path path = finder.createPath(new MapCoordinate(0,0), new MapCoordinate(9,9));
        MapCoordinate pos = new MapCoordinate(0,0);
        while(!path.isEnd()) {
            pos = GameMap.getInstance().getNeighborTile(pos,path.next()).getPos();
            System.out.printf(pos.getRow() + " " + pos.getColumn() + "\n");
        }
    }
}
