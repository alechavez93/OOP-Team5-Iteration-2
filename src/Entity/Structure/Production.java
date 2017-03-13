package Entity.Structure;

/**
 * Created by test on 03/12/2017.
 */

/*--------------------------------------------------------------------------------------
|    Production Module: Created by test on 03/12/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class Production {

    protected int foodRate = 0;
    protected int energyRate = 0;
    protected int oreRate = 0;
    protected int powerRate = 0;
    protected int nutrientsRate = 0;
    protected int metalRate = 0;
    protected int breedingRate = 0;
    protected int explorerRate = 0;
    protected int soldierRate = 0;

    public Production(int foodRate, int energyRate, int oreRate, int powerRate, int nutrientsRate, int metalRate, int breedingRate, int explorerRate, int soldierRate) {
        this.foodRate = foodRate;
        this.energyRate = energyRate;
        this.oreRate = oreRate;
        this.powerRate = powerRate;
        this.nutrientsRate = nutrientsRate;
        this.metalRate = metalRate;
        this.breedingRate = breedingRate;
        this.explorerRate = explorerRate;
        this.soldierRate = soldierRate;
    }

    // getters
    public int getFoodRate() { return foodRate; }
    public int getEnergyRate() { return energyRate; }
    public int getOreRate() { return oreRate; }
    public int getPowerRate() { return powerRate; }
    public int getNutrientsRate() { return nutrientsRate; }
    public int getMetalRate() { return metalRate; }
    public int getBreedingRate() { return breedingRate; }
    public int getExplorerRate() { return explorerRate; }
    public int getSoldierRate() { return soldierRate; }

    // setters
    public void setFoodRate(int foodRate) { this.foodRate = foodRate; }
    public void setEnergyRate(int energyRate) { this.energyRate = energyRate; }
    public void setOreRate(int oreRate) { this.oreRate = oreRate; }
    public void setPowerRate(int powerRate) { this.powerRate = powerRate; }
    public void setNutrientsRate(int nutrientsRate) { this.nutrientsRate = nutrientsRate;}
    public void setMetalRate(int metalRate) { this.metalRate = metalRate; }
    public void setBreedingRate(int breedingRate) { this.breedingRate = breedingRate; }
    public void setExplorerRate(int explorerRate) { this.explorerRate = explorerRate; }
    public void setSoldierRate(int soldierRate) { this.soldierRate = soldierRate; }
}
