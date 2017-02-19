package MapTests;
import Map.*;
import Utility.*;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlockOTests {
    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(10,10));
        testMap();

        /*
        Tile[] t = GameMap.getInstance().getAllNeighbors(new Vec2i(3,3));
        for(Tile tt : t) {
            System.out.printf(" " + tt.getPos().getColumn() + " " + tt.getPos().getRow() + "\n");
        }
        */
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
        assertEquals(100, iii);

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

        //Test GetTile compliance
        for(match.x = 0; match.x < 10; match.x++) {
            for(match.y = 0; match.y < 10; match.y++) {
                assertTrue(match.equals(map.getTile(match.x, match.y).getPos().getVector()));
                assertTrue(match.equals(map.getTile(match).getPos().getVector()));
                assertTrue(match.equals(map.getTile(new MapCoordinate(match)).getPos().getVector()));
            }
        }
    }
}