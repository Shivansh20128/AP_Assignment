package com.brickBracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("CoWin Portal initialized...");
        System.out.println("-------------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add slot for vaccination");
        System.out.println("5. Book slot for vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check vaccination status");
        System.out.println("8. Exit");
        System.out.println("-------------------------------------");
        Scanner scan = new Scanner(System.in);
        int option_no;
        Boolean exit=false;
        while(!exit){
            option_no= scan.nextInt();
            switch(option_no){
                case 1:
                    System.out.println("Adding vaccine");
                    Vaccines vaccine=new Vaccines();
                    //some function
                    break;
                case 2:
                    System.out.println("Registering a hospital");
                    //some function
                    break;
                case 3:
                    System.out.println("Registering a citizen");
                    //some function
                    break;
                case 4:
                    System.out.println("Adding slot for vaccination");
                    //some function
                    break;
                case 5:
                    System.out.println("Booking slot for vaccination");
                    //some function
                    break;
                case 6:
                    System.out.println("List of all slots for a hospital");
                    //some function
                    break;
                case 7:
                    System.out.println("Checking vaccination status");
                    //some function
                    break;
                case 8:
                    System.out.println("Exit");
                    exit=true;
                    break;
            }
        }

    }
}
