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
    public int radius;
    public int density;

    public Worker(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
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
        radius++;
    }

    public void upgradeDensity() {
        density++;
    }
}
