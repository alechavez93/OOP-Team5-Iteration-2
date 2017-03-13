package Views;
/*--------------------------------------------------------------------------------------
|	TechTreeView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Displays a visual representation of the Technology Tree.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import Utility.GraphicsFactory;
import Views.PixelMaps.PixelMap;

public class TechTreeView extends View{

    private CyclingState state;
    public static final int MARGIN = PixelMap.MARGIN;
    private GraphicsFactory graphicsFactory;

    public TechTreeView(String name, CyclingState state){
        super(name);
        this.state = state;
        graphicsFactory = GraphicsFactory.getInstance();
    }
}
