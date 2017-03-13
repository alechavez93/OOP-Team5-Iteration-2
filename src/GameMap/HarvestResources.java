package GameMap;

/**
 * Created by Customer-PC on 2/21/2017.
 */
public class HarvestResources {

    private int ore;
    private int energy;
    private int food;

    HarvestResources(int ore, int energy, int food) {
        this.ore = ore;
        this.energy = energy;
        this.food = food;
    }

    public int getOre() { return ore; }
    public int getEnergy() { return energy; }
    public int getFood() { return food; }

    public void decrementOre( int amount ) {
        ore -= amount;
    }
    public void decrementEnergy( int amount ) {
        energy -= amount;
    }
    public void setFood( int amount ) { food = amount; } //Allows for dynamic regeneration

    public void voidAll() { ore = 0; energy = 0; food = 0;}
}
