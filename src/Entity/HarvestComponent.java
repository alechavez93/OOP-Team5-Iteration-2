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
    private MapCoordinate center;
    private Worker workerRef;

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

    public HarvestComponent(Worker workerRef, MapCoordinate center, GameLibrary.HarvestType type) {
        this.workerRef = workerRef;
        this.type = type;
        this.center = center;
    }

    public boolean isValidPosition( MapCoordinate loc) {
        return !(GameMap.distanceTo(loc, center) > workerRef.radius);
    }

    //Returns difference in workers
    public int setWorkersAt(MapCoordinate loc, int workerCount) {
        if(!isValidPosition(loc))
            throw new IllegalStateException("Invalid Location");
        if(workerCount > workerRef.density)
            workerCount = workerRef.density;
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
            return -workerCount;
        } else if(workerCount == 0) {
            workGroups.remove(group);
            return group.workers;
        } else {
            int diff = workerCount - group.workers;
            group.workers = workerCount;
            return diff;
        }
    }

    public int harvest() {
        return 0;
    }
}
