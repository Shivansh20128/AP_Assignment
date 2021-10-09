package com.brickBracker;


import java.util.ArrayList;
import java.util.Scanner;

public class Slot {
    int day_no;
    int quantity;
    String Hospital_ID;
    int no_of_slots;
    Vaccines vac;
    static ArrayList<ArrayList<Slot>> slot_array = new ArrayList<ArrayList<Slot>>();

    Scanner scan = new Scanner(System.in);
    public Slot(){
        this.add_slot();
    }

    public void add_slot() {

        System.out.print("Enter Hospital ID: ");
        this.Hospital_ID=scan.next();
        System.out.print("Enter number of Slots to be added: ");
        this.no_of_slots=scan.nextInt();
        ArrayList<Slot> col = new ArrayList<>(this.no_of_slots);
        ArrayList<String> col1 = new ArrayList<>(this.no_of_slots);
        for(int k=0;k<this.no_of_slots;k++) {
            col.add(this);
            System.out.print("Enter Day Number: ");
            this.day_no = scan.nextInt();
            System.out.print("Enter Quantity: ");
            this.quantity = scan.nextInt();
            System.out.println("Select Vaccine");
            for (int i = 0; i < Vaccines.vaccine_array.size(); i++) {
                System.out.println(i + ". " + Vaccines.vaccine_array.get(i).Name);
            }
            int pos = scan.nextInt();
            this.vac = Vaccines.vaccine_array.get(pos);

            col1.add("Day: "+this.day_no+" Vaccine: "+this.vac.Name+" Available Qty: "+this.quantity);
            System.out.println(col1.get(0));
            if(col.size()>1){
                System.out.println(col1.get(1));
            }

            System.out.println("Slot added by Hospital "+this.Hospital_ID+ " for Day: "+this.day_no+ ", Available Quantity: "+this.quantity+" of Vaccine "+this.vac.Name);
        }
//        System.out.println(col.get(0).day_no+" "+ col.get(0).quantity+" "+col.get(0).vac.Name);
//        System.out.println(col.get(1).day_no+" "+ col.get(1).quantity+" "+col.get(1).vac.Name);
        slot_array.add(col);

    }

    public static void print(){
        for(int i=0;i<slot_array.size();i++){
            System.out.println("hello1");
            for(int l=0;l<slot_array.get(i).size();l++){
                System.out.println("hello2");
                System.out.println(slot_array.get(i).get(l).quantity);
                if(slot_array.get(i).get(l).quantity==5){
                    System.out.println(slot_array.get(i).get(l).vac.Name);
                    System.out.println("hello");
            }

            }
//            System.out.println(vaccine_array.get(i).No_of_doses);
        }
    }
    public static void print_slots(String ID){

        for(int i=0;i<slot_array.size();i++){
            for(int j=0;j<slot_array.get(i).size();j++){
                if(slot_array.get(i).get(j).Hospital_ID.equals(ID)){
                    System.out.println("Day: "+slot_array.get(i).get(j).day_no+" Vaccine: "+slot_array.get(i).get(j).vac.Name+" Available Qty: "+slot_array.get(i).get(j).quantity);
                }
            }
        }
    }
}
