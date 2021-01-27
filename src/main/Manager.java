package main;

import java.util.*;

public class Manager extends User {

    public Manager(String firstName, String lastName, String phoneNumber,
            String username, String password, AccessLevel accessLevel,
            Date registrationDate, Date lastLoginDate) {

        super(firstName, lastName, phoneNumber, username, password, accessLevel,
                registrationDate, lastLoginDate);
    }

    static ActionResult addrestaurant(Restaurant restaurant) {

        boolean security = true;

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurant.restaurantname)) {

                security = false;
                break;
            }

            if (security) {

                Restaurants.restaurants.add(restaurant);
                return ActionResult.SUCCESSADDRESTAURANT;
            } else {

                return ActionResult.RESTAURANTNAME_ALREADY_EXIST;
            }
        }
        
        return ActionResult.UNKNOWN_ERROR;
    }
}