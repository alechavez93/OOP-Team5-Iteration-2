package Player;

import Entity.Entity;
import Technology.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 02/19/2017.
 */

/*--------------------------------------------------------------------------------------
|    TechManager Module: Created by Thomas on 02/19/2017.
|---------------------------------------------------------------------------------------
|   Description: Used to keep track of completed Technologies for each Player
|
---------------------------------------------------------------------------------------*/

public class TechManager {
    public Player playerOwner;
    private List<Technology> unitTech;
    private List<Technology> structureTech;
    private List<Technology> armyTech;
    private List<Technology> workerTech;

    public TechManager(Player playerOwner){
        this.playerOwner = playerOwner;
        this.unitTech = new ArrayList<Technology>();
        this.structureTech = new ArrayList<Technology>();
        this.armyTech = new ArrayList<Technology>();
        this.workerTech = new ArrayList<Technology>();
    }

    public void finishTurn(){

    }

    public List<Technology> getAllTech(){
        List<Technology> totalList = new ArrayList<Technology>();
        totalList.addAll(unitTech);
        totalList.addAll(structureTech);
        totalList.addAll(armyTech);
        totalList.addAll(workerTech);
        return totalList;
    }

    public void addUnitTech(Technology unitTech){

    }
}
