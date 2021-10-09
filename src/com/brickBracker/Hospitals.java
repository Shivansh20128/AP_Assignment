package com.brickBracker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hospitals {
    static Scanner scan = new Scanner(System.in);
    static String patient_name;
    static int index;
    String Name;
    int Pincode;
    String Unique_id;
    static ArrayList<Hospitals> hospital_array = new ArrayList<Hospitals>();

    public Hospitals(){
        this.register();
    }
    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    public void register() {
        this.Unique_id=getRandomNumberString();
        hospital_array.add(this);
        System.out.print("Hospital Name: ");
        this.Name=scan.next();
        System.out.print("PINCODE: ");
        this.Pincode=scan.nextInt();
        System.out.println("Hospital Name: "+this.Name+", Pincode: "+this.Pincode+", Unique ID: "+this.Unique_id);
    }
    public static void search_hosp(String citizen_ID){
        System.out.print("Enter Pincode: ");
        int pin=scan.nextInt();
        for(int j=0;j<hospital_array.size();j++){
            if(hospital_array.get(j).Pincode==pin){
                System.out.println(hospital_array.get(j).Unique_id+" "+ hospital_array.get(j).Name);
            }
        }
        System.out.print("Enter hospital ID: ");
        String ID = scan.next();

        for(index=0;index<Slot.slot_array.size();index++){
            if(Slot.slot_array.get(index).get(0).Hospital_ID.equals(ID)) {
                for (int k = 0; k < Slot.slot_array.get(index).size(); k++) {
                    System.out.println(index + "->" + "Day: " + Slot.slot_array.get(index).get(k).day_no + " Vaccine: " + Slot.slot_array.get(index).get(k).vac.Name + " Available Qty: " + Slot.slot_array.get(index).get(k).quantity);
                }
            }
            break;
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
//        for(int i=0;i<hospital_array.size();i++){
//            if(hospital_array.get(i).Name.equals("medanta")){
//                System.out.println(hospital_array.get(i).Pincode);
//            }
////            System.out.println(vaccine_array.get(i).No_of_doses);
//        }
//    }
}
