package Entity;

/*--------------------------------------------------------------------------------------
|    Entity Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Entity is an abstract class extending the parameters of Stats. Entity
|   has a name for the Entity, ID for the Entity's instance, and a coordinate location;
|   contains an order queue to execute issued orders.
---------------------------------------------------------------------------------------*/


import Commands.*;
import GameLibrary.GameLibrary;
import GameMap.MapCoordinate;
import Player.EntityManager;
import Technology.EntityTechnology.EntityTechnology;
import Technology.StructureTechnology.StructureTechnology;
import Utility.Direction;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity extends Stats {

    protected Command lastCommand;
    protected EntityManager entityManager;
    protected boolean isPowered;
    private String name = "";
    private int instanceID = 0;
    private MapCoordinate location;
    private Direction direction = Direction.South;
    private String state;

    public List<Command> commandList;

    public Entity(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(0,0,0,0,0,0,0,0, 0);
        this.name = name;
        this.instanceID = instanceID;
        this.location = location;
        this.commandList = new ArrayList<Command>();
        this.entityManager = entityManager;
        this.isPowered = true;
    }

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void takeDamage(Entity entity, String mode){
        int damage = 0;
        if(mode == "Attack") { damage = entity.getAttack(); }
        if(mode == "Defend") { damage = entity.getDefense(); }
        if(damage == 0) { System.out.println("Something went wrong in takeDamage"); }
        this.currentHealth -= damage - this.getArmor();
        //System.out.println(damage - this.getArmor() + " damage was taken by Player " + this.getEntityManager().playerOwner.getpID() + "'s " + this.getName());

        //System.out.println("target's direction: " + getDirection() + ", attacker's direction:: " + entity.getDirection());

        if(this.currentHealth <= 0){
            System.out.println("Player " + this.getEntityManager().playerOwner.getpID() + "'s " + this.getName() + " died");
            destroy();
            return;
        }

        if(this.getDirection() == entity.getDirection().getOpposite() && this.getState() == "Defend"){
            //System.out.println(this.getName() + " defended successfully!");
            entityManager.retaliate(this, entity);
        }
    }

    public void finishTurn() {
        processQueue();
        processUpkeep();
    }

    public void processQueue() {
        if(!commandList.isEmpty()){
            commandList.get(0).execute();
            lastCommand = commandList.get(0);
            commandList.remove(0);
            //TODO: figure out how to not stop stuff

        }
        if(commandList.isEmpty() && (state == GameLibrary.ATTACK || state == GameLibrary.DEFEND)){
            lastCommand.execute();
        }

    }

    public void processUpkeep() {
        if(!entityManager.spendResources(upkeep,0,0)){
            degrade();
        }
    }

    public void degrade() {
        if(currentHealth > 2)
            currentHealth -= 2;
        if(attack > 2)
            attack--;
        if(defense > 2)
            defense--;
    }

    public void cancelOrders() {
        commandList.clear();
    }

    public void updateStats(Stats stat) {

    }

    public void updateDirection() {

    }


    public void acceptTech(EntityTechnology tech) {
        tech.visit(this);
    }

//<<<<<<< HEAD
//    public void acceptTech(Technology tech) {
//        tech.visit(this);
//=======
    public void acceptTech(StructureTechnology tech) {

    }

    public void upgradeVision() {
        visibilityRadius++;
    }

    public void upgradeAttack() {
        attack++;
    }

    public void upgradeDefense() {
        defense++;
    }

    public void upgradeArmor() {
        armor++;
    }

    public void upgradeSpeed() {

    }

    public void upgradeHealth() {
        maxHealth++;
        currentHealth++;
    }

    public void upgradeEfficiency() {
        upkeep *= 0.9;
    }

    public void upgradeProduction(String productionType) {

    }

    //Commands functionality
    public abstract void destroy();
    public void powerUp(){
        if(!isPowered){
            isPowered = true;
            upkeep = upkeep*4;
        }
    }

    public void powerDown(){
        if(isPowered){
            isPowered = false;
            upkeep = upkeep/4;
        }
    }


//    abstract public void destroy(Entity entity);

    @Override
    public String toString() { return name + " " + instanceID; }

    // getters
    public String getName() { return name; }
    public int getInstanceID() { return instanceID; }
    public MapCoordinate getLocation() { return location; }
    public Direction getDirection() { return direction; }
    public String getState() { return state; }
    public EntityManager getEntityManager(){ return entityManager; }

    // setters
//    public void setName(String name) { this.name = name; }
//    public void setInstanceID(int instanceID) { this.instanceID = instanceID; }
    public void setLocation(MapCoordinate location) { this.location = location; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public void setState(String state) { this.state = state; }

}
