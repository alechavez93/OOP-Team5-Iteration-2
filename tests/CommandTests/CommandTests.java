package CommandTests;

import Commands.*;
import Entity.*;
import Entity.Army.Army;
import Entity.Army.RallyPoint;
import Entity.Structure.CapitalStructure;
import Entity.Structure.FarmStructure;
import Entity.Unit.*;
import Game.Game;
import GameLibrary.GameLibrary;
import GameMap.GameMap;
import Utility.Direction;
import Utility.Vec2i;
import GameMap.MapCoordinate;
import Player.Player;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
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
        //commandTest3();
        //commandTest4();
        commandTest5();
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

    // Power Down (Explorer), Power Up (Explorer)
    private static void commandTest2() {
        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();

        ColonistUnit colonistUnit = (ColonistUnit) game.player1.getEntityManager().getColonistList().get(0);
        MakeCapital command1 = new MakeCapital(colonistUnit);

        ExplorerUnit explorerUnit0 = (ExplorerUnit) game.player1.getEntityManager().getExplorerUnitList().get(0);

        ExplorerUnit explorerUnit1 = (ExplorerUnit) game.player1.getEntityManager().getExplorerUnitList().get(1);

        System.out.println(explorerUnit1.getIsPowered());
        //true

        PowerDown powerdown = new PowerDown(explorerUnit1);
        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());
        //false

        Attack attack = new Attack(explorerUnit1, new MapCoordinate(1,5));
        //printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());
        //false

        //printCommandList(game.player1);


        CancelOrders cancelOrders = new CancelOrders(explorerUnit1);

        //printCommandList(game.player1);

        PowerUp powerup = new PowerUp(explorerUnit1);

        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());
        //false

        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());
        //false
        printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        System.out.println(explorerUnit1.getIsPowered());
        //true
        printCommandList(game.player1);

        //printCommandList(game.player1);
//        game.player1.getEntityManager().finishTurn();

    }

    // Create Army, Attack, Defend, Heal
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
        //System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());

        Attack command4 = new Attack(army, melee2.getLocation());

        game.player1.getEntityManager().finishTurn();

        //System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());
        Defend command3 = new Defend(melee2, army.getDirection().getOpposite());

        //printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        //printCommandList(game.player1);
        //System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());

        //printEntityList(game.player1);

        PowerDown command6 = new PowerDown(melee2);
        PowerUp command7 = new PowerUp(melee2);
        command6.execute();
        game.player1.getEntityManager().finishTurn();
        //System.out.println("melee 2 state: " + melee2.getState());


        Heal command5 = new Heal(capital);
        //printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        //printCommandList(game.player1);
        //System.out.printf("Army 0: Current Health is %d Max Health is %d\n", army.getCurrentHealth(), army.getMaxHealth());


        printCommandList(game.player1);
        CancelOrders command8 = new CancelOrders(melee2);
        System.out.println("-------------");
        printCommandList(game.player1);
        System.out.println("-------------");
        Decommission command9 = new Decommission(melee2);
        printCommandList(game.player1);

    }

    // Resource Usage
    private static void commandTest4() {
        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();

        game.player1.printResources();
        ColonistUnit colonistUnit = (ColonistUnit) game.player1.getEntityManager().getColonistList().get(0);
        MakeCapital command1 = new MakeCapital(colonistUnit);

        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();

        CapitalStructure capitalStructure = (CapitalStructure) game.player1.getEntityManager().getCapitalList().get(0);
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();
        game.player1.getEntityManager().finishTurn();

        List<Entity> list = game.player1.getEntityManager().getAllEntities();
        for (Entity entity : list){
            System.out.println(entity.getName() + " health:" + entity.getCurrentHealth() + " / " + entity.getMaxHealth());
        }
    }

    // Creating Structures / Units
    private static void commandTest5() {
        GameMap.getInstance().initialize(new Vec2i(20, 20));
        Game game = new Game();

        ColonistUnit colonistUnit = (ColonistUnit) game.player1.getEntityManager().getColonistList().get(0);
        MakeCapital command1 = new MakeCapital(colonistUnit);
        game.player1.getEntityManager().finishTurn();

        game.player1.printResources();
        MakeUnit makeUnit = new MakeUnit((CapitalStructure)game.player1.getEntityManager().getCapitalList().get(0), GameLibrary.EXPLORER);
        game.player1.getEntityManager().finishTurn();
/*         game.player1.printResources();
        game.player1.getEntityManager().finishTurn();
        game.player1.printResources();*/

        //printEntityList(game.player1);

        CreateArmy createArmy = new CreateArmy(game.player1.getEntityManager().getMeleeUnitList().get(0));
        game.player1.getEntityManager().finishTurn();

        CapitalStructure capitalStructure = (CapitalStructure) game.player1.getEntityManager().getCapitalList().get(0);
        Army army = (Army) game.player1.getEntityManager().getArmyList().get(0);
        RallyPoint rallyPoint = army.getRallyPoint();
        System.out.println("Capital has workerCount: " + capitalStructure.getWorkers().getNumberOfWorkers());
        //System.out.println("Capital has health " + capitalStructure.getCurrentHealth());
        rallyPoint.pickupWorker(capitalStructure, 10);
        rallyPoint.pickupWorker(capitalStructure, 5);
        System.out.println("after pickup it has " + capitalStructure.getWorkers().getNumberOfWorkers());

        System.out.println("army location: " + army.getLocation().getColumn() + ", " + army.getLocation().getRow());
        MoveRallypoint moveRallypoint = new MoveRallypoint(army, new MapCoordinate(1,5));
        BuildStructure buildStructure = new BuildStructure( army, 5, GameLibrary.FARM);

        game.player1.getEntityManager().finishTurn();
        printCommandList(game.player1);
        System.out.println("army location: " + army.getLocation().getColumn() + ", " + army.getLocation().getRow());
        game.player1.getEntityManager().finishTurn();
        printCommandList(game.player1);
        System.out.println("army location: " + army.getLocation().getColumn() + ", " + army.getLocation().getRow());
        game.player1.getEntityManager().finishTurn();
        printCommandList(game.player1);

        //printEntityList(game.player1);
        //printCommandList(game.player1);
        game.player1.getEntityManager().finishTurn();
        game.player1.getEntityManager().finishTurn();
        game.player1.getEntityManager().finishTurn();
        printEntityList(game.player1);

        System.out.println("~~~~~~~~~~~~~~~~");
        FarmStructure farmStructure = (FarmStructure) game.player1.getEntityManager().getFarmList().get(0);
        PickupWorkers pickupWorkers = new PickupWorkers(rallyPoint, farmStructure, 3);
        System.out.println("rally workercount: " + rallyPoint.getWorker().getNumberOfWorkers());
        System.out.println("farm workercount: " + farmStructure.getWorkers().getNumberOfWorkers());
        System.out.println("~~~~~~~~~~~~~~~~");
        Dropoff dropoff = new Dropoff(rallyPoint, farmStructure, 3);
        System.out.println("rally workercount: " + rallyPoint.getWorker().getNumberOfWorkers());
        System.out.println("farm workercount: " + farmStructure.getWorkers().getNumberOfWorkers());


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

