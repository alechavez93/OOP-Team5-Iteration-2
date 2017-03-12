package Entity;

/*--------------------------------------------------------------------------------------
|    Resource Enum: Created by Tonny Xie on 3/12/2017.
|---------------------------------------------------------------------------------------
|   Description:
---------------------------------------------------------------------------------------*/

import GameMap.MapCoordinate;
import java.util.Map;

public enum Resource {

    FOOD(0),
    ENERGY(0),
    ORE(0),

    NUTRIENT(0),
    POWER(0),
    METAL(0);

    private int amount;
    private MapCoordinate location;

    Resource(int amount, MapCoordinate location) {
        this.amount = amount;
        this.location = location;
    }

    Resource(int amount) {
        this.amount = amount;
    }

    public void incrementAmount(int amount) {
        setAmount(getAmount() + amount);
    }

    public void decrementAmount(int amount) {
        setAmount(getAmount() - amount);
    }

    public int getAmount() { return amount; }
    public MapCoordinate getLocation() { return location; }

    public void setAmount(int amount) { this.amount = amount; }
    public void setLocation(MapCoordinate location) { this.location = location; }
}
