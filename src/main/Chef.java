
package main;

import java.util.Date;

public class Chef extends User{
    
    public Chef(String firstName, String lastName, String phoneNumber,
            String username, String password, AccessLevel accessLevel,
            Date registrationDate, Date lastLoginDate) {

        super(firstName, lastName, phoneNumber, username, password, accessLevel,
                registrationDate, lastLoginDate);
    }
    
    static ActionResult addFood (String restaurantname, String restaurantpass, Food food) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                boolean security = true;

                for (int j = 0; j < Restaurants.restaurants.get(i).menu.size(); j++) {

                    if (Restaurants.restaurants.get(i).menu.get(j).id == food.id) {

                        security = false;
                        break;
                    }
                }

                if (security) {

                    Restaurants.restaurants.get(i).menu.add(food);
                    return ActionResult.SUCCESSADD;
                } else {

                    return ActionResult.FOOD_ALREADY_EXIST;
                }
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
    
    static ActionResult editFood (String restaurantname, String restaurantpass, int id,
            String result, int newid, String newname, String[] newingredients) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).menu.size(); j++) {

                    if (Restaurants.restaurants.get(i).menu.get(j).id == id) {

                        switch (result) {
                            case "1" ->
                                Restaurants.restaurants.get(i).menu.get(j).id = newid;
                            case "2" ->
                                Restaurants.restaurants.get(i).menu.get(j).name = newname;
                            case "3" ->
                                Restaurants.restaurants.get(i).menu.get(j).Ingredients = newingredients;
                            default ->
                                System.out.println(" Error: enter the correct number");
                        }

                        return ActionResult.SUCCESSEDIT;
                    }
                }

                return ActionResult.FOOD_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
    
    static ActionResult removeFood (String restaurantname, String restaurantpass, int id) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).menu.size(); j++) {

                    if (Restaurants.restaurants.get(i).menu.get(j).id == id) {

                        Restaurants.restaurants.get(i).menu.remove(j);
                        return ActionResult.SUCCESSREMOVE;
                    }

                }

                return ActionResult.FOOD_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
    
    static ActionResult changeFoodStatus (String restaurantname, String restaurantpass, int id, boolean isAvailable) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).menu.size(); j++) {

                    if (Restaurants.restaurants.get(i).menu.get(j).id == id) {

                        Restaurants.restaurants.get(i).menu.get(j).isAvailable = isAvailable;
                        return ActionResult.SUCCESSEDIT;
                    }

                }

                return ActionResult.FOOD_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
    
    static ActionResult showorders(String restaurantname, String restaurantpass) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if(Restaurants.restaurants.get(i).ordes.get(j).state.equals(OrderState.CONFIRMED)){
                        
                        System.out.println(Restaurants.restaurants.get(i).ordes.get(j).toString());
                    }
                }
                        
                return ActionResult.SUCCESSSHOW;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    } 
    
    static ActionResult cook (String restaurantname, String restaurantpass, int id) {
        
        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if (Restaurants.restaurants.get(i).ordes.get(j).id == id) {

                        Restaurants.restaurants.get(i).ordes.get(j).state = OrderState.COOKED;
                        return ActionResult.SUCCESSCOOKED;
                    }

                }

                return ActionResult.ORDER_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
    
    static ActionResult showfoods(String restaurantname, String restaurantpass) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).menu.size(); j++) {

                    System.out.println(Restaurants.restaurants.get(i).menu.get(j).toString());
                }                 
                
                return ActionResult.SUCCESSSHOW;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }
}