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
    private boolean isObscured;
    private MapCoordinate location;

    public Visibility(MapCoordinate location) {
        isVisible = false;
        isObscured = true;
        this.location = location;
    }

    public void see() {
        isObscured = false;
        isVisible = true;
    }

    public void unsee() {
        isVisible = false;
    }

    public boolean isVisible() { return isVisible; }
    public boolean isObscured() { return isObscured; }
    public MapCoordinate getLocation() { return location; }
}
