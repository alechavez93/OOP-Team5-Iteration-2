package Views;
/*--------------------------------------------------------------------------------------
|	StructureDrawer Class: Created by Alejandro Chavez on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description: This class in in charge of drawing the different types of structures.
---------------------------------------------------------------------------------------*/

import Entity.Structure.Structure;
import Utility.GraphicsFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StructureDrawer {

    public static void drawStructure(Graphics g, Structure structure){
        g.setClip(null);
        PixelPoint center = PixelMap.mapCoordinate(structure.getLocation());
        BufferedImage structImg = GraphicsFactory.getInstance().getStructure(structure.getName());
        g.drawImage(structImg, center.x - structImg.getWidth()/2, center.y - structImg.getHeight()/2, null);
    }
}
