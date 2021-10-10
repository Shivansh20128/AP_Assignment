package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < Slot.slot_array.size(); i++)  {
            Slot.slot_array.add(new ArrayList<Slot>());
        }
        System.out.println("CoWin Portal initialized...");

        Scanner scan = new Scanner(System.in);
        int option_no;
        boolean exit=false;
        while(!exit){
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
            option_no= scan.nextInt();
            switch(option_no){
                case 1:
                    System.out.println("Adding vaccine");
                    new Vaccines();
                    break;
                case 2:
                    System.out.println("Registering a hospital");
                    new Hospitals();
                    break;
                case 3:
                    System.out.println("Registering a citizen");
                    new Citizens();
                    break;
                case 4:
                    System.out.println("Adding slot for vaccination");
                    new Slot();
                    break;
                case 5:
                    System.out.println("Booking slot for vaccination");
                    System.out.print("Enter Patient Unique ID: ");
                    String patient_ID = scan.next();
                    for(int i=0;i<Citizens.citizen_array.size();i++){
                        if(Citizens.citizen_array.get(i).Unique_id.equals(patient_ID)){
                            System.out.println("1. Search by area");
                            System.out.println("2. Search by Vaccine");
                            System.out.println("3. Exit");
                            System.out.print("Enter option: ");
                            int search = scan.nextInt();
                            if(search==1){
                                Hospitals.search_hosp(patient_ID);
                                if(Citizens.citizen_array.get(i).No_of_doses<Vaccines.get_no_of_doses(Citizens.citizen_array.get(i).vaccine)){
                                    Citizens.citizen_array.get(i).Status="PARTIALLY VACCINATED";
                                }else if(Citizens.citizen_array.get(i).No_of_doses==Vaccines.get_no_of_doses(Citizens.citizen_array.get(i).vaccine)){
                                    Citizens.citizen_array.get(i).Status="FULLY VACCINATED";
                                }

                            }else if(search==2){
                                Vaccines.search_vaccine(patient_ID);
                                if(Citizens.citizen_array.get(i).No_of_doses<Vaccines.get_no_of_doses(Citizens.citizen_array.get(i).vaccine)){
                                    Citizens.citizen_array.get(i).Status="PARTIALLY VACCINATED";
                                }else if(Citizens.citizen_array.get(i).No_of_doses==Vaccines.get_no_of_doses(Citizens.citizen_array.get(i).vaccine)){
                                    Citizens.citizen_array.get(i).Status="FULLY VACCINATED";
                                }

                            }else if(search==3){
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("List of all slots for a hospital");
                    System.out.print("Enter hospital ID: ");
                    String ID=scan.next();
                    for(int i=0;i<Slot.slot_array.size();i++){
                        if(Slot.slot_array.get(i).get(0).Hospital_ID.equals(ID)){
                            Slot.print_slots(ID);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Checking vaccination status");
                    System.out.print("Enter patient ID: ");
                    patient_ID = scan.next();

                    Citizens.get_status(patient_ID);
                    break;
                case 8:
                    System.out.println("---END---");
                    exit=true;
                    break;
            }
        }
    }
}
