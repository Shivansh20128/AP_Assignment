package com.brickBracker;


import java.util.ArrayList;
import java.util.Scanner;

public class Slot {
    int day_no;
    int quantity;
    String Hospital_ID;
    int no_of_slots;
    Vaccines vac;

    static ArrayList<ArrayList<Slot>> slot_array = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    public Slot(){
        this.add_slot();
    }
    public Slot(int x){  }
    public void add_slot() {

        System.out.print("Enter Hospital ID: ");
        this.Hospital_ID=scan.next();
        System.out.print("Enter number of Slots to be added: ");
        this.no_of_slots=scan.nextInt();
        ArrayList<Slot> col = new ArrayList<>(this.no_of_slots);

        for(int k=0;k<this.no_of_slots;k++) {
            Slot new_slot = new Slot(k);
            col.add(new_slot);
            new_slot.Hospital_ID=this.Hospital_ID;
            System.out.print("Enter Day Number: ");
            new_slot.day_no = scan.nextInt();
            System.out.print("Enter Quantity: ");
            new_slot.quantity = scan.nextInt();
            System.out.println("Select Vaccine");
            for (int i = 0; i < Vaccines.vaccine_array.size(); i++) {
                System.out.println(i + ". " + Vaccines.vaccine_array.get(i).Name);
            }
            int pos = scan.nextInt();
            new_slot.vac = Vaccines.vaccine_array.get(pos);


            System.out.println("Slot added by Hospital "+this.Hospital_ID+ " for Day: "+new_slot.day_no+ ", Available Quantity: "+new_slot.quantity+" of Vaccine "+new_slot.vac.Name);
        }

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
