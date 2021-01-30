
package main;

import java.util.Date;

public class DeliveryMan extends User{
    
    public DeliveryMan(String firstName, String lastName, String phoneNumber,
            String username, String password, AccessLevel accessLevel,
            Date registrationDate, Date lastLoginDate) {

        super(firstName, lastName, phoneNumber, username, password, accessLevel,
                registrationDate, lastLoginDate);
    }
    
    static ActionResult showorders(String restaurantname, String restaurantpass) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if(Restaurants.restaurants.get(i).ordes.get(j).state.equals(OrderState.COOKED)){
                        
                        Restaurants.restaurants.get(i).ordes.get(j).toString();
                    }
                }
                        
                return ActionResult.SUCCESSSHOW;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
    
    static ActionResult deliver (String restaurantname, String restaurantpass, int orderid) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if (Restaurants.restaurants.get(i).ordes.get(j).id == orderid) {
                        
                        Restaurants.restaurants.get(i).ordes.get(j).state = OrderState.DELIVERED;
                        return ActionResult.SUCCESSDELIVERED;
                    }

                }

                return ActionResult.ORDER_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
}