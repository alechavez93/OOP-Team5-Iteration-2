package Views;
/*--------------------------------------------------------------------------------------
|	UnitView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/


import Entity.Unit.Soldier.RangeSoldier;
import Entity.Unit.Unit;
import GameMap.MapCoordinate;
import Player.EntityManager;
import Player.Player;
import Views.Drawers.UnitDrawer;
import java.awt.*;

public class UnitView extends View{

    public UnitView(String name){
        setName(name);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        EntityManager em = new EntityManager(new Player(0, new MapCoordinate(3,3) ));
        Unit ranged = new RangeSoldier(0, new MapCoordinate(3,3), em);
        UnitDrawer.drawUnit(g, ranged);
    }
}