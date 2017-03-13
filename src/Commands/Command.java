package Commands;
/*--------------------------------------------------------------------------------------
|	Command Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Base class for all types of commands. Contains the basic functionality
|   to execute, queue, create, and check for command termination.
---------------------------------------------------------------------------------------*/

import Entity.Entity;

public abstract class Command {
    protected String name;
    protected Entity affected;
    protected boolean isFinished;

    public Command(String name, Entity affected) {
        this.name = name;
        this.affected = affected;
        affected.addCommand(this);
    }

    public String getName() {
        return name;
    }

    public boolean isFinished(){
        return isFinished;
    }

    //Abstract functionality that all other commands must implement
    public abstract void execute();
}
