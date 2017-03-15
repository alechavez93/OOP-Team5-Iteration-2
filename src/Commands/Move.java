package Commands;
/*--------------------------------------------------------------------------------------
|	Move Class: Created by Alejandro Chavez on 3/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Makes an Entity Move.
---------------------------------------------------------------------------------------*/

import Entity.*;
import GameLibrary.GameLibrary;
import GameMap.*;
import Player.*;

import java.util.List;

public class Move extends Command{
    private List<Tile> path;
    private Fog playerFog;
    private int moveAdvancement;

    public Move(Entity affected, List<Tile> path, Fog playerFog){
        super(GameLibrary.MOVE, affected);
        moveAdvancement = 0;
        this.path = path;
        this.playerFog = playerFog;
    }

    @Override
    public void execute() {
        GameMap map = GameMap.getInstance();
        Tile nextTile = path.get(0);
        if(affected.getMovement() >= nextTile.getMovementCost()){
            Tile current = map.getTile(affected.getLocation());
            current.removeEntity(affected);
            nextTile.addEntity(affected);
            affected.setLocation(nextTile.getPos());
            path.remove(0);
        }
        if(path.size()==0)
            isFinished = true;
    }

    private void updateVisibleStates(){
        //Implementation here
    }
}
