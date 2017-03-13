package GameMap;

import Utility.Vec2i;
import Entity.Entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CustomerPC on 3/8/2017.
 */

/*--------------------------------------------------------------------------------------

|    FogOfWar Class: Created by CustomerPC on 3/8/2017.

|---------------------------------------------------------------------------------------

|   Description:

|

---------------------------------------------------------------------------------------*/

public class FogOfWar {

    private Visibility[][] visMatrix;
    private Vec2i size;

    public FogOfWar() {
        Vec2i inv = GameMap.getInstance().getSize();
        this.size = new Vec2i(inv.y, inv.x); //don't ask
        visMatrix = new Visibility[size.x][size.y];
        for(int iii = 0; iii < size.x; iii++) {
            for(int jjj=0; jjj < size.y; jjj++) {
                visMatrix[iii][jjj] = new Visibility(new MapCoordinate(iii, jjj));
            }
        }
    }

    public void calculateVisibility(List<Entity> entityList) {
        boolean[][] vis = new boolean[size.x][size.y];

        for(Entity e : entityList) {
            List<Tile> t = GameMap.getInstance().getAllNeighbors(e.getLocation().getVector(), e.getRangeRadius());
            for(Tile tt : t) {
                vis[tt.getPos().getRow()][tt.getPos().getColumn()] = true;
            }
            vis[e.getLocation().getRow()][e.getLocation().getColumn()] = true; //For the occupying tile
        }

        for(int iii = 0; iii < size.x; iii++) {
            for(int jjj = 0; jjj < size.y; jjj++) {
                if(vis[iii][jjj]) {
                    visMatrix[iii][jjj].see();
                } else {
                    visMatrix[iii][jjj].unsee();
                }
            }
        }
    }

    //This returns reference and is modifiable, but also don't have to copy a huge matrix
    public Visibility[][] getVisibilityMatrix() {
        return visMatrix;
    }

    //No assumptions made about order
    public List<Visibility> getVisibilityAsList() {
        List l = new ArrayList<Visibility>(size.x * size.y);
        for(Visibility[] v : visMatrix)
            l.addAll(Arrays.asList(v));
        return l;
    }
}