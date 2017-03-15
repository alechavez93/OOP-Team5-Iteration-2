package Entity.Army;

/*--------------------------------------------------------------------------------------
|    RallyPoint Class: Created by Tonny Xie on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Commands.Command;
import Entity.Entity;
import Entity.Structure.Structure;
import Entity.Worker;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RallyPoint {
    private EntityManager entityManager;
    private MapCoordinate location;
    private Worker worker;
    private List<Command> commandList;

    public RallyPoint(MapCoordinate location, EntityManager entityManager) {
        this.location = location;
        this.worker = new Worker(0);
        this.commandList = new ArrayList<>();
        this.entityManager = entityManager;
    }

    public void pickupWorker(Structure source, int workerCount) {
        if (workerCount <= source.getWorkers().getNumberOfWorkers()) {
            worker.incrementNumberOfWorkers(workerCount);
            source.getWorkers().decrementNumberOfWorkers(workerCount);
        }
        else {
            System.out.println("Not enough workers to pickup");
        }
    }

    public void dropoffWorker(Structure destination, int workerCount) {
        if (workerCount <= worker.getNumberOfWorkers()) {
            destination.getWorkers().incrementNumberOfWorkers(workerCount);
            worker.decrementNumberOfWorkers(workerCount);
        }
        else {
            System.out.println("Not enough workers to dropoff");
        }
    }

    public void build(Structure structureType, int workerCount, MapCoordinate location) {

    }

    public void addCommand(Command command){
        commandList.add(command);
    }

    public MapCoordinate getLocation() { return location; }
    public Worker getWorker() { return worker; }

    public void setLocation(MapCoordinate location) { this.location = location; }
    public void setWorker(Worker worker) { this.worker = worker; }
    public EntityManager getEntityManager(){ return entityManager;

    public void processQueue(){
        if (!commandList.isEmpty()) {
            commandList.get(0).execute();
            if (commandList.get(0).isFinished() == true) {
                commandList.remove(0);
            }
        }
    }

}
