package Entity;

/*--------------------------------------------------------------------------------------
|    Worker Class: Created by Tonny Xie on 2/18/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

public class Worker {

    int numberOfWorkers;

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
}
