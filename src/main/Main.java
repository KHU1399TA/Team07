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

                    //newmanager();
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
}
