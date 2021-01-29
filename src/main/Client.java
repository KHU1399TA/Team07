package main;

import java.util.Date;

public class Client extends User {

    public Client(String firstName, String lastName, String phoneNumber,
            String username, String password, AccessLevel accessLevel,
            Date registrationDate, Date lastLoginDate) {

        super(firstName, lastName, phoneNumber, username, password, accessLevel,
                registrationDate, lastLoginDate);
    }

    static ActionResult makeOrder(String restaurantname, Order order) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)) {

                boolean security = true;

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if (Restaurants.restaurants.get(i).ordes.get(j).id == order.id) {

                        security = false;
                        break;
                    }
                }

                if (security) {

                    Restaurants.restaurants.get(i).ordes.add(order);
                    order.state = OrderState.MADE;
                    return ActionResult.SUCCESSADD;
                } else {

                    return ActionResult.ORDER_ALREADY_EXIST;
                }
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }

    static ActionResult revokeOrder(String restaurantname, int orderid) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if (Restaurants.restaurants.get(i).ordes.get(j).id == orderid) {

                        Restaurants.restaurants.get(i).ordes.remove(j);
                        return ActionResult.SUCCESSREMOVE;
                    }

                }

                return ActionResult.ORDER_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }

    static ActionResult showorderstate(String restaurantname, int orderid) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).ordes.size(); j++) {

                    if (Restaurants.restaurants.get(i).ordes.get(j).id == orderid) {

                        System.out.println(Restaurants.restaurants.get(i).ordes.get(j).toString());
                        return ActionResult.SUCCESSSHOW;
                    }

                }

                return ActionResult.ORDER_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }

    static void showrestaurants() {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            System.out.println(Restaurants.restaurants.get(i).toString());
        }
    }

    static void showfoods(String restaurantname) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).equals(restaurantname)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).menu.size(); j++) {

                    System.out.println(Restaurants.restaurants.get(i).menu.get(j).toString());
                }
            }
        }
    }
}
