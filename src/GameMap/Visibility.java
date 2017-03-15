package GameMap;

/**
 * Created by CustomerPC on 3/8/2017.
 */

/*--------------------------------------------------------------------------------------

|    Visibility Class: Created by CustomerPC on 3/8/2017.

|---------------------------------------------------------------------------------------

|   Description:

|

---------------------------------------------------------------------------------------*/

public class Visibility {
    private boolean isVisible;
    private boolean isShrouded;
    private boolean isProspected;
    private MapCoordinate location;

    public Visibility(MapCoordinate location) {
        isVisible = false;
        isShrouded= true;
        this.location = location;
        this.isProspected = false;
    }

    public void see() {
        isShrouded = false;
        isVisible = true;
    }

    public void unsee() {
        isVisible = false;
    }

    public void prospect() { isProspected = true; }

    public boolean isVisible() { return isVisible; }
    public boolean isShrouded() { return isShrouded; }
    public boolean isExplored() { return !(isVisible || isShrouded);}
    public boolean isProspected() {return isProspected; }
    public MapCoordinate getLocation() { return location; }
}
