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

    static ActionResult adduser(String restaurantname,String restaurantpass, User user) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)) {

                boolean security = true;

                for (int j = 0; j < Restaurants.restaurants.get(i).users.size(); j++) {

                    if (Restaurants.restaurants.get(i).users.get(j).username.equals(user.username)) {

                        security = false;
                        break;
                    }
                }

                if (security) {

                    Restaurants.restaurants.get(i).users.add(user);
                    return ActionResult.SUCCESSADDUSER;
                } else {

                    return ActionResult.USERNAME_ALREADY_EXIST;
                }
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }

    static ActionResult showrestaurantinfo(String restaurantname, String restaurantpass) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {
            
                System.out.println(Restaurants.restaurants.get(i).toString());
                return ActionResult.SUCCESSSHOW;
            }
        }
        
        return ActionResult.RESTAURANT_NOT_FOUND;
    }

    static ActionResult showuserinfo(String restaurantname, String restaurantpass, String username) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {
            
                for (int j = 0; j < Restaurants.restaurants.get(i).users.size(); j++) {
                    
                    if (Restaurants.restaurants.get(i).users.get(j).username.equals(username)) {
                        
                        System.out.println(Restaurants.restaurants.get(i).users.get(j).toString());
                        return ActionResult.SUCCESSSHOW;
                    }
                    
                }                    
                
                return ActionResult.USERNAME_NOT_FOUND;
            }
        }
        
        return ActionResult.RESTAURANT_NOT_FOUND;
    }
}