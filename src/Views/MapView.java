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
import java.awt.image.BufferedImage;

public class MapView extends View{

    ViewPort viewPort;
    CyclingSection cyclingSection;
    EntityStateSection entityState;
    MiniMapSection miniMap;

    public MapView(String name, CyclingState state){
        super(name);

        //Initialize ViewPort and other Sections
        ViewPort.initialize(new PixelPoint(0,0), state);
        viewPort = ViewPort.getInstance();
        cyclingSection = new CyclingSection();
        entityState = new EntityStateSection();
        miniMap = new MiniMapSection();

        cyclingSection.setCyclingState(state);
        entityState.setCyclingState(state);


        //Adding inner components
        add(viewPort);
        add(cyclingSection);
        add(entityState);
        add(miniMap);
        setVisible(true);
    }

    public void CyclingState(CyclingState state){
        cyclingSection.setCyclingState(state);
        entityState.setCyclingState(state);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        viewPort.repaint();
        cyclingSection.repaint();
        entityState.repaint();
        miniMap.repaint();
    }

    public void refreshCyclinigSection(){
        cyclingSection.repaint();
    }

    public void refreshViewportSection(){
        viewPort.repaint();
    }

    public void refreshEntityStateSection(){
        entityState.repaint();
    }

    public void refreshMinimapSection(){
        miniMap.repaint();
    }
}
