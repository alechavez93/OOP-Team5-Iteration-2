package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	OptionDrawer Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Draws an option name with an icon [not required], and a value next to it.
---------------------------------------------------------------------------------------*/

import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OptionDrawer {

    public static final int FONT_SIZE = PixelMap.UNIT_HEIGHT/2+PixelMap.UNIT_HEIGHT/5;

    public static void drawOption(Graphics g, PixelPoint point, BufferedImage icon, String name, String value, Color color){
        g.setColor(color);
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, FONT_SIZE));
        g.drawImage(icon, point.x, point.y, null);
        g.drawString(name+"\t"+value, point.x+icon.getWidth()+icon.getWidth()/4, point.y+(int)(0.70*(double)icon.getHeight()));
    }

    public static void drawOption(Graphics g, PixelPoint point, BufferedImage icon, String value){
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, FONT_SIZE));
        g.drawImage(icon, point.x, point.y, null);
        g.drawString(value, point.x+icon.getWidth()+icon.getWidth()/4, point.y+(int)(0.75*(double)icon.getHeight()));
    }


}
