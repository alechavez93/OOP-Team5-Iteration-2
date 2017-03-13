package Views;
/*--------------------------------------------------------------------------------------
|	View Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Base Class
|
---------------------------------------------------------------------------------------*/

import Views.PixelMaps.PixelMap;
import javax.swing.*;

public class View extends JPanel{

    public View(String name){
        setName(name);
        setLayout(null);
        setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
    }
}
