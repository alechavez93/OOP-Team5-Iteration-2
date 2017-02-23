package Entity;

/*--------------------------------------------------------------------------------------
|    Entity Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Entity is an abstract class extending the parameters of Stats. Entity
|   has a name for the Entity, ID for the Entity's instance, and a coordinate location;
|   contains an order queue to execute issued orders.
---------------------------------------------------------------------------------------*/

import GameMap.MapCoordinate;
import Player.EntityManager;
import Utility.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity extends Stats {

    protected EntityManager entityManager;
    private String name = "";
    private int instanceID = 0;
    private MapCoordinate location;
    private Direction direction = Direction.South;

    public List<Order> orderList;

    public Entity(String name, int instanceID, MapCoordinate location, EntityManager entityManager) {
        super(0,0,0,0,0,0,0,0, 0);
        this.name = name;
        this.instanceID = instanceID;
        this.location = location;
        this.orderList = new ArrayList<Order>();
        this.entityManager = entityManager;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void executeNextOrder() {

    }

    public void cancelOrder() {
        orderList.clear();
    }

    public void updateStats(Stats stat) {

    }

    public void updateDirection() {

    }

    public void updateVision() {

    }

    public void acceptTech(Technology tech) {

    }

    public void destroy() {

    }

//    abstract public void destroy(Entity entity);

    @Override
    public String toString() { return name + " " + instanceID; }

    // getters
    public String getName() { return name; }
    public int getInstanceID() { return instanceID; }
    public MapCoordinate getLocation() { return location; }
    public Direction getDirection() { return direction; }

    // setters
//    public void setName(String name) { this.name = name; }
//    public void setInstanceID(int instanceID) { this.instanceID = instanceID; }
    public void setLocation(MapCoordinate location) { this.location = location; }
    public void setDirection(Direction direction) { this.direction = direction; }

}
