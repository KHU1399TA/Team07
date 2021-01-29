
package main;

import java.util.*;

public class Order {
    
    int id;
    int foodId;
    OrderState state;
    Date orderedAt;
    String address;
    
    Order(int id, int foodId, OrderState state, Date orderedAt, String address) {
        
        this.id = id;
        this.foodId = foodId;
        this.state = state;
        this.orderedAt = orderedAt;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "-".repeat(34) + "\n Order {" + " ID = " + id 
                + "\n FoodId = " + foodId + "\n Order State = " + state + "\n OrderedAt = " 
                + orderedAt + "\n Order's address = " + address + " }";
    }
}