package Views;
/*--------------------------------------------------------------------------------------
|	ViewPort Class: Created by Alejandro Chavez on 2/23/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls what part of the map is shows at a given moment. Can be changed
|   around to discover the whole map.
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Structure.Structure;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import Entity.Unit.Unit;
import Game.CyclingState;
import GameMap.GameMap;
import Utility.GraphicsFactory;
import Utility.Vec2i;
import Views.Drawers.StructureDrawer;
import Views.Drawers.TileDrawer;
import Views.Drawers.UnitDrawer;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import GameMap.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class ViewPort extends JPanel{
    private PixelPoint origin;
    private GameMap map;
    private int mapPixelWidth, mapPixelHeight;
    private static ViewPort instance;
    private CyclingState state;
    public static Vec2i scroller = new Vec2i();
    public static final int VIEWPORT_WIDTH = PixelMap.SCREEN_WIDTH, VIEWPORT_HEIGHT = (int)(0.75*(double)PixelMap.SCREEN_HEIGHT);

    private ViewPort(PixelPoint origin, CyclingState state){
        setLayout(null);
        this.origin = origin;
        map = GameMap.getInstance();
        mapPixelWidth = map.getSize().x * PixelMap.TILE_WIDTH;
        mapPixelHeight = map.getSize().y * PixelMap.TILE_HEIGHT;
        setBounds(0,0,VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        this.state = state;
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

    public static void initialize(PixelPoint origin, CyclingState state){
        instance = new ViewPort(origin, state);
    }

    public static ViewPort getInstance(){
        if(instance == null){
            System.out.println("Error, please initialize the Viewport statically");
            return null;
        }
        return instance;
    }


    //Drawing Tiles
    public void paintLayerOne(Graphics g){
        for(Iterator iter = map.getIterator(); iter.hasNext();){
            Tile tile = (Tile) iter.next();
            TileDrawer.drawTile(g, tile);
//            TileDrawer.drawResources(g, tile);
        }
    }

    public void paintLayerTwo(Graphics g){
        FogOfWar fogOfWar = state.inTurn.getFogOfWar();
        for(Iterator iter = map.getIterator(); iter.hasNext();){
            Tile tile = (Tile) iter.next();
            Visibility visibility = fogOfWar.getVisibiltyAt(tile.getPos());
            if(visibility.isShrouded()){
                TileDrawer.drawShrouded(g, tile);
            }
            else if(visibility.isExplored()){
                TileDrawer.drawExplored(g, tile);
                for(Entity e : tile.getOccupyingEntities()){
                    if(e instanceof Structure)
                        StructureDrawer.drawStructure(g, (Structure)e);
                }
            }
            else if(visibility.isVisible()){
//                TileDrawer.drawResources(g, tile);
                for(Entity e : tile.getOccupyingEntities()){
                    if( e instanceof Unit)
                        UnitDrawer.drawUnit(g, (Unit)e);
                    else if(e instanceof Structure)
                        StructureDrawer.drawStructure(g, (Structure)e);
                }
            }
        }
    }

    public void paintLayerThree(Graphics g){
        TileDrawer.drawMarkers(g, state);
    }

    public void drawVisible(){

    }

    public void paintViewPort(Graphics g){
        paintLayerOne(g);
        paintLayerTwo(g);
        paintLayerThree(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.translate(-scroller.x, -scroller.y);
        paintViewPort(g);
    }
}
