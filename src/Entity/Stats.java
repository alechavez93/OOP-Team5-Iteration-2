package Entity;

/*--------------------------------------------------------------------------------------
|    Stats Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Stats is an abstract class holding all the stats used by its subclasses.
|   A list of stats include: attack, defense, armor, movement, max health, current health,
|   visibility radius, upkeep
---------------------------------------------------------------------------------------*/

public abstract class Stats {

    public int attack = 0;
    public int defense = 0;
    public int armor = 0;
    public int movement = 0;
    public int maxHealth = 0;
    public int currentHealth = 0;
    public int rangeRadius = 0;
    public int visibilityRadius = 0;
    public int upkeep = 0;

    public Stats(int attack, int defense, int armor, int movement, int maxHealth, int currentHealth, int rangeRadius, int visibilityRadius, int upkeep) {
        this.attack = attack;
        this.defense = defense;
        this.armor = armor;
        this.movement = movement;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.rangeRadius = rangeRadius;
        this.visibilityRadius = visibilityRadius;
        this.upkeep = upkeep;
    }

    // getters
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getArmor() { return armor; }
    public int getMovement() { return movement; }
    public int getMaxHealth() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public int getRangeRadius() { return rangeRadius; }
    public int getVisibilityRadius() { return visibilityRadius; }
    public int getUpkeep() { return upkeep; }

    // setters
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setArmor(int armor) { this.armor = armor; }
    public void setMovement(int movement) { this.movement = movement; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth;}
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
    }
    public void setRangeRadius(int rangeRadius) { this.rangeRadius = rangeRadius; }
    public void setVisibilityRadius(int visibilityRadius) { this.visibilityRadius = visibilityRadius; }
    public void setUpkeep(int upkeep) { this.upkeep = upkeep; }
    public void resetStats(){
        attack = 0;
        defense = 0;
        armor = 0;
        movement = 0;
        maxHealth = 0;
        currentHealth = 0;
        rangeRadius = 0;
        visibilityRadius = 0;
        upkeep = 0;
    }
}
