package Utilities;
/*--------------------------------------------------------------------------------------
|	GraphicsFactory Class: Created by Alejandro Chavez on 2/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Singleton class that loads all graphics needed to display a decent
|   Game interface and map.
---------------------------------------------------------------------------------------*/


import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


public class GraphicsFactory {

    //Supported Graphics (Can be called statically)
    public static String GRASS = "grass.jpg", MOUNTAIN = "mountain.jpg", WATER = "water.jpg", SAND = "sand.jpg";
    public static String[] TEXTURES = new String[]{GRASS, MOUNTAIN, WATER, SAND};
    //---------------------------------------------------------------

    private Map<String, BufferedImage> cachedGraphics;
    private static GraphicsFactory instance;

    private GraphicsFactory(){
        cachedGraphics = new HashMap<>();
        //Load all graphics
        for(String texture : TEXTURES){
            loadTileResource(texture);
        }
    }

    //Public Accessors
    public static GraphicsFactory getInstance(){
        if(instance == null){
            instance = new GraphicsFactory();
        }
        return instance;
    }

    public BufferedImage getTileTexture(String name){
        return cachedGraphics.get(name);
    }

    //Helper Functions
    private void loadTileResource(String imgName){
        System.out.println(imgName);
        BufferedImage texture = ImageUtil.loadImage(imgName);
        ImageUtil.resizeToTileSize(texture);
        cachedGraphics.put(imgName, texture);
    }
}
