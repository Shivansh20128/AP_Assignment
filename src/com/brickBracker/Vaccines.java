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
        if(this.No_of_doses>1) {
            System.out.print("Gap between doses: ");
            this.gap_bw_doses = scan.nextInt();
        }else{
            this.gap_bw_doses=0;
        }
        System.out.println("Vaccine Name: "+this.Name + ", Number of doses: "+this.No_of_doses+", Gap between doses: "+this.gap_bw_doses);
    }
    public static int get_no_of_doses(Vaccines vac){
        for(int p=0;p<vaccine_array.size();p++){
            if(vaccine_array.get(p).Name.equals(vac.Name)){
                return vaccine_array.get(p).No_of_doses;
            }
        }
        return 0;
    }
    public static void search_vaccine(String citizen_ID){
        System.out.print("Enter Vaccine name: ");
        String name=scan.next();
        for(int j=0;j<Slot.slot_array.size();j++){
            for(int m=0;m<Slot.slot_array.get(j).size();m++)
            if(Slot.slot_array.get(j).get(m).vac.Name.equals(name)){
                System.out.println(Hospitals.hospital_array.get(j).Unique_id+" "+ Hospitals.hospital_array.get(j).Name);
            }
        }
        System.out.print("Enter hospital ID: ");
        String ID = scan.next();
        boolean cond=false;
        for(index=0;index<Slot.slot_array.size();index++){
            if(Slot.slot_array.get(index).get(0).Hospital_ID.equals(ID)) {


                for (int k = 0; k < Slot.slot_array.get(index).size(); k++) {
                    if(Slot.slot_array.get(index).get(k).day_no>=Citizens.get_due_date(citizen_ID) && Slot.slot_array.get(index).get(k).vac.Name.equals(name)) {
                        cond=true;
                        System.out.println(k+"-> Day: " + Slot.slot_array.get(index).get(k).day_no + " Vaccine: " + Slot.slot_array.get(index).get(k).vac.Name + " Available Qty: " + Slot.slot_array.get(index).get(k).quantity);
                    }
                }
                break;
            }
        }
        if(!cond){
            System.out.println("No Slots available");
        }
        if(cond) {
            System.out.print("Choose slot: ");
            int num = scan.nextInt();
            int l;
            for (l = 0; l < Citizens.citizen_array.size(); l++) {
                if (Citizens.citizen_array.get(l).Unique_id.equals(citizen_ID)) {
                    patient_name = Citizens.citizen_array.get(l).Name;
                    break;
                }
            }
            System.out.println(patient_name + " vaccinated with " + Slot.slot_array.get(index).get(num).vac.Name);
            Slot.slot_array.get(index).get(num).quantity--;
            Citizens.citizen_array.get(l).vaccine = Slot.slot_array.get(index).get(num).vac;
            Citizens.citizen_array.get(l).No_of_doses++;
        }
    }

}
