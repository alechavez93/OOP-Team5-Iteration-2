package Views;
/*--------------------------------------------------------------------------------------
|	MapView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the MapView of the InGame Screen. Contains the ViewPort, the
|   Cycling section, the Selected Entity properties, and the mini-map.
---------------------------------------------------------------------------------------*/


import Game.CyclingState;
import Views.PixelMaps.PixelMap;
import Views.PixelMaps.PixelPoint;
import java.awt.*;

public class MapView extends View{

    ViewPort viewPort;
    CyclingSection cyclingSection;
    EntityStateSection entityState;
    MiniMapSection miniMap;

    public MapView(String name){
        setName(name);
        setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(0,0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        //Initialize ViewPort and other Sections
        ViewPort.initialize(new PixelPoint(0,0));
        viewPort = ViewPort.getInstance();
        cyclingSection = new CyclingSection();
        entityState = new EntityStateSection();
        miniMap = new MiniMapSection();


        //Temporary
        CyclingState cs = new CyclingState();
        cyclingSection.setCyclingState(cs);
        entityState.setCyclingState(cs);

        //Adding inner components
        add(viewPort);
        add(cyclingSection);
        add(entityState);
        add(miniMap);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        viewPort.repaint();
        cyclingSection.repaint();
        entityState.repaint();
        miniMap.repaint();
    }
}
