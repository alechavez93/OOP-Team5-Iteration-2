package Views;
/*--------------------------------------------------------------------------------------
|	TileDrawer Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Class is in charge of drawing Tiles given a Graphics object and the
|   desired Tile. TileDrawer draws the Tile grid lines, the texture background, and
|   the inner Entities if desired (by using an Entity Drawer).
---------------------------------------------------------------------------------------*/


import GameMap.Tile;
import Utility.GraphicsFactory;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TileDrawer {

    public static void drawTile(Graphics g, Tile tile){
        //Set Stroke
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        //Draw Layers
        PixelPoint center = PixelMap.mapCoordinate(tile.getPos());
        Polygon tileShape = getHexagon(center);

        drawTexture(g, tileShape, center, tile.getTileType().graphicName);
        drawGrid(g, tileShape);
    }

    //Gets corner points for a Hexatile
    private static List<PixelPoint> getHexatilePoints(PixelPoint center){
        List<PixelPoint> points = new ArrayList<>();
        //Top-Left point
        points.add(new PixelPoint(center.x - PixelMap.TILE_WIDTH/2, center.y - PixelMap.TILE_HEIGHT/2));
        //Left point
        points.add(new PixelPoint(center.x - PixelMap.TILE_WIDTH, center.y));
        //Bottom-Left point
        points.add(new PixelPoint(center.x - PixelMap.TILE_WIDTH/2, center.y + PixelMap.TILE_HEIGHT/2));
        //Bottom-Right point
        points.add(new PixelPoint(center.x + PixelMap.TILE_WIDTH/2, center.y + PixelMap.TILE_HEIGHT/2));
        //Right point
        points.add(new PixelPoint(center.x + PixelMap.TILE_WIDTH, center.y));
        //Top-Right point
        points.add(new PixelPoint(center.x + PixelMap.TILE_WIDTH/2, center.y - PixelMap.TILE_HEIGHT/2));
        return points;
    }


    //Returns the Hexagon formed by the joining the corner points
    public static Polygon getHexagon(PixelPoint center){
        Polygon polygon = new Polygon();
        for(PixelPoint point: getHexatilePoints(center)){
            polygon.addPoint(point.x, point.y);
        }
        return polygon;
    }

    //Assumes a Tile proportions center point
    public static Polygon getHexagon(){
        Polygon polygon = new Polygon();
        for(PixelPoint point: getHexatilePoints(new PixelPoint(PixelMap.TILE_FULL_WIDTH/2, PixelMap.TILE_HEIGHT/2))){
            polygon.addPoint(point.x, point.y);
        }
        return polygon;
    }


    //Draws the Grid between a set of points
    private static void drawGrid(Graphics g, Polygon tileShape){
        g.setColor(new Color(0, 0, 0));
        g.drawPolygon(tileShape);
    }


    //Draws the texture or terrain of a Tile
    private static void drawTexture(Graphics g, Polygon tileShape, PixelPoint center, String texture){
        g.setClip(tileShape);
        g.drawImage(GraphicsFactory.getInstance().getTileTexture(texture), center.x-PixelMap.TILE_WIDTH, center.y-PixelMap.TILE_HEIGHT/2, 2*PixelMap.TILE_WIDTH, PixelMap.TILE_HEIGHT, null);
    }
}
