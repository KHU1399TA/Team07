package main;

import java.util.*;

public class Main {

    private static boolean result = true;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\t      Hello \n     Wellcome to this program");

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.println(" 1)Manager 2)Chef 3)Cashier 4)Deliveryman 5)Client 0)Exit");

            System.out.print(" Please, select your access level's number: ");

            String accesslevelnumber = input.next();

            switch (accesslevelnumber) {

                case "1" -> {

                    manager();
                    break;
                }
                case "2" -> {

                    chef();
                    break;
                }
                case "3" -> {

                    cashier();
                    break;
                }
                case "4" -> {

                    deliveryman();
                    break;
                }
                case "5" -> {

                    client();
                    break;
                }
                case "0" -> {

                    break m;
                }

                default ->
                    System.out.println(" Error: enter the correct number");
            }
        }
        // check codes and write coment
        // clear codes
    }

    private static void manager() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" 1)Register 2)Login 0)Exit\n select number: ");

            String enter = input.next();

            switch (enter) {

                case "1" -> {

                    newmanager();
                    if (result) {
                        break m;
                    }
                    break;
                }

                case "2" -> {

                    loginmanager();
                    if (result) {
                        break m;
                    }
                    break;
                }

                case "0" -> {

                    result = false;
                    break m;
                }

                default ->
                    System.out.println(" Error: enter the correct number");
            }
        }

        if (result) {

            m:
            for (int i = 1; i > 0; i++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Add restaurant 2)Add user 3)Show restauarnt's information"
                        + "\n 4)Show user's information 5)Edit restauarnt's information"
                        + "\n 6)Edit user's information 7)Remove restaurant 8)Remove user"
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
                    default ->
                        System.out.println(" Error: enter the correct number");
                }
            }
        }
    }

    private static void newmanager() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter restaurant's password: ");
            String restaurantpass = input.next();

            Typeofrestaurant typeofrestaurant = Typeofrestaurant.NOTHING;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println(" 1)Fast Food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
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

                    System.out.println("-".repeat(34));
                    break n;
                }
            }

            System.out.print(" Enter your firstname: ");
            String firstname = input.next();

            System.out.print(" Enter your lastname: ");
            String lastname = input.next();

            System.out.print(" Enter your phoneNumber: ");
            String phoneNumber = input.next();

            System.out.print(" Enter username: ");
            String username = input.next();

            System.out.print(" Enter password: ");
            String password = input.next();

            AccessLevel accesslevel = AccessLevel.MANAGER;

            Date today = new Date();

            Restaurant newrestaorant = new Restaurant(restaurantname, restaurantpass, typeofrestaurant);

            Manager newmanager = new Manager(firstname, lastname, phoneNumber, username, password, accesslevel, today,
                    today);

            System.out.println(newrestaorant.toString());
            System.out.println(newmanager.toString());

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        long numberofrestaurants = Restaurants.restaurants.size();
                        long numberofusers = 0;

                        Restaurants.restaurants.add(newrestaorant);

                        for (int k = 0; k < Restaurants.restaurants.size(); k++) {

                            if (Restaurants.restaurants.get(k).restaurantname.equals(restaurantname)) {

                                numberofusers = Restaurants.restaurants.get(k).users.size();
                                Restaurants.restaurants.get(k).users.add(newmanager);

                                if (numberofrestaurants == Restaurants.restaurants.size() - 1
                                        && numberofusers == Restaurants.restaurants.get(k).users.size() - 1) {

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

        m:
        for (int i = 1; i > 0; i++) {

            System.out.print("-".repeat(34) + " \n 1)Login 0)Exit\n select number: ");

            String login = input.next();

            switch (login) {

                case "1" -> {

                    System.out.print("-".repeat(34));
                    
                    System.out.print(" Enter your restaurant's name: ");
                    String restaurantname = input.next();

                    System.out.print(" Enter your restaurant's password: ");
                    String restaurantpass = input.next();

                    System.out.print(" Enter your username: ");
                    String username = input.next();

                    System.out.print(" Enter your password: ");
                    String password = input.next();

                    System.out.println(User.login(restaurantname, restaurantpass, username, password, "manager"));

                    if (User.login(restaurantname, restaurantpass, username, password, "manager").equals(ActionResult.SUCCESSLOGIN)) {

                        System.out.println("-".repeat(34) + "\n    Wellcome");
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

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter new restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter new restaurant's password: ");
            String restaurantpass = input.next();

            Typeofrestaurant typeofrestaurant = Typeofrestaurant.NOTHING;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println(" 1)Fast Food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
                System.out.print(" Enter type of new restaurant(nmber): ");

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

                    System.out.println("-".repeat(34));
                    break n;
                }
            }
            Restaurant newrestaorant = new Restaurant(restaurantname, restaurantpass, typeofrestaurant);
            System.out.println(newrestaorant.toString());

            n:
            for (int j = 1; j > 0; j++) {

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

        m:
        for (int i = 1; i > 0; i++) {

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

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println(" 1)deliveryman 2)cashier 3)chef");
                System.out.print(" Enter user's accesslevel(nmber): ");

                String result = input.next();

                accesslevel = switch (result) {
                    case "1" ->
                        AccessLevel.DELIVERYMAN;
                    case "2" ->
                        AccessLevel.CASHIER;
                    case "3" ->
                        AccessLevel.CHEF;
                    default ->
                        AccessLevel.NOTHING;
                };

                if (accesslevel.equals(AccessLevel.NOTHING)) {

                    System.out.println(" Error: enter the correct number");
                    continue n;
                } else {

                    System.out.println("-".repeat(34));
                    break n;
                }
            }
            Date today = new Date();

            Manager newuser = new Manager(firstname, lastname, phoneNumber, username, password, accesslevel, today,
                    today);

            n:
            for (int j = 1; j > 0; j++) {

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

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name you want show: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password you want show: ");
            String restaurantpass = input.next();

            if (Manager.showrestaurantinfo(restaurantname, restaurantpass).equals(ActionResult.SUCCESSSHOW)) {
                break;
            } else {

                System.out.println(Manager.showrestaurantinfo(restaurantname, restaurantpass));

                n:
                for (int j = 1; j > 0; j++) {

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

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            System.out.print(" Enter user's username you want show: ");
            String username = input.next();

            System.out.print(" Enter user's password you want show: ");
            String password = input.next();

            if (Manager.showuserinfo(restaurantname, restaurantpass, username, password).equals(ActionResult.SUCCESSSHOW)) {
                break;
            } else {

                System.out.println(Manager.showuserinfo(restaurantname, restaurantpass, username, password));

                n:
                for (int j = 1; j > 0; j++) {

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

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter restaurant's name you want to change information: ");
            String restaurantname = input.next();

            System.out.print(" Enter restaurant's password you want to change information: ");
            String restaurantpass = input.next();

            System.out.print(" 1)Edit restaurant's name 2)Edit restaurant's password 3)Edit type of restaurant 0)Exit\n select number: ");
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
                    System.out.print(" Enter new restaurant's password for edit: ");
                    edit = input.next();
                    System.out.println(Manager.editrestaurant(restaurantname, restaurantpass, edit, result,
                            Typeofrestaurant.FASTCASUAL));
                    break m;
                }
                case "3" -> {

                    n:
                    for (int j = 1; j > 0; j++) {

                        System.out.println(" 1)fast food 2)Fast Casual 3)Casual Dining 4)Casual Premium 5)Fine-Dining");
                        System.out.print(" Enter type of restaurant(nmber) foe edit: ");

                        String result1 = input.next();

                        typeofrestaurant = switch (result1) {
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

                            System.out.println("-".repeat(34));
                            break n;
                        }
                    }
                    System.out.println(
                            Manager.editrestaurant(restaurantname, restaurantpass, edit, result, typeofrestaurant));
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

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            System.out.print(" Enter user's username you want to change information: ");
            String username = input.next();

            System.out.print(" Enter user's password you want to change information: ");
            String userpass = input.next();

            System.out.print(" 1)Edit firstname 2)Edit lastname 3)Edit phonenumber "
                    + "\n 4)Edit username 5)Edit password 6)Edit accesslevel 0)Exit\n select number: ");
            String result = input.next();

            AccessLevel accesslevel = AccessLevel.NOTHING;

            switch (result) {

                case "1" -> {

                    System.out.print(" Enter a new firstname for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, userpass, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }

                case "2" -> {
                    System.out.print(" Enter a new lastname for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, userpass, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "3" -> {
                    System.out.print(" Enter a new phonenumber for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, userpass, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "4" -> {
                    System.out.print(" Enter a new username for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, userpass, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "5" -> {
                    System.out.print(" Enter a new password for edit: ");
                    edit = input.next();
                    System.out.println(Manager.edituser(restaurantname, restaurantpass, username, userpass, edit, result,
                            AccessLevel.CASHIER));
                    break m;
                }
                case "6" -> {

                    n:
                    for (int j = 1; j > 0; j++) {

                        System.out.println(" 1)deliveryman 2)cashier 3)chef");
                        System.out.print(" Enter new access level(nmber): ");

                        String result1 = input.next();

                        accesslevel = switch (result1) {
                            case "1" ->
                                AccessLevel.DELIVERYMAN;
                            case "2" ->
                                AccessLevel.CASHIER;
                            case "3" ->
                                AccessLevel.CHEF;
                            default ->
                                AccessLevel.NOTHING;
                        };

                        if (accesslevel.equals(AccessLevel.NOTHING)) {

                            System.out.println(" Error: enter the correct number");
                            continue n;
                        } else {

                            System.out.println("-".repeat(34));
                            break n;
                        }
                    }
                    System.out.println(
                            Manager.edituser(restaurantname, restaurantpass, username, userpass, edit, result, accesslevel));
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

        System.out.print(" Enter restaurant's name you want remove: ");
        String restaurantname = input.next();

        System.out.print(" Enter restaurant's password you want remove: ");
        String restaurantpass = input.next();

        System.out.print(" Are you sure? 1)yes 2)no \n select number: ");
        String result = input.next();

        switch (result) {

            case "1" ->
                System.out.println(Manager.removerestaurant(restaurantname, restaurantpass));
            case "2" ->
                System.out.println(" canceled");
            default ->
                System.out.println(" Error: enter the correct number, try again");
        }
    }

    private static void removeuser() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.print(" Enter user's username you want remove: ");
        String username = input.next();

        System.out.print(" Enter user's password you want remove: ");
        String password = input.next();

        System.out.print(" Are you sure? 1)yes 2)no \n select number: ");
        String result = input.next();

        switch (result) {

            case "1" ->
                System.out.println(Manager.removeuser(restaurantname, restaurantpass, username, password));
            case "2" ->
                System.out.println(" canceled");
            default ->
                System.out.println(" Error: enter the correct number, try again");
        }
    }

    private static void chef() {

        Scanner input = new Scanner(System.in);

        loginchef();

        if (result) {

            m:
            for (int i = 1; i > 0; i++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Add food 2)Edit food 3)Remove food "
                        + "\n 4)Change food status 5)Show orders 6)Cook 7)Show foods"
                        + "\n 0)Logout\n select number: ");

                String manager = input.next();

                switch (manager) {

                    case "1" -> {

                        addfood();
                        break;
                    }
                    case "2" -> {

                        editfoodinfo();
                        break;
                    }
                    case "3" -> {

                        removefood();
                        break;
                    }
                    case "4" -> {

                        changefoodstatus();
                        break;
                    }
                    case "5" -> {

                        showordersforchef();
                        break;
                    }
                    case "6" -> {

                        cook();
                        break;
                    }
                    case "7" -> {

                        showfoods();
                        break;
                    }
                    case "0" -> {

                        break m;
                    }
                    default ->
                        System.out.println(" Error: enter the correct number");
                }
            }
        }
    }

    private static void loginchef() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.print("-".repeat(34) + " \n 1)Login 0)Exit\n select number: ");

            String login = input.next();

            switch (login) {

                case "1" -> {

                    System.out.print("-".repeat(34));
                    
                    System.out.print(" Enter your restaurant's name: ");
                    String restaurantname = input.next();

                    System.out.print(" Enter your restaurant's password: ");
                    String restaurantpass = input.next();

                    System.out.print(" Enter your username: ");
                    String username = input.next();

                    System.out.print(" Enter your password: ");
                    String password = input.next();

                    System.out.println(User.login(restaurantname, restaurantpass, username, password, "chef"));

                    if (User.login(restaurantname, restaurantpass, username, password, "chef").equals(ActionResult.SUCCESSLOGIN)) {

                        System.out.println("-".repeat(34) + "\n    Wellcome");
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

    private static void addfood() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int foodID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter food's ID (enter number between 3 and 10 digits): ");
                String foodid = input.next();

                if (foodid.length() < 10 && foodid.length() > 3) {

                    foodID = Integer.parseInt(foodid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            System.out.print(" Enter food's name: ");
            String foodname = input.next();

            System.out.print(" Enter number of ingredients: ");
            byte ingredientsnum = input.nextByte();

            String[] ingredients = new String[ingredientsnum];

            for (int j = 0; j < ingredientsnum; j++) {

                System.out.print(" Enter food's ingredient " + j++ + ": ");
                ingredients[j] = input.next();
            }

            boolean isAvailable = true;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" Is food available? 1)Yes 2)No 0)Exit\n select number: ");

                String isavailable = input.next();

                switch (isavailable) {

                    case "1" -> {

                        isAvailable = true;
                        break n;
                    }
                    case "2" -> {

                        isAvailable = false;
                        break n;
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

            Food newfood = new Food(foodID, foodname, ingredients, isAvailable);
            System.out.println(newfood.toString());

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        System.out.println(" Confirmed");
                        System.out.println(Chef.addFood(restaurantname, restaurantpass, newfood));
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

    private static void editfoodinfo() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int foodID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter food's ID you want to change information: ");
                String foodid = input.next();

                if (foodid.length() < 10 && foodid.length() > 3) {

                    foodID = Integer.parseInt(foodid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            int foodnewID = 0;

            String newname = "";

            String[] ingredients;

            d:
            for (int l = 1; l > 0; l++) {

                System.out.print(" 1)Edit food's ID 2)Edit food's name 3)Edit Ingredients " + " 0)Exit\n select number: ");
                String result = input.next();

                switch (result) {

                    case "1" -> {

                        n:
                        for (int j = 1; j > 0; j++) {

                            System.out.print(" Enter new food's ID: ");
                            String foodid = input.next();

                            if (foodid.length() < 10 && foodid.length() > 3) {

                                foodnewID = Integer.parseInt(foodid);
                                break n;
                            } else {

                                System.out.println("Error: Observe the range");

                                System.out.println("-".repeat(34));

                                b:
                                for (int k = 1; k > 0; k++) {

                                    System.out.print(" 1)Try again 0)Exit\n Select please: ");

                                    String record = input.next();

                                    switch (record) {

                                        case "1" -> {

                                            continue n;
                                        }
                                        case "0" -> {

                                            break m;
                                        }

                                        default -> {

                                            System.out.println(" Error: enter the correct number");
                                            System.out.println("-".repeat(34));
                                            continue b;
                                        }
                                    }
                                }
                            }
                        }

                        ingredients = new String[0];

                        System.out.println(Chef.editFood(restaurantname, restaurantpass, foodID, result, foodnewID, newname,
                                ingredients));
                        break m;
                    }

                    case "2" -> {

                        System.out.print(" Enter new food's name: ");
                        newname = input.next();

                        ingredients = new String[0];

                        System.out.println(Chef.editFood(restaurantname, restaurantpass, foodID, result, foodnewID, newname,
                                ingredients));
                        break m;
                    }
                    case "3" -> {

                        System.out.print(" Enter new number of ingredients: ");
                        byte ingredientsnum = input.nextByte();

                        ingredients = new String[ingredientsnum];

                        for (int j = 0; j < ingredientsnum; j++) {

                            System.out.print(" Enter new food's ingredient " + j++ + ": ");
                            ingredients[j] = input.next();
                        }

                        System.out.println(Chef.editFood(restaurantname, restaurantpass, foodID, result, foodnewID, newname,
                                ingredients));
                        break m;
                    }
                    case "0" -> {

                        break m;
                    }

                    default -> {

                        System.out.println(" Error: enter the correct number");
                        continue d;
                    }
                }
            }

        }
    }

    private static void removefood() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int foodID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter food's ID you want remove: ");
                String foodid = input.next();

                if (foodid.length() < 10 && foodid.length() > 3) {

                    foodID = Integer.parseInt(foodid);
                    break;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }
            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Are you sure? 1)yes 2)no \n select number: ");
                String result = input.next();

                switch (result) {

                    case "1" -> {

                        System.out.println(Chef.removeFood(restaurantname, restaurantpass, foodID));
                        break m;
                    }
                    case "2" -> {
                        System.out.println(" canceled");
                        break m;
                    }
                    default -> {
                        System.out.println(" Error: enter the correct number, try again");
                        System.out.println("-".repeat(34));
                        continue n;
                    }
                }
            }
        }
    }

    private static void changefoodstatus() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int foodID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter food's ID you want change state: ");
                String foodid = input.next();

                if (foodid.length() < 10 && foodid.length() > 3) {

                    foodID = Integer.parseInt(foodid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            boolean isAvailable = true;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" Is food available? 1)Yes 2)No 0)Exit\n select number: ");

                String isavailable = input.next();

                switch (isavailable) {

                    case "1" -> {

                        isAvailable = true;
                        break n;
                    }
                    case "2" -> {

                        isAvailable = false;
                        break n;
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

            System.out.println(Chef.changeFoodStatus(restaurantname, restaurantpass, foodID, isAvailable));
            break;
        }
    }

    private static void showordersforchef() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.println(Chef.showorders(restaurantname, restaurantpass));
    }

    private static void cook() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int orderID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter order's ID you want cook: ");
                String orderid = input.next();

                if (orderid.length() < 10 && orderid.length() > 3) {

                    orderID = Integer.parseInt(orderid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            System.out.println(Chef.cook(restaurantname, restaurantpass, orderID));
            break;
        }
    }

    private static void showfoods() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.println(Chef.showfoods(restaurantname, restaurantpass));
    }

    private static void cashier() {

        Scanner input = new Scanner(System.in);

        logincashier();

        if (result) {

            m:
            for (int i = 1; i > 0; i++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Show orders 2)Show foods 3)Confirm order 0)Logout\n select number: ");

                String manager = input.next();

                switch (manager) {

                    case "1" -> {

                        showordersforcashier();
                        break;
                    }
                    case "2" -> {

                        showfoods();
                        break;
                    }
                    case "3" -> {

                        confirmorder();
                        break;
                    }
                    case "0" -> {

                        break m;
                    }
                    default ->
                        System.out.println(" Error: enter the correct number");
                }
            }
        }
    }

    private static void logincashier() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.print("-".repeat(34) + " \n 1)Login 0)Exit\n select number: ");

            String login = input.next();

            switch (login) {

                case "1" -> {

                    System.out.print("-".repeat(34));
                    
                    System.out.print(" Enter your restaurant's name: ");
                    String restaurantname = input.next();

                    System.out.print(" Enter your restaurant's password: ");
                    String restaurantpass = input.next();

                    System.out.print(" Enter your username: ");
                    String username = input.next();

                    System.out.print(" Enter your password: ");
                    String password = input.next();

                    System.out.println(User.login(restaurantname, restaurantpass, username, password, "cashier"));

                    if (User.login(restaurantname, restaurantpass, username, password, "cashier").equals(ActionResult.SUCCESSLOGIN)) {

                        System.out.println("-".repeat(34) + "\n    Wellcome");
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

    private static void showordersforcashier() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.println(Cashier.showorders(restaurantname, restaurantpass));
    }

    private static void confirmorder() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int orderID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter order's ID you want confirm: ");
                String orderid = input.next();

                if (orderid.length() < 10 && orderid.length() > 3) {

                    orderID = Integer.parseInt(orderid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            System.out.println(Cashier.confirmOrder(restaurantname, restaurantpass, orderID));
            break;
        }
    }

    private static void deliveryman() {

        Scanner input = new Scanner(System.in);

        logindeliveryman();

        if (result) {

            m:
            for (int i = 1; i > 0; i++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Show orders 2)Deliver 0)Logout\n select number: ");

                String manager = input.next();

                switch (manager) {

                    case "1" -> {

                        showordersfordeliveryman();
                        break;
                    }
                    case "2" -> {

                        deliver();
                        break;
                    }
                    case "0" -> {

                        break m;
                    }
                    default ->
                        System.out.println(" Error: enter the correct number");
                }
            }
        }
    }

    private static void logindeliveryman() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.print("-".repeat(34) + " \n 1)Login 0)Exit\n select number: ");

            String login = input.next();

            switch (login) {

                case "1" -> {

                    System.out.print("-".repeat(34));
                    
                    System.out.print(" Enter your restaurant's name: ");
                    String restaurantname = input.next();

                    System.out.print(" Enter your restaurant's password: ");
                    String restaurantpass = input.next();

                    System.out.print(" Enter your username: ");
                    String username = input.next();

                    System.out.print(" Enter your password: ");
                    String password = input.next();

                    System.out.println(User.login(restaurantname, restaurantpass, username, password, "deliveryman"));

                    if (User.login(restaurantname, restaurantpass, username, password, "deliveryman").equals(ActionResult.SUCCESSLOGIN)) {

                        System.out.println("-".repeat(34) + "\n    Wellcome");
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

    private static void showordersfordeliveryman() {

        Scanner input = new Scanner(System.in);

        System.out.println("-".repeat(34));

        System.out.print(" Enter your restaurant's name: ");
        String restaurantname = input.next();

        System.out.print(" Enter your restaurant's password: ");
        String restaurantpass = input.next();

        System.out.println(DeliveryMan.showorders(restaurantname, restaurantpass));
    }

    private static void deliver() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your restaurant's name: ");
            String restaurantname = input.next();

            System.out.print(" Enter your restaurant's password: ");
            String restaurantpass = input.next();

            int orderID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter order's ID you want deliver: ");
                String orderid = input.next();

                if (orderid.length() < 10 && orderid.length() > 3) {

                    orderID = Integer.parseInt(orderid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            System.out.println(DeliveryMan.deliver(restaurantname, restaurantpass, orderID));
            break;
        }
    }

    private static void client() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" 1)Register 2)Login 0)Exit\n select number: ");

            String enter = input.next();

            switch (enter) {

                case "1" -> {

                    newclient();
                    if (result) {
                        break m;
                    }
                    break;
                }

                case "2" -> {

                    loginclient();
                    if (result) {
                        break m;
                    }
                    break;
                }

                case "0" -> {

                    result = false;
                    break m;
                }

                default ->
                    System.out.println(" Error: enter the correct number");
            }
        }

        if (result) {

            m:
            for (int i = 1; i > 0; i++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Make order 2)Revoke order 3)Show your order information" + " 0)Logout\n select number: ");

                String manager = input.next();

                switch (manager) {

                    case "1" -> {

                        makeorder();
                        break;
                    }
                    case "2" -> {

                        revokeorder();
                        break;
                    }
                    case "3" -> {

                        showorderstate();
                        break;
                    }
                    case "0" -> {

                        break m;
                    }
                    default ->
                        System.out.println(" Error: enter the correct number");
                }
            }
        }
    }

    private static void newclient() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Enter your firstname: ");
            String firstname = input.next();

            System.out.print(" Enter your lastname: ");
            String lastname = input.next();

            System.out.print(" Enter your phoneNumber: ");
            String phoneNumber = input.next();

            System.out.print(" Enter username: ");
            String username = input.next();

            System.out.print(" Enter password: ");
            String password = input.next();

            AccessLevel accesslevel = AccessLevel.CLIENT;

            Date today = new Date();

            Client newclient = new Client(firstname, lastname, phoneNumber, username, password, accesslevel, today,
                    today);

            System.out.println(newclient.toString());

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        long numberofclients = Restaurants.clients.size();

                        Restaurants.clients.add(newclient);

                        if (numberofclients == Restaurants.clients.size() - 1) {

                            System.out.println(" Confirmed");
                            result = true;
                            break m;
                        } else {

                            System.out.println(" Not confirm");
                            result = false;
                            break;
                        }
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

    private static void loginclient() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            System.out.print("-".repeat(34) + " \n 1)Login 0)Exit\n select number: ");

            String login = input.next();

            switch (login) {

                case "1" -> {

                    System.out.print("-".repeat(34));
                    
                    System.out.print(" Enter your username: ");
                    String username = input.next();

                    System.out.print(" Enter your password: ");
                    String password = input.next();

                    for (int j = 0; j < Restaurants.clients.size(); j++) {

                        if (Restaurants.clients.get(j).username.equals(username)
                                && Restaurants.clients.get(j).password.equals(password)) {

                            System.out.println("-".repeat(34) + "\n    Wellcome");
                            result = true;
                            break m;
                        }
                    }

                    System.out.println(" Login failed");
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

    private static void makeorder() {

        Scanner input = new Scanner(System.in);

        Client.showrestaurants();

        m:
        for (int i = 1; i > 0; i++) {

            System.out.println("-".repeat(34));

            System.out.print(" Select restaurant's name: ");
            String restaurantname = input.next();

            int orderID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter order's ID (enter number between 3 and 10 digits): ");
                String orderid = input.next();

                if (orderid.length() < 10 && orderid.length() > 3) {

                    orderID = Integer.parseInt(orderid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            Client.showfoods(restaurantname);

            int foodID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter food's ID: ");
                String foodid = input.next();

                if (foodid.length() < 10 && foodid.length() > 3) {

                    foodID = Integer.parseInt(foodid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            Date today = new Date();

            System.out.print(" Enter your address: ");
            String address = input.next();

            Order neworder = new Order(orderID, foodID, OrderState.MADE, today, address);
            System.out.println(neworder.toString());

            n:
            for (int j = 1; j > 0; j++) {

                System.out.println("-".repeat(34));

                System.out.print(" 1)Confirm 2)Cancel 0)Exit\n Select please: ");

                String record = input.next();

                switch (record) {

                    case "1" -> {

                        System.out.println(" Confirmed");
                        System.out.println(Client.makeOrder(restaurantname, neworder));
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

    private static void revokeorder() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            Client.showrestaurants();

            System.out.println("-".repeat(34));

            System.out.print(" Enter restaurant's name where you orderd: ");
            String restaurantname = input.next();

            int orderID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter your order's ID you want revoke: ");
                String orderid = input.next();

                if (orderid.length() < 10 && orderid.length() > 3) {

                    orderID = Integer.parseInt(orderid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }

                }
            }

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Are you sure? 1)yes 2)no \n select number: ");
                String result = input.next();

                switch (result) {

                    case "1" -> {

                        System.out.println(Client.revokeOrder(restaurantname, orderID));
                        break m;
                    }
                    case "2" -> {
                        System.out.println(" canceled");
                        break m;
                    }
                    default -> {
                        System.out.println(" Error: enter the correct number, try again");
                        System.out.println("-".repeat(34));
                        continue n;
                    }
                }
            }
        }
    }

    private static void showorderstate() {

        Scanner input = new Scanner(System.in);

        m:
        for (int i = 1; i > 0; i++) {

            Client.showrestaurants();

            System.out.println("-".repeat(34));

            System.out.print(" Enter restaurant's name where you orderd: ");
            String restaurantname = input.next();

            int orderID = 0;

            n:
            for (int j = 1; j > 0; j++) {

                System.out.print(" Enter your order's ID you want show: ");
                String orderid = input.next();

                if (orderid.length() < 10 && orderid.length() > 3) {

                    orderID = Integer.parseInt(orderid);
                    break n;
                } else {

                    System.out.println("Error: Observe the range");

                    System.out.println("-".repeat(34));

                    b:
                    for (int k = 1; k > 0; k++) {

                        System.out.print(" 1)Try again 0)Exit\n Select please: ");

                        String record = input.next();

                        switch (record) {

                            case "1" -> {

                                continue n;
                            }
                            case "0" -> {

                                break m;
                            }

                            default -> {

                                System.out.println(" Error: enter the correct number");
                                System.out.println("-".repeat(34));
                                continue b;
                            }
                        }
                    }
                }
            }

            System.out.println(Client.showorderstate(restaurantname, orderID));
        }
    }
}
