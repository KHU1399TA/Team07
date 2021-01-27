package main;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\t\tHello \n     Wellcome to this program");

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.println(" 1)manager 2)cashier 3)chef 4)deliveryman 5)client 0)Exit");

            System.out.print(" Please, select your access level's number: ");

            String accesslevelnumber = input.next();

            switch (accesslevelnumber) {

                case "1" -> {

                    manager();
                    break;
                }
                //case "2" -> System.out.println("-".repeat(28) + " \nplease login");
                //case "3" -> System.out.println("-".repeat(28) + " \nplease login");
                //case "4" -> System.out.println("-".repeat(28) + " \nplease login");
                case "0" -> {

                    break m;
                }
                default ->
                    System.out.println(" Error: enter the correct number");
            }
        }
        input.close();
        //check codes and write coment
        //clear codes
    }

    private static void manager() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" 1)new manager 2)old manager 0)Exit\n select number: ");

            String newmanager = input.next();

            switch (newmanager) {

                case "1" -> {

                    newmanager();
                    break m;
                }
                case "2" -> {

                    //oldmanager();
                    break m;
                }
                case "0" -> {

                    break m;
                }
                default ->
                    System.out.println(" Error: enter the correct number");
            }
        }
    }
    private static void newmanager() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            Typeofrestaurant typeofrestaurant = Typeofrestaurant.NOTHING;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println(" 1)fast food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
                System.out.print(" Enter type of restaurant(nmber): ");

                String result = input.next();

                typeofrestaurant = switch (result) {
                    case "1" ->
                        Typeofrestaurant.FASTFOOD;
                    case "2" ->
                        Typeofrestaurant.FASTCASUAL;
                    case "3" ->
                        Typeofrestaurant.CASUALDINING;
                    case "4" ->
                        Typeofrestaurant.CASUALPREMIUM;
                    case "5" ->
                        Typeofrestaurant.FINEDINING;
                    default ->
                        Typeofrestaurant.NOTHING;
                };

                if (typeofrestaurant.equals(Typeofrestaurant.NOTHING)) {
                    System.out.println(" Error: enter the correct number");
                    continue n;
                } else {
                    break n;
                }
            }

            System.out.print(" Enter your firstname: ");
            String firstname = input.next();

            System.out.print(" Enter your lastname: ");
            String lastname = input.next();

            System.out.print(" Enter your phoneNumber: ");
            String phoneNumber = input.next();

            System.out.print(" Enter your username: ");
            String username = input.next();

            System.out.print(" Enter your password: ");
            String password = input.next();

            AccessLevel accesslevel = AccessLevel.MANAGER;

            Date today = new Date();

            Restaurant newrestaorant = new Restaurant(restaurantname, restaurantpass, typeofrestaurant);

            Manager newmanager = new Manager(firstname, lastname, phoneNumber,
                    username, password, accesslevel, today, today);

            System.out.println(newrestaorant.toString());
            System.out.println(newmanager.toString());

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        System.out.println(" Confirmed");

                        long sizearrres = Restaurants.restaurants.size();
                        long sizearruser = 0;
                        int k;

                        Restaurants.restaurants.add(newrestaorant);

                        for (k = 0; k < Restaurants.restaurants.size(); k++) {

                            if (Restaurants.restaurants.get(k).restaurantname.equals(restaurantname)) {

                                sizearruser = Restaurants.restaurants.get(k).users.size();

                                Restaurants.restaurants.get(k).users.add(newmanager);
                                break;
                            }
                        }
                        if (sizearrres == Restaurants.restaurants.size() + 1 && sizearruser == Restaurants.restaurants.get(k).users.size()) {
                        }
                        break m;
                    }

                    case "2" -> {
                        System.out.println(" Canceled");
                        continue m;
                    }

                    case "0" -> {

                        break m;
                    }

                    default -> {

                        System.out.println(" Error: enter the correct number");
                        continue n;
                    }
                }
            }
        }
        //save the newmanager and newrestaurant
    }
}
