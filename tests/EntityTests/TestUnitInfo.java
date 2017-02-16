package EntityTests;

/*--------------------------------------------------------------------------------------
|    TestUnitInfo Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Entity.*;
import Entity.Unit.ColonistUnit;
import Entity.Unit.ExplorerUnit;
import Entity.Unit.MeleeSoldier;
import Entity.Unit.RangeSoldier;
import Utilities.Coordinate;

public class TestUnitInfo {

    public static void main(String[] args) {
        System.out.println("======================================================================================================");
        testColonistExplorerInfo();
        System.out.println("======================================================================================================");
        testExplorerProspectMode();
        System.out.println("======================================================================================================");
        testMeleeRangeInfo();
        System.out.println("======================================================================================================");
    }

    private static void testColonistExplorerInfo() {
        int id = 1;
        Coordinate location = new Coordinate(2,3);
        ColonistUnit colonistUnit = new ColonistUnit(id, location);
        ExplorerUnit explorerUnit = new ExplorerUnit(id, location);

        System.out.println("testColonistExplorerInfo()");
        printEntityInfo(colonistUnit);
        printEntityInfo(explorerUnit);
    }

    private static void testExplorerProspectMode() {
        int id = 1;
        Coordinate location = new Coordinate(2, 3);
        ExplorerUnit explorerUnit = new ExplorerUnit(id, location);

        System.out.println("testExplorerProspectMode()");
        System.out.println("Normal Mode");
        printEntityInfo(explorerUnit);

        System.out.println("Prospect Mode");
        explorerUnit.toggleProspectMode();
        printEntityInfo(explorerUnit);

        System.out.println("Normal Mode");
        explorerUnit.toggleProspectMode();
        printEntityInfo(explorerUnit);
    }

    private static void testMeleeRangeInfo() {
        int id = 1;
        Coordinate location = new Coordinate(2, 3);
        MeleeSoldier meleeSoldier = new MeleeSoldier(id, location);
        RangeSoldier rangeSoldier = new RangeSoldier(id, location);

        printEntityInfo(meleeSoldier);
        printEntityInfo(rangeSoldier);
    }

    private static void printEntityInfo(Entity entity) {
        // Entity getters
        System.out.println("Testing: " + entity.toString());
        System.out.print("Name: " + entity.getName() + "   ");
        System.out.print("ID: " + entity.getInstanceID() + "\n");
        System.out.print("Location Row: " + entity.getLocation().getCol() + "   ");
        System.out.print("Location Col: " + entity.getLocation().getRow() + "\n");

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
