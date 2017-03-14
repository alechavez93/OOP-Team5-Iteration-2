package Views;
/*--------------------------------------------------------------------------------------
|	ViewPort Class: Created by Alejandro Chavez on 2/23/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls what part of the map is shows at a given moment. Can be changed
|   around to discover the whole map.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Structure.Structure;
import Entity.Unit.Unit;
import GameMap.GameMap;
import Views.Drawers.StructureDrawer;
import Views.Drawers.TileDrawer;
import Views.Drawers.UnitDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import GameMap.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class ViewPort extends JPanel{
    private PixelPoint origin;
    private GameMap map;
    private int mapPixelWidth, mapPixelHeight;
    private static ViewPort instance;
    public static final int VIEWPORT_WIDTH = PixelMap.SCREEN_WIDTH, VIEWPORT_HEIGHT = (int)(0.75*(double)PixelMap.SCREEN_HEIGHT);

    private ViewPort(PixelPoint origin){
        setLayout(null);
        this.origin = origin;
        map = GameMap.getInstance();
        mapPixelWidth = map.getSize().x * PixelMap.TILE_WIDTH;
        mapPixelHeight = map.getSize().y * PixelMap.TILE_HEIGHT;
        setBounds(0,0,VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    }

    public void setOrigin(int newX, int newY){
        if(newX < 0 || newY < 0 ){
            System.out.println("Error, Viewport's origin is cannot be under bounds [x<0 or y<0]");
            return;
        }
        if(newX > mapPixelWidth - VIEWPORT_WIDTH || newY > mapPixelHeight - VIEWPORT_HEIGHT){
            System.out.println("Error, Viewport's origin is cannot be over bounds [x>"+(mapPixelWidth-VIEWPORT_WIDTH)+"or y<"+(mapPixelHeight-VIEWPORT_HEIGHT)+"]");
            return;
        }
        origin.x = newX;
        origin.y = newY;
    }

    public PixelPoint getOrigin(){
        return origin.getCopy();
    }

    public static void initialize(PixelPoint origin){
        instance = new ViewPort(origin);
    }

    public static ViewPort getInstance(){
        if(instance == null){
            System.out.println("Error, please initialize the Viewport statically");
            return null;
        }
        return instance;
    }


    public void paintLayerOne(Graphics g){
        for(Iterator iter = map.getIterator(); iter.hasNext();){
            Tile tile = (Tile) iter.next();
            TileDrawer.drawTile(g, tile);
            for(Entity e : tile.getOccupyingEntities()){
                if( e instanceof Unit)
                    UnitDrawer.drawUnit(g, (Unit)e);
                else if(e instanceof Structure)
                    StructureDrawer.drawStructure(g, (Structure)e);
            }
        }
    }

    public void paintViewPort(Graphics g){
        paintLayerOne(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        paintViewPort(g);
    }
}
