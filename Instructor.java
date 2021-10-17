package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Instructor implements User{
    private int id;
    private BackPack_Portal _portal;
    private Instructor _instructor;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    static ArrayList<Videos> video_list = new ArrayList<>();
    static ArrayList<ArrayList<String>> slides_array= new ArrayList<>();
    static ArrayList<Assignment> assignment_array= new ArrayList<>();
    static ArrayList<Quiz> quiz_array= new ArrayList<>();

    public Instructor(){ }

    public void login(BackPack_Portal portal,Instructor instructor,int n){
        this._portal=portal;
        this._instructor=instructor;
        _instructor.id=n;
        System.out.println("Welcome I"+_instructor.id);
        instructor_portal();
    }
    public void instructor_portal(){
        System.out.println("""
                INSTRUCTOR MENU
                1. Add class material
                2. Add assessments
                3. View lecture materials
                4. View assessments
                5. Grade assessments
                6. Close assessment
                7. View comments
                8. Add comments
                9. Logout""");
        int choice_no = scan.nextInt();
        switch(choice_no){
            case 1:
                add_material();
                instructor_portal();
            case 2:
                add_assessment();
                instructor_portal();
            case 3:
                //some func
            case 4:
                //some func
            case 5:
                //some func
            case 6:
                //some func
            case 7:
                //some func
            case 8:
                add_comments();
                instructor_portal();
            case 9:
                _portal.login();


        }

    }
    private void add_material(){
        System.out.println("1. Add Lecture Slide\n" +
                           "2. Add Lecture Video");
        int x = scan.nextInt();
        if(x==1){
            new Slides();
        }
        else if(x==2){
            new Videos();
        }
    }

    private void add_assessment(){
        System.out.println("1. Add Assignment\n" +
                           "2. Add Quiz");
        int x = scan.nextInt();
        if(x==1){
            new Assignment();
        }
        else if(x==2){
            new Quiz();
        }

    }

    private void grade_assessment(){

    }

    private void close_assessment(){

    }



    @Override
    public void View_lectures(){

    }

    @Override
    public void View_assessments(){

    }

    @Override
    public void View_comments(){

    }

    @Override
    public void add_comments(){
        new Comment();
    }

    private void logout(){

    }
}
