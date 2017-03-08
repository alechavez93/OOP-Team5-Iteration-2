package Views;
/*--------------------------------------------------------------------------------------
|	MapView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameLibrary.GameLibrary;
import GameMap.GameMap;
import GameMap.Tile;
import Utility.Vec2i;
import Views.Drawers.TileDrawer;

import java.awt.*;

public class MapView extends View{

    public MapView(String name){
        setName(name);
        setBackground(new Color(255,255,255));
    }

    @Override
    public void paint(Graphics g) {
        TileDrawer.drawTile(g, Tile.makeTile(GameLibrary.TileType.GRASS, new Vec2i(3,3)));
    }
}
