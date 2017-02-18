package Entity;

/*--------------------------------------------------------------------------------------
|    Entity Class: Created by Tonny Xie on 2/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Entity is an abstract class extending the parameters of Stats. Entity
|   has a name for the Entity, ID for the Entity's instance, and a coordinate location;
|   contains an order queue to execute issued orders.
---------------------------------------------------------------------------------------*/

import Utilities.Coordinate;
import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity extends Stats {

    private String name = "";
    private int instanceID = 0;
    private Coordinate location;
    private int direction = 90;

    public List<Order> orderList;
    EntityManager entityManager;

    public Entity(String name, int instanceID, Coordinate location) {
        super(0,0,0,0,0,0,0,0, 0);
        this.name = name;
        this.instanceID = instanceID;
        this.location = location;
        this.orderList = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void executeNextOrder() {

    }

    public void cancelOrder() {

    }

    public void updateStats(Stats stat) {

    }

    public void updateDirection() {

    }

    public void updateVision() {

    }

    public void acceptTech(Technology tech) {

    }

//    abstract public void destroy(Entity entity);

    @Override
    public String toString() { return name + " " + instanceID; }

    // getters
    public String getName() { return name; }
    public int getInstanceID() { return instanceID; }
    public Coordinate getLocation() { return location; }

    // setters
//    public void setName(String name) { this.name = name; }
//    public void setInstanceID(int instanceID) { this.instanceID = instanceID; }
    public void setLocation(Coordinate location) { this.location = location; }

}
