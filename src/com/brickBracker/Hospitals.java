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
    public static String six_digit_number() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    public void register() {
        this.Unique_id=six_digit_number();
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
                    System.out.println(k +"-> Day: " + Slot.slot_array.get(index).get(k).day_no + " Available Qty: " + Slot.slot_array.get(index).get(k).quantity+" Vaccine: " + Slot.slot_array.get(index).get(k).vac.Name);
                }
                break;
            }
            else{
                System.out.println("No Slots Available");
            }

        }
        System.out.print("Choose slot: ");
        int num = scan.nextInt();

        for(int l=0;l<Citizens.citizen_array.size();l++){
            if(Citizens.citizen_array.get(l).Unique_id.equals(citizen_ID)){
                patient_name=Citizens.citizen_array.get(l).Name;
                break;
            }

        }
        System.out.println(patient_name+" vaccinated with "+Slot.slot_array.get(index).get(num).vac.Name);
        Slot.slot_array.get(index).get(num).quantity--;
        Citizens.citizen_array.get(index).vaccine=Slot.slot_array.get(index).get(num).vac;
        Citizens.citizen_array.get(index).No_of_doses++;
    }

}
