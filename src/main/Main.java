package main;

import java.util.*;

public class Main {

    private static boolean result = true;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\t\tHello \n     Wellcome to this program");

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.println(" 1)Manager 2)Cashier 3)Chef 4)Deliveryman 5)Client 0)Exit");

            System.out.print(" Please, select your access level's number: ");

            String accesslevelnumber = input.next();

            switch (accesslevelnumber) {

                case "1" -> {

                    manager();
                    break;
                }
                // case "2" -> System.out.println("-".repeat(28) + " \nplease login");
                // case "3" -> System.out.println("-".repeat(28) + " \nplease login");
                // case "4" -> System.out.println("-".repeat(28) + " \nplease login");
                case "0" -> {

                    break m;
                }

                default -> System.out.println(" Error: enter the correct number");
            }
        }
        input.close();
        // check codes and write coment
        // clear codes
    }

    private static void manager() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" 1)New manager 2)Login 0)Exit\n select number: ");

            String newmanager = input.next();

            switch (newmanager) {

                case "1" -> {

                    newmanager();
                    if(result)break m;
                    break;
                }

                case "2" -> {

                    loginmanager();
                    if(result)break m;
                    break;
                }

                case "0" -> {

                    result = false;
                    break m;
                }

                default -> System.out.println(" Error: enter the correct number");
            }
        }

        if (result) {

            m:for (int i = 1; i > 0; i++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Add restaurant 2)Add user 3)Show restauarnt information"
                        + "\n 4)Show user information 5)Edit restauarnt information"
                        + "\n 6)Edit user information 7)Remove restaurant 8)Remove user"
                        + "\n 0)Logout\n select number: ");

                String manager = input.next();

                switch (manager) {

                    case "1" -> {

                        addrestaurant();
                        break;
                    }
                    case "2" -> {

                        adduser();
                        break;
                    }
                    case "3" -> {

                        showrestaurantinfo();
                        break;
                    }
                    case "4" -> {

                        showuserinfo();
                        break;
                    }
                    case "5" -> {

                        editrestaurantinfo();
                        break;
                    }
                    case "6" -> {

                        edituserinfo();
                        break;
                    }
                    case "7" -> {

                        removerestaurant();
                        break;
                    }
                    case "8" -> {

                        removeuser();
                        break;
                    }
                    case "0" -> {

                        break m;
                    }
                    default -> System.out.println(" Error: enter the correct number");
                }
            }
        }
    }

    private static void newmanager() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            Typeofrestaurant typeofrestaurant = Typeofrestaurant.NOTHING;

            n: for (int j = 1; j > 0; j++) {

                System.out.println(" 1)Fast Food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
                System.out.print(" Enter type of restaurant(nmber): ");

                String result = input.next();

                typeofrestaurant = switch (result) {

                    case "1" -> Typeofrestaurant.FASTFOOD;
                    case "2" -> Typeofrestaurant.FASTCASUAL;
                    case "3" -> Typeofrestaurant.CASUALDINING;
                    case "4" -> Typeofrestaurant.CASUALPREMIUM;
                    case "5" -> Typeofrestaurant.FINEDINING;
                    default -> Typeofrestaurant.NOTHING;
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

            Manager newmanager = new Manager(firstname, lastname, phoneNumber, username, password, accesslevel, today,
                    today);

            System.out.println(newrestaorant.toString());
            System.out.println(newmanager.toString());

            n: for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        long sizearrres = Restaurants.restaurants.size();
                        long sizearruser = 0;

                        Restaurants.restaurants.add(newrestaorant);

                        for (int k = 0; k < Restaurants.restaurants.size(); k++) {

                            if (Restaurants.restaurants.get(k).restaurantname.equals(restaurantname)) {

                                sizearruser = Restaurants.restaurants.get(k).users.size();
                                Restaurants.restaurants.get(k).users.add(newmanager);

                                if (sizearrres == Restaurants.restaurants.size() - 1
                                        && sizearruser == Restaurants.restaurants.get(k).users.size() - 1) {

                                    System.out.println(" Confirmed");
                                    result = true;
                                    break m;
                                } else {

                                    result = false;
                                    break;
                                }
                            }
                        }

                        result = false;
                        System.out.println(" Not confirm");
                        break m;
                    }

                    case "2" -> {

                        System.out.println(" Canceled");
                        result = false;
                        continue m;
                    }

                    case "0" -> {

                        result = false;
                        break m;
                    }

                    default -> {

                        result = false;
                        System.out.println(" Error: enter the correct number");
                        continue n;
                    }
                }
            }
        }
        // save the newmanager and newrestaurant
    }

    private static void loginmanager() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.print("-".repeat(34) + " \n 1)Login 0)exit\n select number: ");

            String login = input.next();

            switch (login) {

                case "1" -> {

                    System.out.print(" Enter restaurant's name: ");
                    String restaurantname = input.next();

                    System.out.print(" Enter username: ");
                    String username = input.next();

                    System.out.print(" Enter password: ");
                    String password = input.next();

                    System.out.println("-".repeat(34) + "\n    Wellcome");

                    System.out.println(User.login(restaurantname, username, password));

                    if (User.login(restaurantname, username, password).equals(ActionResult.SUCCESSLOGIN)) {

                        result = true;
                        break m;
                    }

                    result = false;
                    break;
                }
                case "0" -> {

                    result = false;
                    break m;
                }

                default -> {

                    result = false;
                    System.out.println(" Error: enter the correct number");
                    continue m;
                }
            }
        }
    }

    private static void addrestaurant() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter new restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter new restaurant's password: ");
            String restaurantpass = input.next();

            Typeofrestaurant typeofrestaurant = Typeofrestaurant.NOTHING;

            n: for (int j = 1; j > 0; j++) {

                System.out.println(" 1)Fast Food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
                System.out.print(" Enter type of new restaurant(nmber): ");

                String result = input.next();

                typeofrestaurant = switch (result) {
                    case "1" -> Typeofrestaurant.FASTFOOD;
                    case "2" -> Typeofrestaurant.FASTCASUAL;
                    case "3" -> Typeofrestaurant.CASUALDINING;
                    case "4" -> Typeofrestaurant.CASUALPREMIUM;
                    case "5" -> Typeofrestaurant.FINEDINING;
                    default -> Typeofrestaurant.NOTHING;
                };

                if (typeofrestaurant.equals(Typeofrestaurant.NOTHING)) {
                    System.out.println(" Error: enter the correct number");
                    continue n;
                } else {
                    break n;
                }
            }
            Restaurant newrestaorant = new Restaurant(restaurantname, restaurantpass, typeofrestaurant);
            System.out.println(newrestaorant.toString());

            n: for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        System.out.println(" Confirmed");
                        System.out.println(Manager.addrestaurant(newrestaorant));
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
    }

    private static void adduser() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            System.out.print(" Enter user's firstname: ");
            String firstname = input.next();

            System.out.print(" Enter user's lastname: ");
            String lastname = input.next();

            System.out.print(" Enter user's phoneNumber: ");
            String phoneNumber = input.next();

            System.out.print(" Enter user's username: ");
            String username = input.next();

            System.out.print(" Enter user's password: ");
            String password = input.next();

            AccessLevel accesslevel = AccessLevel.NOTHING;

            n: for (int j = 1; j > 0; j++) {

                System.out.println(" 1)deliveryman 2)cashier 3)chef");
                System.out.print(" Enter user's accesslevel(nmber): ");

                String result = input.next();

                accesslevel = switch (result) {
                    case "1" -> AccessLevel.DELIVERYMAN;
                    case "2" -> AccessLevel.CASHIER;
                    case "3" -> AccessLevel.CHEF;
                    default -> AccessLevel.NOTHING;
                };

                if (accesslevel.equals(AccessLevel.NOTHING)) {
                    System.out.println(" Error: enter the correct number");
                    continue n;
                } else {
                    break n;
                }
            }
            Date today = new Date();

            Manager newuser = new Manager(firstname, lastname, phoneNumber, username, password, accesslevel, today,
                    today);

            n: for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        System.out.println(" Confirmed");
                        System.out.println(Manager.adduser(restaurantname, restaurantpass, newuser));
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
    }

    private static void showrestaurantinfo() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            if (Manager.showrestaurantinfo(restaurantname, restaurantpass).equals(ActionResult.SUCCESSSHOW)) {
                break;
            } else {

                System.out.println(Manager.showrestaurantinfo(restaurantname, restaurantpass));

                n: for (int j = 1; j > 0; j++) {

                    System.out.println("-".repeat(34));

                    System.out.print(" 1)Try again 0)Exit\n Select please: ");

                    String record = input.next();

                    switch (record) {

                        case "1" -> {

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
        }
    }

    private static void showuserinfo() {

        Scanner input = new Scanner(System.in);

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            System.out.print(" Enter username: ");
            String username = input.next();

            if (Manager.showuserinfo(restaurantname, restaurantpass, username).equals(ActionResult.SUCCESSSHOW)) {
                break;
            } else {

                System.out.println(Manager.showuserinfo(restaurantname, restaurantpass, username));

                n: for (int j = 1; j > 0; j++) {

                    System.out.println("-".repeat(34));

                    System.out.print(" 1)Try again 0)Exit\n Select please: ");

                    String record = input.next();

                    switch (record) {

                        case "1" -> {

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
        }
    }

    private static void editrestaurantinfo() {

        Scanner input = new Scanner(System.in);

        String edit = "";

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            System.out.print(" 1)Edit restaurant's name 2)Edit type of restaurant 0)Exit\n select number: ");
            String result = input.next();

            Typeofrestaurant typeofrestaurant = Typeofrestaurant.NOTHING;

            switch (result) {

                case "1" -> {
                    System.out.print(" Enter new restaurant's name for edit: ");
                    edit = input.next();
                    System.out.println(Manager.editrestaurant(restaurantname, restaurantpass, edit, result,
                            Typeofrestaurant.FASTCASUAL));
                    break m;
                }
                case "2" -> {

                    n: for (int j = 1; j > 0; j++) {

                        System.out.println(" 1)fast food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
                        System.out.print(" Enter type of restaurant(nmber): ");

                        String result1 = input.next();

                        typeofrestaurant = switch (result1) {
                            case "1" -> Typeofrestaurant.FASTFOOD;
                            case "2" -> Typeofrestaurant.FASTCASUAL;
                            case "3" -> Typeofrestaurant.CASUALDINING;
                            case "4" -> Typeofrestaurant.CASUALPREMIUM;
                            case "5" -> Typeofrestaurant.FINEDINING;
                            default -> Typeofrestaurant.NOTHING;
                        };

                        if (typeofrestaurant.equals(Typeofrestaurant.NOTHING)) {
                            System.out.println(" Error: enter the correct number");
                            continue n;
                        } else {
                            break n;
                        }
                    }
                    System.out.println(Manager.editrestaurant(restaurantname, restaurantpass, edit, result, typeofrestaurant));
                    break m;
                }
                case "0" -> {

                    break m;
                }

                default -> {

                    System.out.println(" Error: enter the correct number");
                    continue m;
                }
            }
        }
    }

    private static void edituserinfo() {

        Scanner input = new Scanner(System.in);

        String edit = "";

        m: for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            System.out.print(" Enter username: ");
            String username = input.next();

            System.out.print(" 1)Edit firstname 2)Edit lastname 3)Edit phonenumber "
                    + "\n 4)Edit username 5)Edit password 6)Edit accesslevel 0)Exit\n select number: ");
            String result = input.next();

            AccessLevel accesslevel = AccessLevel.NOTHING;

            switch (result) {

                case "1" -> {

                    System.out.print(" Enter a new firstname for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }

                case "2" -> {
                    System.out.print(" Enter a new lastname for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "3" -> {
                    System.out.print(" Enter a new phonenumber for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "4" -> {
                    System.out.print(" Enter a new username for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "5" -> {
                    System.out.print(" Enter a new password for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "6" -> {

                    n: for (int j = 1; j > 0; j++) {

                        System.out.println(" 1)deliveryman 2)cashier 3)chef");
                        System.out.print(" Enter access level(nmber): ");

                        String result1 = input.next();

                        accesslevel = switch (result1) {
                            case "1" -> AccessLevel.DELIVERYMAN;
                            case "2" -> AccessLevel.CASHIER;
                            case "3" -> AccessLevel.CHEF;
                            default -> AccessLevel.NOTHING;
                        };

                        if (accesslevel.equals(AccessLevel.NOTHING)) {
                            System.out.println(" Error: enter the correct number");
                            continue n;
                        } else {
                            break n;
                        }
                    }
                    System.out.println(
                            Manager.edituser(restaurantname, restaurantpass, username, edit, result, accesslevel));
                    break m;
                }
                case "0" -> {

                    break m;
                }

                default -> {

                    System.out.println(" Error: enter the correct number");
                    continue m;
                }
            }
        }
    }

    private static void removerestaurant() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.print(" Are you sure? 1)yes 2)no \n select number: ");
        String result = input.next();

        switch (result) {

            case "1" -> System.out.println(Manager.removerestaurant(restaurantname, restaurantpass));
            case "2" -> System.out.println(" canceled");
            default -> System.out.println(" Error: enter the correct number, try again");
        }
    }

    private static void removeuser() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.print(" Enter username: ");
        String username = input.next();

        System.out.print(" Are you sure? 1)yes 2)no \n select number: ");
        String result = input.next();

        switch (result) {

            case "1" -> System.out.println(Manager.removeuser(restaurantname, restaurantpass, username));
            case "2" -> System.out.println(" canceled");
            default -> System.out.println(" Error: enter the correct number, try again");
        }
    }
}
