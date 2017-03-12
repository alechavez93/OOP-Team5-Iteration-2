package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	RowDrawer Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import GameMap.Tile;

import java.awt.*;
import java.util.List;

public class RowDrawer {

    public static void drawRow(Graphics g, List<Tile> row){
        for(Tile tile: row){
            TileDrawer.drawTile(g, tile);
        }
    }
}
