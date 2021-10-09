package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Citizens {
    String Name;
    int Age;
    Vaccines vaccine;
    int No_of_doses=0;
    String Unique_id;
    String Status;
    Scanner scan = new Scanner(System.in);
    static ArrayList<Citizens> citizen_array = new ArrayList<Citizens>();
    public Citizens(){
        this.register();
    }

    public void register() {

        System.out.print("Citizen Name: ");
        this.Name=scan.next();
        System.out.print("Age: ");
        this.Age=scan.nextInt();
        System.out.print("Unique ID: ");
        this.Unique_id=scan.next();
        System.out.println("Citizen Name: "+this.Name+", Age: "+this.Age+", Unique ID: "+this.Unique_id);
        if(this.Age>=18){
            citizen_array.add(this);
            System.out.println("Registered!");
        }
        else{
            System.out.println("Only above 18 are allowed");
        }
    }

    public static void get_status(String ID){
        for(int i=0;i<citizen_array.size();i++){
            if(citizen_array.get(i).Unique_id.equals(ID)){
                System.out.println(citizen_array.get(i).Status);
                System.out.println("Vaccine Given: "+citizen_array.get(i).vaccine.Name);
                System.out.println("Number of doses given: "+citizen_array.get(i).No_of_doses);
            }
        }
    }
}
