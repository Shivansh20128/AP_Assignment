package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Instructor implements User{
    public int id;
    private BackPack_Portal _portal;
    private Instructor _instructor;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    static ArrayList<Videos> video_list = new ArrayList<>();
    static ArrayList<ArrayList<Slides>> slides_array= new ArrayList<>();
    static ArrayList<Assignment> assignment_array= new ArrayList<>();
    static ArrayList<Quiz> quiz_array= new ArrayList<>();

    public Instructor(){ }

    public void login(BackPack_Portal portal,Instructor instructor,int n,Student x,Student y,Student z,Instructor a,Instructor b){
        this._portal=portal;
        this._instructor=instructor;
        _instructor.id=n;
        System.out.println("Welcome I"+_instructor.id);
        instructor_portal(x,y,z,a,b);
    }
    public void instructor_portal(Student x,Student y,Student z,Instructor a,Instructor b){
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
                add_material(_instructor);
                instructor_portal(x,y,z,a,b);
                break;
            case 2:
                add_assessment(x,y,z);
                instructor_portal(x,y,z,a,b);
                break;
            case 3:
                View_lectures();
                instructor_portal(x,y,z,a,b);
                break;
            case 4:
                View_assessments();
                instructor_portal(x,y,z,a,b);
                break;
            case 5:
                grade_assessment(x,y,z);
                instructor_portal(x,y,z,a,b);
                break;
            case 6:
                close_assessment(x,y,z);
                instructor_portal(x,y,z,a,b);
                break;
            case 7:
                View_comments(x,y,z,a,b);
                instructor_portal(x,y,z,a,b);
                break;
            case 8:
                add_comments();
                instructor_portal(x,y,z,a,b);
                break;
            case 9:
                _portal.login();
                break;


        }

    }
    private void add_material(Instructor instructor){
        System.out.println("1. Add Lecture Slide\n" +
                           "2. Add Lecture Video");
        int x = scan.nextInt();
        if(x==1){
            new Slides(instructor);
        }
        else if(x==2){
            new Videos(instructor);
        }
    }

    private void add_assessment(Student x,Student y,Student z){
        System.out.println("1. Add Assignment\n" +
                           "2. Add Quiz");
        int a = scan.nextInt();
        if(a==1){
            new Assignment(x,y,z);
        }
        else if(a==2){
            new Quiz(x,y,z);
        }

    }

    private void grade_assessment(Student x,Student y,Student z){
        System.out.println("List of assessments");
        int ID=0;
        for(int i=0;i<Instructor.assignment_array.size();i++){
            if(Instructor.assignment_array.get(i).open) {
                System.out.println("ID: " + ID + " Assignment: " + Instructor.assignment_array.get(i).problem + " Max marks: " + Instructor.assignment_array.get(i).max_marks);
                Instructor.assignment_array.get(i).serial_no=ID;
                x.S0_assign_list.get(i).serial_no=ID;
                y.S1_assign_list.get(i).serial_no=ID;
                z.S2_assign_list.get(i).serial_no=ID;
                ID++;
            }
        }
        for(int i=0;i<Instructor.quiz_array.size();i++){
            if(Instructor.quiz_array.get(i).open) {
                System.out.println("ID: " + ID + " Question: " + Instructor.quiz_array.get(i).question);
                Instructor.quiz_array.get(i).serial_no=ID;
                x.S0_quiz_list.get(i).serial_no=ID;
                y.S1_quiz_list.get(i).serial_no=ID;
                z.S2_quiz_list.get(i).serial_no=ID;
                ID++;
            }
        }
        System.out.print("Enter ID of assessments to view submissions: ");
        int temp_id = scan.nextInt();
        boolean quiz_s0=true;
        boolean quiz_s1=true;
        boolean quiz_s2=true;
        for(int i=0;i<Instructor.assignment_array.size();i++){

            if(Instructor.assignment_array.get(i).serial_no==temp_id){
                System.out.println("Choose ID from these ungraded submissions");
                int n=0;
                for(int k=0;k<x.S0_assign_list.size();k++){
                    if(!x.S0_assign_list.get(k).pending_S0 && x.S0_assign_list.get(k).serial_no==temp_id){
                        System.out.println(n+". S0");
                        quiz_s0=false;
                        x.temp_choice=n;
                        n++;
                        break;
                    }
                }
                if(quiz_s0){
                    for(int k=0;k<x.S0_quiz_list.size();k++){
                        if(!x.S0_quiz_list.get(k).pending_S0){
                            System.out.println(n+". S0");
                            x.temp_choice=n;
                            n++;
                            break;
                        }
                    }
                }
                for(int k=0;k<y.S1_assign_list.size();k++){
                    if(!y.S1_assign_list.get(k).pending_S1 && y.S1_assign_list.get(k).serial_no==temp_id){
                        System.out.println(n+". S1");
                        quiz_s1=false;
                        y.temp_choice=n;
                        n++;
                        break;
                    }
                }
                if(quiz_s1){
                    for(int k=0;k<y.S1_quiz_list.size();k++){
                        if(!y.S1_quiz_list.get(k).pending_S1){
                            System.out.println(n+". S1");
                            y.temp_choice=n;
                            n++;
                            break;
                        }
                    }
                }
                for(int k=0;k<z.S2_assign_list.size();k++){
                    if(!z.S2_assign_list.get(k).pending_S2 && z.S2_assign_list.get(k).serial_no==temp_id){
                        System.out.println(n+". S2");
                        quiz_s2=false;
                        z.temp_choice=n;
                        break;
                    }
                }
                if(quiz_s2){
                    for(int k=0;k<z.S2_quiz_list.size();k++){
                        if(!z.S2_quiz_list.get(k).pending_S2){
                            System.out.println(n+". S2");
                            z.temp_choice=n;
                            break;
                        }
                    }
                }
                break;
            }

        }
        int choice_id = scan.nextInt();
        for(int i=0;i<Instructor.assignment_array.size();i++) {

            if (Instructor.assignment_array.get(i).serial_no == temp_id) {
                for(int k=0;k<x.S0_assign_list.size();k++){
                    if(!x.S0_assign_list.get(k).pending_S0){
                        quiz_s0=false;
                        if(x.temp_choice==choice_id) {

                            System.out.println("Submission: " + x.S0_assign_list.get(temp_id).filename_S0);
                            System.out.println("Max marks: "+x.S0_assign_list.get(temp_id).max_marks);
                            System.out.print("Marks scored: ");
                            x.S0_assign_list.get(temp_id).score=scan.nextInt();
                            x.S0_assign_list.get(temp_id).graded=true;
                            x.S0_assign_list.get(temp_id).teacher=this;
                            break;
                        }
                    }
                }
                if(quiz_s0){
                    for(int k=0;k<x.S0_quiz_list.size();k++){
                        if(!x.S0_quiz_list.get(k).pending_S0){
                            if(x.temp_choice==choice_id) {
                                System.out.println("Question: "+x.S0_quiz_list.get(k).question);
                                System.out.println("Answer: "+x.S0_quiz_list.get(k).answer);
                                x.S0_quiz_list.get(k).graded=true;
                                x.S0_quiz_list.get(k).teacher=this;
                                break;
                            }
                        }
                    }
                }
                for(int k=0;k<y.S1_assign_list.size();k++){
                    if(!y.S1_assign_list.get(k).pending_S1){
                        quiz_s1=false;
                        if(y.temp_choice==choice_id) {

                            System.out.println("Submission: " + y.S1_assign_list.get(temp_id).filename_S1);
                            System.out.println("Max marks: "+y.S1_assign_list.get(temp_id).max_marks);
                            System.out.print("Marks scored: ");
                            y.S1_assign_list.get(temp_id).score=scan.nextInt();
                            y.S1_assign_list.get(temp_id).graded = true;
                            y.S1_assign_list.get(temp_id).teacher = this;
                            break;
                        }
                    }
                }
                if(quiz_s1){
                    for(int k=0;k<y.S1_quiz_list.size();k++){
                        if(!y.S1_quiz_list.get(k).pending_S1){
                            if(y.temp_choice==choice_id) {
                                System.out.println("Question: "+y.S1_quiz_list.get(k).question);
                                System.out.println("Answer: "+y.S1_quiz_list.get(k).answer);
                                y.S1_quiz_list.get(k).graded=true;
                                y.S1_quiz_list.get(k).teacher=this;
                                break;
                            }
                        }
                    }
                }
                for(int k=0;k<z.S2_assign_list.size();k++){
                    if(!z.S2_assign_list.get(k).pending_S2){
                        quiz_s2=false;
                        if(z.temp_choice==choice_id) {

                            System.out.println("Submission: " + z.S2_assign_list.get(temp_id).filename_S2);
                            System.out.println("Max marks: "+z.S2_assign_list.get(temp_id).max_marks);
                            System.out.print("Marks scored: ");
                            z.S2_assign_list.get(temp_id).score=scan.nextInt();
                            z.S2_assign_list.get(temp_id).graded=true;
                            z.S2_assign_list.get(temp_id).teacher=this;
                            break;
                        }
                    }
                }
                if(quiz_s2){
                    for(int k=0;k<z.S2_quiz_list.size();k++){
                        if(!z.S2_quiz_list.get(k).pending_S2){
                            if(z.temp_choice==choice_id) {
                                System.out.println("Question: "+z.S2_quiz_list.get(k).question);
                                System.out.println("Answer: "+z.S2_quiz_list.get(k).answer);
                                z.S2_quiz_list.get(k).graded=true;
                                z.S2_quiz_list.get(k).teacher=this;
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }


    }

    private void close_assessment(Student x,Student y,Student z){
        System.out.println("List of open assessments");
        int ID=0;
        for(int i=0;i<Instructor.assignment_array.size();i++){
            if(assignment_array.get(i).open) {
                System.out.println("ID: " + ID + " Assignment: " + Instructor.assignment_array.get(i).problem + " Max marks: " + Instructor.assignment_array.get(i).max_marks);
                assignment_array.get(i).serial_no=ID;

                ID++;
            }
        }
        for(int i=0;i<Instructor.quiz_array.size();i++){
            if(quiz_array.get(i).open) {
                System.out.println("ID: " + ID + " Question: " + Instructor.quiz_array.get(i).question);
                quiz_array.get(i).serial_no=ID;

                ID++;
            }
        }
        System.out.print("Enter ID of assessment to close: ");
        int id_no = scan.nextInt();
        boolean bool=true;
        for(int i=0;i<assignment_array.size();i++){
            if(assignment_array.get(i).serial_no==id_no && assignment_array.get(i).open){
                assignment_array.get(i).open=false;
                x.S0_assign_list.get(i).open=false;
                y.S1_assign_list.get(i).open=false;
                z.S2_assign_list.get(i).open=false;

                bool=false;
                break;
            }
        }
        if(bool){
            for(int i=0;i<quiz_array.size();i++){
                if(quiz_array.get(i).serial_no==id_no && assignment_array.get(i).open){
                    quiz_array.get(i).open=false;
                    x.S0_quiz_list.get(i).open=false;
                    y.S1_quiz_list.get(i).open=false;
                    z.S2_quiz_list.get(i).open=false;
                    break;
                }
            }
        }
    }



    @Override
    public void View_lectures(){
        for(int i=0;i<Instructor.slides_array.size();i++){
            System.out.println("Title: "+Instructor.slides_array.get(i).get(0)._topic);
            for(int j=0;j<Instructor.slides_array.get(i).size();j++){
                System.out.println("Slide "+(j+1)+": "+Instructor.slides_array.get(i).get(j)._content);
            }
            System.out.println("Number of slides: "+Instructor.slides_array.get(i).size());
            System.out.println("Date of upload: "+Instructor.slides_array.get(i).get(0).date_time);
            System.out.println("Uploaded by: I"+Instructor.slides_array.get(i).get(0)._giver.id);
            System.out.println("\n");
        }
        for(int i=0;i<Instructor.video_list.size();i++){
            System.out.println("Title of video: "+Instructor.video_list.get(i).topic);
            System.out.println("Video file: "+Instructor.video_list.get(i).filename);
            System.out.println("Date of upload: "+Instructor.video_list.get(i).date_time);
            System.out.println("Uploaded by: I"+Instructor.video_list.get(i).giver);
            System.out.println("\n");
        }
    }

    @Override
    public void View_assessments(){
        int ID=0;
        for(int i=0;i<Instructor.assignment_array.size();i++){
            if(Instructor.assignment_array.get(i).open) {
                System.out.println("ID: " + ID + " Assignment: " + Instructor.assignment_array.get(i).problem + " Max marks: " + Instructor.assignment_array.get(i).max_marks);
                ID++;
            }
        }
        for(int i=0;i<Instructor.quiz_array.size();i++){
            if(Instructor.quiz_array.get(i).open) {
                System.out.println("ID: " + ID + " Question: " + Instructor.quiz_array.get(i).question);
                ID++;
            }
        }
    }

    @Override
    public void View_comments(Student x,Student y,Student z,Instructor a,Instructor b){
        Comment.show_comments(x,y,z,a,b);
    }

    @Override
    public void add_comments(){
        new Comment(this);
    }

}
