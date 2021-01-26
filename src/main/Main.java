package main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        System.out.println("           Hello \n Wellcome to the restaurant");
        
        System.out.println("-".repeat(28));
        
        System.out.println(" 1)manager 2)cashier 3)chef 4)deliveryman 5)client");
        
        System.out.print(" Select your access level's number:");

        byte accesslevelnumber = input.nextByte();
        
        switch(accesslevelnumber){
            
            case 1 -> manager();
            case 2 -> System.out.println("-".repeat(28) + " \nplease login");
            case 3 -> System.out.println("-".repeat(28) + " \nplease login");
            case 4 -> System.out.println("-".repeat(28) + " \nplease login");
            default -> System.out.println("");
        }
        
        input.close();
    }
}
