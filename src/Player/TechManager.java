package Player;

import Entity.Entity;
import Technology.*;
import Technology.EntityTechnology.ExplorerTechnology;
import Technology.EntityTechnology.MeleeTechnology;
import Technology.EntityTechnology.RangeTechnology;
import Technology.StructureTechnology.*;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    private List<Technology> explorerTech;
    private List<Technology> meleeTech;
    private List<Technology> rangeTech;
    private List<Technology> workerTech;
    private List<Technology> farmTech;
    private List<Technology> fortTech;
    private List<Technology> mineTech;
    private List<Technology> observationTech;
    private List<Technology> powerTech;
    private Queue<Technology> finishTech;

    public TechManager(Player playerOwner){
        this.playerOwner = playerOwner;
        this.explorerTech = new ArrayList<Technology>();
        this.meleeTech = new ArrayList<Technology>();
        this.rangeTech = new ArrayList<Technology>();
        this.workerTech = new ArrayList<Technology>();
        this.farmTech = new ArrayList<Technology>();
        this.fortTech = new ArrayList<Technology>();
        this.mineTech = new ArrayList<Technology>();
        this.observationTech = new ArrayList<Technology>();
        this.powerTech = new ArrayList<Technology>();
    }

    public void finishTurn(){
        while (!finishTech.isEmpty()){
            Technology technology = finishTech.remove();
            playerOwner.getEntityManager().accept(technology);
            this.completeTech(technology);
        }
    }

    private void completeTech(Technology technology) {
    }

    public List<Technology> getAllTech(){
        List<Technology> totalList = new ArrayList<Technology>();
        totalList.addAll(explorerTech);
        totalList.addAll(meleeTech);
        totalList.addAll(workerTech);
        return totalList;
    }

    public void completeTech(ExplorerTechnology tech){
        explorerTech.add(tech);
    }

    public void completeTech(MeleeTechnology tech){
        meleeTech.add(tech);
    }

    public void completeTech(RangeTechnology tech){
        rangeTech.add(tech);
    }

    public void completeTech(FarmTechnology tech){
        farmTech.add(tech);
    }

    public void completeTech(FortTechnology tech){
        fortTech.add(tech);
    }

    public void completeTech(MineTechnology tech){
        mineTech.add(tech);
    }

    public void completeTech(ObservationTechnology tech){
        observationTech.add(tech);
    }

    public void completeTech(PowerTechnology tech){
        powerTech.add(tech);
    }

    public void addTech(Technology technology){
        finishTech.add(technology);
    }
}
