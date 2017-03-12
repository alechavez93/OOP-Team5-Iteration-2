package Views;
/*--------------------------------------------------------------------------------------
|	View Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Views.PixelMaps.PixelMap;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel{

    public View(String name){
        setName(name);
//        setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
    }
}
