package MapTests;
import Entity.Army.Army;
import Entity.Unit.*;
import Entity.*;
import GameLibrary.GameLibrary;
import GameMap.*;
import Player.EntityManager;
import Utility.Direction;
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
        //testAoE();
        //testPath();
        testFog();
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

        List<Tile> tt = map.getAllNeighbors(new Vec2i(5,5), 1);
        for(Tile ttt : tt) {
            String pos = ttt.getPos().getVector().y + " " + ttt.getPos().getVector().x;
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
        System.out.printf("\n");
        while(!path.isEnd()) {
            pos = GameMap.getInstance().getNeighborTile(pos,path.next()).getPos();
            System.out.printf(pos.getRow() + " " + pos.getColumn() + "\n");
        }

        EntityManager em = new EntityManager(null);
        Unit x = new RangeSoldier(0, new MapCoordinate(3,3), em);
        Army a = new Army(0, new MapCoordinate(3,3), em, x);
        a.moveRallypoint(new MapCoordinate(7,7));
        a.addReinforcement(new MeleeSoldier(1, new MapCoordinate(9,9), em));
        System.out.printf("\n" + a.getLocation().getColumn() + " " + a.getLocation().getRow() + "\n");
        a.processMovement();
        System.out.printf(a.getLocation().getColumn() + " " + a.getLocation().getRow() + "\n");
        a.processMovement();
        System.out.printf(a.getLocation().getColumn() + " " + a.getLocation().getRow() + "\n");
        a.processMovement();
        System.out.printf(a.getLocation().getColumn() + " " + a.getLocation().getRow() + "\n");
        a.processMovement();
        System.out.printf(a.getLocation().getColumn() + " " + a.getLocation().getRow() + "\n");
        a.processMovement();
        System.out.printf(a.getLocation().getColumn() + " " + a.getLocation().getRow() + "\n");
    }

    public static void testFog() {
        FogOfWar fog = new FogOfWar();
        List<Entity> list = new ArrayList<Entity>(2);
        list.add(new MeleeSoldier(3, new MapCoordinate(1,1), null));
        list.add(new MeleeSoldier(3, new MapCoordinate(5,5), null));
        fog.calculateVisibility(list);
        Visibility[][] vis = fog.getVisibilityMatrix();
    }

    public static void testAoE() {
        AreaEffect a = new AreaEffect(new MapCoordinate(5,5), 2, new DamageEffect(5));
        RangeSoldier x = new RangeSoldier(0, new MapCoordinate(2,2), new EntityManager(null));
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.SouthEast);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.SouthEast);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.SouthEast);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.SouthEast);
        System.out.printf(x.getCurrentHealth() + "\n");
        a.deconstruct();
        System.out.printf("\n");
        a = new AreaEffect(new MapCoordinate(5,5), 3, new HealEffect(3));
        GameMap.getInstance().shiftEntity(x, Direction.NorthWest);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.NorthWest);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.NorthWest);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.NorthWest);
        System.out.printf(x.getCurrentHealth() + "\n");
        GameMap.getInstance().shiftEntity(x, Direction.NorthWest);
        System.out.printf(x.getCurrentHealth() + "\n");
    }
}
