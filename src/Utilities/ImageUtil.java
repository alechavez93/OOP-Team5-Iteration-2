package Utilities;
/*--------------------------------------------------------------------------------------
|	ImageUtil Class: Created by Alejandro Chavez on 2/14/2017.
|---------------------------------------------------------------------------------------
|   Description: This utility class gives you access to services regarding Image Files.
|   Offered such as loading images, resizing to Tile Size, etc.
---------------------------------------------------------------------------------------*/

import Views.PixelMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static BufferedImage loadImage(String name){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/"+name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  img;
    }

    public static void resizeToTileSize(BufferedImage img){
        img.getScaledInstance(PixelMap.TILE_FULL_WIDTH, PixelMap.TILE_HEIGHT, Image.SCALE_DEFAULT);
    }

    public static void resizeToIconSize(){

    }
}
