package com.brickBracker;

import java.util.Scanner;

public class BackPack_Portal {

    Instructor I0 = new Instructor();
    Instructor I1 = new Instructor();

    Student S0 = new Student();
    Student S1 = new Student();
    Student S2 = new Student();

    Scanner scan = new Scanner(System.in);
    public BackPack_Portal(){
        this.login();
    }

    public void login() {
        System.out.println("1.Enter as Instructor");
        System.out.println("2.Enter as Student");
        System.out.println("3.Exit");
        int login_choice = scan.nextInt();
        switch(login_choice){
            case 1:
                System.out.println("Instructors");
                System.out.println("0 - I0");
                System.out.println("1 - I1");
                System.out.print("Choose id: ");
                int instructor_choice = scan.nextInt();
                if(instructor_choice==0){
                    I0.login(this,I0,instructor_choice);
                }
                else if(instructor_choice==1){
                    I1.login(this,I1,instructor_choice);
                }
                else{
                    System.out.println("Wrong id!");
                }
                // more functions
                break;
            case 2:
                System.out.println("Students");
                // more functions
                break;
            case 3:
                System.out.println("---End---");
                break;
        }
    }


}
