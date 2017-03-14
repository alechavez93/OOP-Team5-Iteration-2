package Entity.Army;

/*--------------------------------------------------------------------------------------
|    RallyPoint Class: Created by Tonny Xie on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Commands.Command;
import Entity.Structure.Structure;
import Entity.Worker;
import GameMap.MapCoordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RallyPoint {

    private MapCoordinate location;
    private Worker worker;
    private List<Command> commandList;

    public RallyPoint(MapCoordinate location) {
        this.location = location;
        this.worker = new Worker(0);
        this.commandList = new ArrayList<>();
    }

    public void pickupWorker(Structure source, int workerCount) {
        if (workerCount <= source.getWorkers().getNumberOfWorkers()) {
            worker.setNumberOfWorkers(workerCount);
        }
        System.out.println("Not enough workers to pickup");
    }

    public void dropoffWorker(Structure destination, int workerCount) {
        if (workerCount <= worker.getNumberOfWorkers()) {
            destination.getWorkers().setNumberOfWorkers(workerCount);
        }
        System.out.println("Not enough workers to dropoff");
    }

    public void build(Structure structureType, int workerCount, MapCoordinate location) {

    }

    public MapCoordinate getLocation() { return location; }
    public Worker getWorker() { return worker; }

    public void setLocation(MapCoordinate location) { this.location = location; }
    public void setWorker(Worker worker) { this.worker = worker; }
}
