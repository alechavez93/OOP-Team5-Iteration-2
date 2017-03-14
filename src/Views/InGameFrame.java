package Views;
/*--------------------------------------------------------------------------------------
|	InGameFrame Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the Frame in which all in Game views will be displayed.
|   Keeps the Map, the Unit, Structure, and Army overviews. It also has the Tech Tree View.
---------------------------------------------------------------------------------------*/

import Game.Controller;
import Views.PixelMaps.PixelMap;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InGameFrame extends JFrame{

    private Controller controller;
    private JLayeredPane layeredPane;
    private List<View> viewsList;
    private int current = 0;

    public InGameFrame(){
        layeredPane = new JLayeredPane();
        setTitle("Game");
        setSize(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        viewsList = new ArrayList<>();
    }

    public void addView(View view){
        viewsList.add(view);
        setViewVisible(0);
    }

    public void setViewVisible(int viewIndex){
        getContentPane().removeAll();
        getContentPane().add(viewsList.get(viewIndex));
        viewsList.get(viewIndex).repaint();
    }

    public void addController(Controller controller){
        this.controller = controller;
        addKeyListener(controller);
    }
}
