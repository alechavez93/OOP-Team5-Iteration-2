package Entity;

/*--------------------------------------------------------------------------------------
|    Worker Class: Created by Tonny Xie on 2/18/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Technology.StructureTechnology.WorkerTechnology;

public class Worker {

    private int numberOfWorkers;

    public Worker(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
        System.out.println("Worker Count: " + getNumberOfWorkers());
    }

    public void incrementNumberOfWorkers(int numberOfWorkers) {
        setNumberOfWorkers(getNumberOfWorkers() + numberOfWorkers);
    }

    public void decrementNumberOfWorkers(int numberOfWorkers) {
        setNumberOfWorkers(getNumberOfWorkers() - numberOfWorkers);
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public void accept(WorkerTechnology technology){
        technology.visit(this);
    }

    public void upgradeRadius() {

    }

    public void upgradeDensity() {

    }
}
