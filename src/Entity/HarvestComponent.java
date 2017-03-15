package Entity;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.GameMap;
import GameMap.MapCoordinate;

import java.util.List;

/**
 * Created by Customer-PC on 3/14/2017.
 */
public class HarvestComponent {
    private int radius;
    private int density;
    private MapCoordinate center;

    private GameLibrary.HarvestType type;
    private List<WorkGroup> workGroups;

    private class WorkGroup {
        public int workers;
        public MapCoordinate location;

        public WorkGroup(int w, MapCoordinate loc) {
            this.workers = w;
            this.location = loc;
        }
    }

    public HarvestComponent(int radius, int density, MapCoordinate center, GameLibrary.HarvestType type) {
        this.type = type;
        this.radius = radius;
        this.density = density;
        this.center = center;
    }

    public boolean isValidPosition( MapCoordinate loc) {
        return !(GameMap.distanceTo(loc, center) > radius);
    }

    //Returns difference in workers
    public int setWorkersAt(MapCoordinate loc, int workerCount) {
        if(!isValidPosition(loc))
            throw new IllegalStateException("Invalid Location");

        int difference;
        WorkGroup group = null;
        for(WorkGroup w: workGroups) {
            if(w.location.equals(loc)) {
                group = w;
                break;
            }
        }
        if(group == null && workerCount > 0) {
            group = new WorkGroup(workerCount, loc);
            workGroups.add(group);
        } else if(workerCount == 0) {
            workGroups.remove(group);
        } else {
            group.workers = workerCount;
        }
        return 0;
    }

}
