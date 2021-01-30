
package main;

import java.util.Date;

public class Cashier extends User {

    public Cashier(String firstName, String lastName, String phoneNumber,
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

                    if(Restaurants.restaurants.get(i).ordes.get(j).state.equals(OrderState.MADE)){
                        
                        System.out.println(Restaurants.restaurants.get(i).ordes.get(j).toString());
                    }
                }
                        
                return ActionResult.SUCCESSSHOW;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    } 
    
    static ActionResult confirmOrder (String restaurantname, String restaurantpass, int orderid) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if (Restaurants.restaurants.get(i).ordes.get(j).id == orderid) {

                        for (int k = 0; k < Restaurants.restaurants.get(i).menu.size(); k++) {

                            if (Restaurants.restaurants.get(i).ordes.get(j).foodId
                                    == Restaurants.restaurants.get(i).menu.get(k).id) {

                                if (Restaurants.restaurants.get(i).menu.get(k).isAvailable) {

                                    Restaurants.restaurants.get(i).ordes.get(j).state = OrderState.CONFIRMED;
                                    return ActionResult.SUCCESSCONFIRMED;
                                }

                                return ActionResult.FOOD_NOT_AVAILABLE;
                            }
                        }

                        return ActionResult.FOOD_NOT_FOUND;
                    }

                }

                return ActionResult.ORDER_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
}