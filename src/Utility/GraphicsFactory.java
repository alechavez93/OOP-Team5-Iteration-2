package Utility;
/*--------------------------------------------------------------------------------------
|	GraphicsFactory Class: Created by Alejandro Chavez on 2/14/2017.
|---------------------------------------------------------------------------------------
|   Description: Singleton class that loads all graphics needed to display a decent
|   Game interface and map.
---------------------------------------------------------------------------------------*/


import GameLibrary.GameLibrary;
import Views.PixelMaps.PixelMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class GraphicsFactory {

    //Supported Graphics (Can be called statically)
    public static final String GRASS = "grass.jpg", MOUNTAIN = "mountain.jpg", WATER = "water2.jpg", SAND = "sand.jpg", JUNGLE = "grass2.jpg";
    public static final String[] TEXTURES = new String[]{GRASS, MOUNTAIN, WATER, SAND, JUNGLE};

    //Structure graphics
    public static final String CAPITAL_SRC = "capital2.png", FARM_SRC = "farm.png", FORT_SRC = "fort2.png", MINE_SRC = "mine2.png", PLANT_SRC = "plant.png", TOWER_SRC = "tower.png", UNIVERSITY_SRC = "university2.png";

    //Unit sources
    public static final String ARMY_SRC = "army.png", COLONIST_SRC = "colonist.png", EXPLORER_SRC = "explorer.png", MELEE_SRC = "melee.png", RANGED_SRC = "ranged.png", WORKER_SRC = "worker.png", BODY_SRC = "dead.png";

    //Icons and separators
    public static final String MAP_SEPARATOR = "map-separator.png", ATTACK_ICON = "icons/attack.png", DEFENSE_ICON = "icons/defense.png", ARMOR_ICON = "icons/armor.png", MOVEMENT_ICON = "icons/movement.png", HEALTH_ICON = "icons/health.png", RANGE_ICON = "icons/range.png", VISION_ICON = "icons/vision.png", UPKEEP_ICON = "icons/upkeep.png";
    public static final String FOOD_ICON = "icons/meat.png", ENERGY_ICON = "icons/energy.png", ORE_ICON = "icons/ore.png", PLAYER_ICON = "icons/player.png", MODE_ICON = "icons/mode.png", TYPE_ICON = "icons/type.png", ID_ICON = "icons/id.png", COMMAND_ICON = "icons/command.png";
    public static String[] icons = {ATTACK_ICON, DEFENSE_ICON, ARMOR_ICON, MOVEMENT_ICON, HEALTH_ICON, RANGE_ICON, VISION_ICON, UPKEEP_ICON, FOOD_ICON, ENERGY_ICON, ORE_ICON, PLAYER_ICON, MODE_ICON, TYPE_ICON, ID_ICON, COMMAND_ICON};

    public static final String BACKGROUND_SRC = "background.jpg";
    //-------------------------------------------------------------------------------------------

    private Map<String, BufferedImage> cachedGraphics;
    private static GraphicsFactory instance;

    private GraphicsFactory(){
        cachedGraphics = new HashMap<>();

        //Load textures
        for(String texture : TEXTURES){
            loadTileResource(texture);
        }

        //Load structures
        for (Iterator i = GameLibrary.structMap.entrySet().iterator(); i.hasNext();){
            Map.Entry pair = (Map.Entry) i.next();
            loadStructureResource((String)pair.getKey());
            i.remove();
        }

        //Load Units
        for (Iterator i = GameLibrary.unitMap.entrySet().iterator(); i.hasNext();){
            Map.Entry pair = (Map.Entry) i.next();
            loadUnitResources((String)pair.getKey());
            i.remove();
        }

        //Load icons
        for(String iconSrc: icons){
            BufferedImage icon = ImageUtil.loadImage(iconSrc);
            icon = ImageUtil.toBufferedImage(icon.getScaledInstance(PixelMap.ICON_SIZE, PixelMap.ICON_SIZE, Image.SCALE_SMOOTH));
            cachedGraphics.put(iconSrc, icon);
        }

        //Load background
        BufferedImage icon = ImageUtil.loadImage(BACKGROUND_SRC);
        cachedGraphics.put(BACKGROUND_SRC, icon);
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

    public BufferedImage getStructure(String name){
        if(Arrays.asList(GameLibrary.STRUCTURES).contains(name)){
            return cachedGraphics.get(name);
        }throw new RuntimeException("Error, structure name is not valid. For valid structure names check GameLibrary.");
    }

    public BufferedImage getUnit(String name){
        if(Arrays.asList(GameLibrary.UNITS).contains(name)){
            return cachedGraphics.get(name);
        }throw new RuntimeException("Error, unit name is not valid. For valid unit names check GameLibrary.");
    }

    public BufferedImage getGraphics(String name){
        return cachedGraphics.get(name);
    }

    //Helper Functions
    private void loadTileResource(String imgName){
        BufferedImage texture = ImageUtil.loadImage(imgName);
        texture.getScaledInstance(PixelMap.TILE_FULL_WIDTH, PixelMap.TILE_HEIGHT, Image.SCALE_DEFAULT);
        cachedGraphics.put(imgName, texture);
    }

    private void loadStructureResource(String key){
        BufferedImage structure = ImageUtil.loadImage(GameLibrary.structMap.get(key));
        structure = ImageUtil.toBufferedImage(structure.getScaledInstance(-1, PixelMap.STRUCTURE_HEIGHT, Image.SCALE_SMOOTH));
        cachedGraphics.put(key, structure);
    }

    private void loadUnitResources(String key){
        BufferedImage unit = ImageUtil.loadImage(GameLibrary.unitMap.get(key));
//        unit = ImageUtil.toBufferedImage(unit.getScaledInstance(-1, PixelMap.UNIT_HEIGHT, Image.SCALE_SMOOTH));
        cachedGraphics.put(key, unit);
    }
}
