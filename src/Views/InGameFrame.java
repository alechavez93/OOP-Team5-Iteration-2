package Views;
/*--------------------------------------------------------------------------------------
|	InGameFrame Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the Frame in which all in Game views will be displayed.
|   Keeps the Map, the Unit, Structure, and Army overviews. It also has the Tech Tree View.
---------------------------------------------------------------------------------------*/

import Game.Controller;
import GameMap.GameMap;
import Utility.Vec2i;
import Views.PixelMaps.PixelMap;

import javax.swing.*;
import java.awt.*;

public class InGameFrame extends JFrame{

    private CardsContainer cards;
    private Controller controller;
    private JLayeredPane layeredPane;

    public InGameFrame(){
        layeredPane = new JLayeredPane();
        cards = new CardsContainer();
        getContentPane().add(cards);
        setTitle("Game");
        setSize(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void addView(View view){
        cards.addCard(view);
    }

    public void addController(Controller controller){
        this.controller = controller;
    }


    private class CardsContainer extends JPanel{

        private JTabbedPane cardsPane;
        private ImageIcon icon = new ImageIcon("fort.png");
        private int count = 0;

        CardsContainer(){
            cardsPane = new JTabbedPane();
            add(cardsPane);
            setLayout(new GridLayout(1, 1));
        }

        public void addCard(JPanel card){
            cardsPane.addTab(card.getName(), icon, card);
            JLabel lab = new JLabel(card.getName());
            lab.setFont(new Font(Font.DIALOG, Font.PLAIN, PixelMap.TAB_FONTSIZE));
            lab.setPreferredSize(new Dimension(PixelMap.TAB_WIDTH, PixelMap.TAB_HEIGHT));
            cardsPane.setTabComponentAt(count, lab);
            count++;
        }
    }
}
