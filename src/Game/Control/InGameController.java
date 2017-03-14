package Game.Control;
/*--------------------------------------------------------------------------------------
|	InGameController Class: Created by Alejandro Chavez on 3/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Manages the game from the In-game side. Excludes starting window.
---------------------------------------------------------------------------------------*/

import Game.CyclingState;
import Game.Game;
import Views.InGameFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class InGameController implements KeyListener {

    private Game game;
    private InGameFrame frame;
    private CyclingState state;
    private Set<Integer> keysPressed;


    public InGameController(InGameFrame frame, CyclingState state){
        this.frame = frame;
        this.state = state;
//        game = Game.getInstance();
        keysPressed = new HashSet<>();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keysPressed.add(code);
        changeScreen(code);
    }


    public void changeScreen(int code){
        switch(code) {
            case KeyEvent.VK_Q:
                System.out.println(code);
                frame.setViewVisible(0);
                break;
            case KeyEvent.VK_W:
                System.out.println(code);
                frame.setViewVisible(1);
                break;
            case KeyEvent.VK_E:
                System.out.println(code);
                frame.setViewVisible(2);
                break;
//            case KeyEvent.VK_R:
//                System.out.println(code);
//                frame.setViewVisible(3);
//                break;
        }
    }



    @Override public void keyReleased(KeyEvent e) { keysPressed.remove(e.getKeyCode()); }
    @Override public void keyTyped(KeyEvent e) {}
}
