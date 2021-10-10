package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Vaccines {
    static Scanner scan = new Scanner(System.in);
    String Name;
    static int index;
    static String patient_name;
    int No_of_doses;
    int gap_bw_doses;
    static ArrayList<Vaccines> vaccine_array = new ArrayList<Vaccines>();
    public Vaccines(){
        this.add_vaccine();
    }
    public void add_vaccine(){
        vaccine_array.add(this);
        System.out.print("Vaccine Name: ");
        this.Name=scan.next();
        System.out.print("Number of doses: ");
        this.No_of_doses= scan.nextInt();
        System.out.print("Gap between doses: ");
        this.gap_bw_doses=scan.nextInt();
        System.out.println("Vaccine Name: "+this.Name + ", Number of doses: "+this.No_of_doses+", Gap between doses: "+this.gap_bw_doses);
    }

    public static void search_vaccine(String citizen_ID){
        System.out.print("Enter Vaccine name: ");
        String name=scan.next();
        for(int j=0;j<vaccine_array.size();j++){
            if(vaccine_array.get(j).Name.equals(name)){
                System.out.println(Hospitals.hospital_array.get(j).Unique_id+" "+ Hospitals.hospital_array.get(j).Name);
            }
        }
        System.out.print("Enter hospital ID: ");
        String ID = scan.next();

        for(index=0;index<Slot.slot_array.size();index++){
            if(Slot.slot_array.get(index).get(0).Hospital_ID.equals(ID)) {
                for (int k = 0; k < Slot.slot_array.get(index).size(); k++) {
                    System.out.println(index + "->" + "Day: " + Slot.slot_array.get(index).get(k).day_no + " Vaccine: " + Slot.slot_array.get(index).get(k).vac.Name + " Available Qty: " + Slot.slot_array.get(index).get(k).quantity);
                }
                break;
            }
            else System.out.println("No Slots available");

        }
        System.out.print("Choose slot: ");
        int num = scan.nextInt();

        for(int l=0;l<Citizens.citizen_array.size();l++){
            if(Citizens.citizen_array.get(l).Unique_id.equals(citizen_ID)){
                patient_name=Citizens.citizen_array.get(l).Name;
            }
        }
        System.out.println(patient_name+" vaccinated with "+Slot.slot_array.get(index).get(num).vac.Name);
        Citizens.citizen_array.get(index).vaccine.Name=Slot.slot_array.get(index).get(num).vac.Name;
        Citizens.citizen_array.get(index).No_of_doses++;
    }
//    public static void print(){
//        for(int i=0;i<vaccine_array.size();i++){
//            if(vaccine_array.get(i).Name.equals("covin")){
//                System.out.println(vaccine_array.get(i).gap_bw_doses);
//            }
////            System.out.println(vaccine_array.get(i).No_of_doses);
//        }
//    }
}
