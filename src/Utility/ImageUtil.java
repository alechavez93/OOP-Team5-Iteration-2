package Utility;
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

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image
        return bimage;
    }
}
