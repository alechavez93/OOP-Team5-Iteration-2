package Views.Drawers;
/*--------------------------------------------------------------------------------------
|	OptionDrawer Class: Created by Alejandro Chavez on 3/9/2017.
|---------------------------------------------------------------------------------------
|   Description: Draws an option name with an icon [not required], and a value next to it.
---------------------------------------------------------------------------------------*/

import Views.PixelMaps.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OptionDrawer {

    public static void drawOption(Graphics g, PixelPoint point, BufferedImage icon, String name, String value, Color color){
        g.setColor(color);
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 45));
        g.drawImage(icon, point.x, point.y, null);
        g.drawString(name+"\t"+value, point.x+icon.getWidth()+icon.getWidth()/4, point.y+(int)(0.65*(double)icon.getHeight()));
    }

    public static void drawOption(Graphics g, PixelPoint point, BufferedImage icon, String value){
        g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 45));
        g.drawImage(icon, point.x, point.y, null);
        g.drawString(value, point.x+icon.getWidth()+icon.getWidth()/4, point.y+(int)(0.75*(double)icon.getHeight()));
    }


}
