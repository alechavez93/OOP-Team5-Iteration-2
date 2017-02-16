package Utilities;
/*--------------------------------------------------------------------------------------
|	ImageUtil Class: Created by Alejandro Chavez on 2/14/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import javax.imageio.ImageIO;
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
}
