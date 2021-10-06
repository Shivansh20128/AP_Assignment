package com.brickBracker;

import java.util.Scanner;

public class Vaccines {
    Scanner scan = new Scanner(System.in);
    String Name;
    int No_of_doses;
    int gap_bw_doses;
    public Vaccines(){
        this.add_vaccine();
    }
    public void add_vaccine(){
        System.out.print("Vaccine Name: ");
        this.Name=scan.next();
        System.out.print("Number of doses: ");
        this.No_of_doses= scan.nextInt();
        System.out.print("Gap between doses: ");
        this.gap_bw_doses=scan.nextInt();
        System.out.println("Vaccine Name: "+this.Name + ", Number of doses: "+this.No_of_doses+", Gap between doses: "+this.gap_bw_doses);
    }
}
