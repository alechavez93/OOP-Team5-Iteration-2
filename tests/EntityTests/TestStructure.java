package EntityTests;

/*--------------------------------------------------------------------------------------
|    TestStructure Class: Created by Tonny Xie on 2/26/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

import Entity.Entity;
import Entity.Structure.CapitalStructure;
import Entity.Unit.ColonistUnit;
import Entity.Unit.Soldier.MeleeSoldier;
import Entity.Resource;
import Utility.Vec2i;
import GameMap.*;
import Player.*;

public class TestStructure {

    public static void main(String[] args) {
        GameMap.getInstance().initialize(new Vec2i(10,10));

        testCapitalStructure();
    }

    private static void testCapitalStructure() {
        int id = 1;
        GameMap map = GameMap.getInstance();
        MapCoordinate location = new MapCoordinate(2,3);
        Player player = new Player(1, location);
        EntityManager entityManager = new EntityManager(player);

        ColonistUnit colonist = new ColonistUnit(id, location, entityManager);

        CapitalStructure capital = colonist.createCapitalStructure(id);
        MeleeSoldier meleeSoldier1 = colonist.createMeleeSoldier(id);
        MeleeSoldier meleeSoldier2 = colonist.createMeleeSoldier(id);
        colonist.destroy();

        System.out.println("\n============================================================");
        System.out.println("Capital is created by Colonist");
        printEntityInfo(capital);
        System.out.println("\n============================================================");
        System.out.println("Melee Soldier 1 is created by Colonist");
        printEntityInfo(meleeSoldier1);
        System.out.println("\n============================================================");
        System.out.println("Melee Soldier 2 is created by Colonist");
        printEntityInfo(meleeSoldier2);

        // Player cycles through MODE - STRUCTURE
        // Player cycles through STRUCTURE TYPE - CAPITAL
        // Player cycles through STRUCTURE INSTANCE - 0

        // Player cycles through STRUCTURE COMMANDS - ASSIGN WORKERS
        // Player selects how many workers to assign to harvest energy
//        int workerCounter = 5;
        // Player selects which tile to assign workers to
//        MapCoordinate resourceLocation;
//        capital.harvest(location);

        System.out.println("\n============================================================");
        System.out.println("Amount of Energy: " + Resource.ENERGY.getAmount());
        capital.assignHarvest(5, Resource.ENERGY, location);
        System.out.println("Amount of Energy: " + Resource.ENERGY.getAmount());

        System.out.println("\n============================================================");
        System.out.println("Amount of Nutrients: " + Resource.NUTRIENT.getAmount());
        capital.assignProduce(5, Resource.NUTRIENT);
        System.out.println("Amount of Nutrients: " + Resource.NUTRIENT.getAmount());

        System.out.println("\n============================================================");
        meleeSoldier1.setCurrentHealth(5);
        System.out.println("Melee Soldier 1 Health before Heal: " + meleeSoldier1.getCurrentHealth());
        capital.healUnit(meleeSoldier1);
        System.out.println("Melee Soldier 1 Health after Heal: " + meleeSoldier1.getCurrentHealth());
        capital.healUnit(meleeSoldier1);
        System.out.println("Melee Soldier 1 Health after OverHeal: " + meleeSoldier1.getCurrentHealth());

    }

    private static void printEntityInfo(Entity entity) {
        // Entity getters
        System.out.println("Testing: " + entity.toString());
        System.out.print("Name: " + entity.getName() + "   ");
        System.out.print("ID: " + entity.getInstanceID() + "\n");
        System.out.print("Location Row: " + entity.getLocation().getRow() + "   ");
        System.out.print("Location Col: " + entity.getLocation().getColumn() + "   ");
        System.out.print("Direction Angle: " + entity.getDirection().getAngle() + "\n");

        // Stats getters
        System.out.print("Attack: " + entity.getAttack() + "   ");
        System.out.print("Defense: " + entity.getDefense() + "   ");
        System.out.print("Armor: " + entity.getArmor() + "   ");
        System.out.print("Movement: " + entity.getMovement() + "   ");
        System.out.print("MaxHealth: " + entity.getMaxHealth() + "   ");
        System.out.print("CurrentHealth: " + entity.getCurrentHealth() + "   ");
        System.out.print("RangeRadius: " + entity.getRangeRadius() + "   ");
        System.out.print("VisibilityRadius: " + entity.getVisibilityRadius() + "  ");
        System.out.print("UpKeep: " + entity.getUpkeep() + "   \n");
    }
}
