package main;

import java.util.*;

public abstract class User {

    protected  String firstName;
    protected  String lastName;
    protected  String phoneNumber;
    protected  String username;
    protected  String password;
    protected  AccessLevel accessLevel;
    protected  Date registrationDate;
    protected Date lastLoginDate;

    User(String firstName, String lastName, String phoneNumber, String username,
            String password, AccessLevel accessLevel, Date registrationDate, Date lastLoginDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
    }

    static ActionResult login(String restaurantname, String restaurantpass, String username, String password, String accesslevel) {

        for (int i = 0; i < Restaurants.restaurants.size(); i++) {

            if (Restaurants.restaurants.get(i).restaurantname.equals(restaurantname)
                    && Restaurants.restaurants.get(i).restaurantpass.equals(restaurantpass)) {

                for (int j = 0; j < Restaurants.restaurants.get(i).users.size(); j++) {

                    boolean security = false;
                    
                    switch(accesslevel){
                        
                        case "manager" -> {
                            
                            if(Restaurants.restaurants.get(i).users.get(j).accessLevel.equals(AccessLevel.MANAGER)){
                                
                                security = true;
                            }
                            break;
                        }
                        case "chef" -> {
                            
                            if(Restaurants.restaurants.get(i).users.get(j).accessLevel.equals(AccessLevel.CHEF)){
                                
                                security = true;
                            }
                            break;
                        }
                        case "cashier" -> {
                            
                            if(Restaurants.restaurants.get(i).users.get(j).accessLevel.equals(AccessLevel.CASHIER)){
                                
                                security = true;
                            }
                            break;
                        }
                        case "deliveryman" -> {
                            
                            if(Restaurants.restaurants.get(i).users.get(j).accessLevel.equals(AccessLevel.DELIVERYMAN)){
                                
                                security = true;
                            }
                            break;
                        }
                        default -> security = false;
                    }
                    
                    if (Restaurants.restaurants.get(i).users.get(j).username.equals(username)
                            && Restaurants.restaurants.get(i).users.get(j).password.equals(password)
                            && security) {

                        Date today = new Date();
                        Restaurants.restaurants.get(i).users.get(j).lastLoginDate = today;

                        return ActionResult.SUCCESSLOGIN;
                    }
                }

                return ActionResult.USERNAME_NOT_FOUND;
            }
        }

        return ActionResult.RESTAURANT_NOT_FOUND;
    }

    @Override
    public String toString() {
        return "-".repeat(34) + "\n User {" + " FirstName = " + firstName + "\n LastName = " + lastName
                + "\n PhoneNumber = " + phoneNumber + "\n Username = " + username + "\n Password = " 
                + password + "\n" + accessLevel + "\n Registration date = " + registrationDate
                + "\n Last login date = " + lastLoginDate + " }";
    }
}
