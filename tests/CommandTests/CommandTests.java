package CommandTests;

import Commands.*;
import Entity.*;
import Entity.Army.Army;
import Entity.Structure.CapitalStructure;
import Entity.Unit.*;
import Game.Game;
import GameMap.GameMap;
import Utility.Direction;
import Utility.Vec2i;
import GameMap.MapCoordinate;
import Player.Player;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

/**
 * Created by test on 03/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    CommandTests Module: Created by test on 03/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class CommandTests {

    public static void main(String[] args) {

        //commandTest1();
        //commandTest2();
        commandTest3();
    }

    // Make Capital (Colonist), Create Army (Explorer), Decommission (Explorer
    private static void commandTest1() {
        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();


        System.out.println("After initializing, Player 1 has: ");
        printEntityList(game.player1);

        ColonistUnit colonistUnit = (ColonistUnit) game.player1.getEntityManager().getColonistList().get(0);
        MakeCapital command1 = new MakeCapital(colonistUnit);

        ExplorerUnit explorerUnit1 = (ExplorerUnit) game.player1.getEntityManager().getExplorerUnitList().get(0);
        Decommission command2 = new Decommission(explorerUnit1);

        ExplorerUnit explorerUnit2 = (ExplorerUnit) game.player1.getEntityManager().getExplorerUnitList().get(1);
        CreateArmy command3 = new CreateArmy(explorerUnit2);

        System.out.println("Before the end of the turn, the queues are: ");
        printCommandList(game.player1);

        game.player1.getEntityManager().finishTurn();

        System.out.println("After the end of the turn, the queues are: ");
        printCommandList(game.player1);

        printEntityList(game.player1);
    }

    private static void commandTest2() {
        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();

        ColonistUnit colonistUnit = (ColonistUnit) game.player1.getEntityManager().getColonistList().get(0);
        MakeCapital command1 = new MakeCapital(colonistUnit);

        ExplorerUnit explorerUnit1 = (ExplorerUnit) game.player1.getEntityManager().getExplorerUnitList().get(0);

        ExplorerUnit explorerUnit2 = (ExplorerUnit) game.player1.getEntityManager().getExplorerUnitList().get(1);

        System.out.println(explorerUnit1.getIsPowered());

        PowerDown powerdown = new PowerDown(explorerUnit1);
        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());

        PowerUp powerup = new PowerUp(explorerUnit1);
        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());
    }

    private static void commandTest3() {
        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();

        ColonistUnit colonistUnit = (ColonistUnit) game.player1.getEntityManager().getColonistList().get(0);
        MakeCapital command1 = new MakeCapital(colonistUnit);

        game.player1.getEntityManager().finishTurn();

        //printEntityList(game.player1);

        CapitalStructure capital = (CapitalStructure) game.player1.getEntityManager().getCapitalList().get(0);

        MeleeSoldier melee1 = (MeleeSoldier) game.player1.getEntityManager().getMeleeUnitList().get(0);
        CreateArmy command2 = new CreateArmy(melee1);

        MeleeSoldier melee2 = (MeleeSoldier) game.player1.getEntityManager().getMeleeUnitList().get(1);
        melee2.setLocation(new MapCoordinate(3,3));
        game.player1.getEntityManager().placeEntity(melee2);

        //System.out.println("Tile (3,3) has " + GameMap.getInstance().getTile(3,3).getOccupyingEntities().length);

        //printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        //System.out.println("Turn Endo");
        //printCommandList(game.player1);

        Army army = (Army) game.player1.getEntityManager().getArmyList().get(0);
        System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());

        Attack command4 = new Attack(army, melee2.getLocation());

        game.player1.getEntityManager().finishTurn();

        System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());
        Defend command3 = new Defend(melee2, army.getDirection().getOpposite());

        //printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        //printCommandList(game.player1);
        System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());

        //printEntityList(game.player1);

        PowerDown command6 = new PowerDown(melee2);
        command6.execute();
        game.player1.getEntityManager().finishTurn();
        System.out.println("melee 2 state: " + melee2.getState());


        Heal command5 = new Heal(capital);
        printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        printCommandList(game.player1);
        System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());

        printCommandList(game.player1);

    }

    private static void printCommandList(Player player) {
        for(Entity entity : player.getEntityManager().getAllEntities()){
            System.out.print("\t" + entity.toString() + ": ");
            for(Command command : entity.getCommandList()){
                System.out.print("[" + command.getName() + "]");
            }
            System.out.print("\n");
        }
    }

    private  static void printEntityList(Player player){
        for (Entity entity : player.getEntityManager().getAllEntities()) {
            System.out.println("  " + entity.toString());
        }
    }
}

