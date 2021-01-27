package main;

import java.util.ArrayList;

public class Restaurant {
    
    protected ArrayList<User> users = new ArrayList<User>();
    protected String restaurantname;
    protected String restaurantpass;
    protected Typeofrestaurant typeofrestaurant;

    public Restaurant(String restaurantname, String restaurantpass, Typeofrestaurant typeofrestaurant) {
        this.restaurantname = restaurantname;
        this.restaurantpass = restaurantpass;
        this.typeofrestaurant = typeofrestaurant;
    }

    @Override
    public String toString() {
        return "-".repeat(34) + "\n Restaurant {" + " Restaurant's name = " + restaurantname
                + "\n" + typeofrestaurant + " }";
    }
    
    /*FileManager fileManager = new FileManager("src/resources/users.txt");
    
    public void writedata() {

        fileManager.writeLine(users.get(0).show(), false);
        
        for (int i = 1; i < users.size(); i++) {
         
            fileManager.writeLine(users.get(i).show(), true);
        }
    }
    
    public void readdata() {
        
        for (int i = 1; i > 0; i++) {
            
            users.add(fileManager.readLine(i));
        }
    }*/
}