package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Student implements User{
    ArrayList<Assignment> S0_assign_list = new ArrayList<>();
    ArrayList<Assignment> S1_assign_list = new ArrayList<>();
    ArrayList<Assignment> S2_assign_list = new ArrayList<>();

    ArrayList<Quiz> S0_quiz_list = new ArrayList<>();
    ArrayList<Quiz> S1_quiz_list = new ArrayList<>();
    ArrayList<Quiz> S2_quiz_list = new ArrayList<>();

    int id;
    int temp_choice;
    private BackPack_Portal _portal;
    private Student _student;

    Scanner scan = new Scanner(System.in);

    public Student(){

    }

    public void _add_assign_to_list(Assignment assign,Student stu){
        if(stu.id==0){
            stu.S0_assign_list.add(assign);
        }
        else if(stu.id==1){
            stu.S1_assign_list.add(assign);
        }
        else if(stu.id==2){
            stu.S2_assign_list.add(assign);
        }
    }
    public void _add_quiz_to_list(Quiz quiz,Student stu){
        if(stu.id==0){
            stu.S0_quiz_list.add(quiz);
        }
        else if(stu.id==1){
            stu.S1_quiz_list.add(quiz);
        }
        else if(stu.id==2){
            stu.S2_quiz_list.add(quiz);
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

    private void submit_assessment(Student student){


        System.out.println("Pending assessments");


        if(student.id==0){
            int ID=0;

            boolean empty=true;
            for(int i=0;i<S0_assign_list.size();i++){
                if(S0_assign_list.get(i).pending_S0 && S0_assign_list.get(i).open) {
                    System.out.println("ID: " + ID + " Assignment: " + S0_assign_list.get(i).problem + " Max marks: " + S0_assign_list.get(i).max_marks);
                    S0_assign_list.get(i).serial_no=ID;
                    empty=false;
                    ID++;
                }
            }
            for(int i=0;i<S0_quiz_list.size();i++){
                if(S0_quiz_list.get(i).pending_S0 && S0_quiz_list.get(i).open) {
                    System.out.println("ID: " + ID + " Question: " + S0_quiz_list.get(i).question);
                    S0_quiz_list.get(i).serial_no=ID;
                    empty=false;
                    ID++;
                }
            }

            if(!empty) {
                System.out.print("Enter ID of assessment: ");
                int id_no = scan.nextInt();
                boolean temp = true;
                for (int i = 0; i < S0_assign_list.size(); i++) {
                    if (S0_assign_list.get(i).serial_no == id_no && S0_assign_list.get(i).pending_S0 && S0_assign_list.get(i).open) {
                        System.out.print("Enter filename of assignment: ");
                        String fn;
                        while (true) {
                            fn = scan.next();
                            if (fn.endsWith(".zip")) {
                                student.S0_assign_list.get(i).filename_S0 = fn;
                                student.S0_assign_list.get(i).pending_S0 = false;
                                break;
                            } else {
                                System.out.println("Wrong file type!");
                            }
                        }
                        temp = false;
                        break;
                    }
                }
                if (temp) {
                    for (int i = 0; i < S0_quiz_list.size(); i++) {
                        if (S0_quiz_list.get(i).serial_no == id_no && S0_quiz_list.get(i).pending_S0 && S0_quiz_list.get(i).open) {
                            System.out.print(S0_quiz_list.get(i).question + ": ");
                            S0_quiz_list.get(i).answer = scan.next();
                            S0_quiz_list.get(i).pending_S0 = false;
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("No pending assignments!");
            }
        }
        else if(student.id==1){
            int ID=0;

            boolean empty=true;
            for(int i=0;i<S1_assign_list.size();i++){
                if(S1_assign_list.get(i).pending_S1 && S1_assign_list.get(i).open) {
                    System.out.println("ID: " + ID + " Assignment: " + S1_assign_list.get(i).problem + " Max marks: " + S1_assign_list.get(i).max_marks);
                    S1_assign_list.get(i).serial_no=ID;
                    empty=false;
                    ID++;
                }
            }
            for(int i=0;i<S1_quiz_list.size();i++){
                if(S1_quiz_list.get(i).pending_S1 && S1_quiz_list.get(i).open) {
                    System.out.println("ID: " + ID + " Question: " + S1_quiz_list.get(i).question);
                    S1_quiz_list.get(i).serial_no=ID;
                    empty=false;
                    ID++;
                }
            }

            if(!empty) {
                System.out.print("Enter ID of assessment: ");
                int id_no = scan.nextInt();
                boolean temp = true;
                for (int i = 0; i < S1_assign_list.size(); i++) {
                    if (S1_assign_list.get(i).serial_no == id_no && S1_assign_list.get(i).pending_S1 && S1_assign_list.get(i).open) {
                        System.out.print("Enter filename of assignment: ");
                        String fn;
                        while (true) {
                            fn = scan.next();
                            if (fn.endsWith(".zip")) {
                                student.S1_assign_list.get(i).filename_S1 = fn;
                                student.S1_assign_list.get(i).pending_S1 = false;
                                break;
                            } else {
                                System.out.println("Wrong file type!");
                            }
                        }
                        temp = false;
                        break;
                    }
                }
                if (temp) {
                    for (int i = 0; i < S1_quiz_list.size(); i++) {
                        if (S1_quiz_list.get(i).serial_no == id_no && S1_quiz_list.get(i).pending_S1 && S1_quiz_list.get(i).open) {
                            System.out.print(S1_quiz_list.get(i).question + ": ");
                            S1_quiz_list.get(i).answer = scan.next();
                            S1_quiz_list.get(i).pending_S1 = false;
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("No pending assignments!");
            }
        }
        else if(student.id==2){
            int ID=0;

            boolean empty=true;
            for(int i=0;i<S2_assign_list.size();i++){
                if(S2_assign_list.get(i).pending_S2 && S2_assign_list.get(i).open) {
                    System.out.println("ID: " + ID + " Assignment: " + S2_assign_list.get(i).problem + " Max marks: " + S2_assign_list.get(i).max_marks);
                    S2_assign_list.get(i).serial_no=ID;
                    empty=false;
                    ID++;
                }
            }
            for(int i=0;i<S2_quiz_list.size();i++){
                if(S2_quiz_list.get(i).pending_S2 && S2_quiz_list.get(i).open) {
                    System.out.println("ID: " + ID + " Question: " + S2_quiz_list.get(i).question);
                    S2_quiz_list.get(i).serial_no=ID;
                    empty=false;
                    ID++;
                }
            }

            if(!empty) {
                System.out.print("Enter ID of assessment: ");
                int id_no = scan.nextInt();
                boolean temp = true;
                for (int i = 0; i < S2_assign_list.size(); i++) {
                    if (S2_assign_list.get(i).serial_no == id_no && S2_assign_list.get(i).pending_S2 && S2_assign_list.get(i).open) {
                        System.out.print("Enter filename of assignment: ");
                        String fn;
                        while (true) {
                            fn = scan.next();
                            if (fn.endsWith(".zip")) {
                                student.S2_assign_list.get(i).filename_S2 = fn;
                                student.S2_assign_list.get(i).pending_S2 = false;
                                break;
                            } else {
                                System.out.println("Wrong file type!");
                            }
                        }
                        temp = false;
                        break;
                    }
                }
                if (temp) {
                    for (int i = 0; i < S2_quiz_list.size(); i++) {
                        if (S2_quiz_list.get(i).serial_no == id_no && S2_quiz_list.get(i).pending_S2 && S2_quiz_list.get(i).open) {
                            System.out.print(S2_quiz_list.get(i).question + ": ");
                            S2_quiz_list.get(i).answer = scan.next();
                            S2_quiz_list.get(i).pending_S2 = false;
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("No pending assignments!");
            }
        }


    }

    private void view_grades(Student s){
        System.out.println("Graded submissions");
        if(s.id==0) {
            for (int i = 0; i < s.S0_assign_list.size(); i++) {
                if(s.S0_assign_list.get(i).graded){
                    System.out.println("Submission: "+s.S0_assign_list.get(i).filename_S0);
                    System.out.println("Marks scored: "+s.S0_assign_list.get(i).score);
                    System.out.println("Graded by: I"+s.S0_assign_list.get(i).teacher.id);
                }
            }
            for (int i = 0; i < s.S0_quiz_list.size(); i++) {
                if(s.S0_quiz_list.get(i).graded){
                    System.out.println("Marks scored: "+s.S0_quiz_list.get(i).answer);
                    System.out.println("Graded by: I"+s.S0_quiz_list.get(i).teacher.id);
                }
            }
        }
        else if(s.id==1){
            for (int i = 0; i < s.S1_assign_list.size(); i++) {
                if(s.S1_assign_list.get(i).graded){
                    System.out.println("Submission: "+s.S1_assign_list.get(i).filename_S1);
                    System.out.println("Marks scored: "+s.S1_assign_list.get(i).score);
                    System.out.println("Graded by: I"+s.S1_assign_list.get(i).teacher.id);
                }
            }
            for (int i = 0; i < s.S1_quiz_list.size(); i++) {
                if(s.S1_quiz_list.get(i).graded){
                    System.out.println("Marks scored: "+s.S1_quiz_list.get(i).answer);
                    System.out.println("Graded by: I"+s.S1_quiz_list.get(i).teacher.id);
                }
            }
        }
        else if(s.id==2){
            for (int i = 0; i < s.S2_assign_list.size(); i++) {
                if(s.S2_assign_list.get(i).graded){
                    System.out.println("Submission: "+s.S2_assign_list.get(i).filename_S2);
                    System.out.println("Marks scored: "+s.S2_assign_list.get(i).score);
                    System.out.println("Graded by: I"+s.S2_assign_list.get(i).teacher.id);
                }
            }
            for (int i = 0; i < s.S2_quiz_list.size(); i++) {
                if(s.S2_quiz_list.get(i).graded){
                    System.out.println("Marks scored: "+s.S2_quiz_list.get(i).answer);
                    System.out.println("Graded by: I"+s.S0_quiz_list.get(i).teacher.id);
                }
            }
        }
        System.out.println("Ungraded submissions");
        if(s.id==0) {
            for (int i = 0; i < s.S0_assign_list.size(); i++) {
                if(!s.S0_assign_list.get(i).graded && !s.S0_assign_list.get(i).pending_S0){
                    System.out.println("Submission: "+s.S0_assign_list.get(i).filename_S0);
                }
            }
            for (int i = 0; i < s.S0_quiz_list.size(); i++) {
                if(!s.S0_quiz_list.get(i).graded && !s.S0_quiz_list.get(i).pending_S0){
                    System.out.println("Question"+s.S0_quiz_list.get(i).question);
                }
            }
        }
        else if(s.id==1){
            for (int i = 0; i < s.S1_assign_list.size(); i++) {
                if(!s.S1_assign_list.get(i).graded && !s.S1_assign_list.get(i).pending_S1){
                    System.out.println("Submission: "+s.S1_assign_list.get(i).filename_S1);
                }
            }
            for (int i = 0; i < s.S1_quiz_list.size(); i++) {
                if(!s.S1_quiz_list.get(i).graded && !s.S1_quiz_list.get(i).pending_S1){
                    System.out.println("Question"+s.S1_quiz_list.get(i).question);
                }
            }
        }
        else if(s.id==2){
            for (int i = 0; i < s.S2_assign_list.size(); i++) {
                if(!s.S2_assign_list.get(i).graded && !s.S2_assign_list.get(i).pending_S2){
                    System.out.println("Submission: "+s.S2_assign_list.get(i).filename_S2);
                }
            }
            for (int i = 0; i < s.S2_quiz_list.size(); i++) {
                if(!s.S2_quiz_list.get(i).graded && !s.S2_quiz_list.get(i).pending_S2){
                    System.out.println("Question"+s.S2_quiz_list.get(i).question);
                }
            }
        }
    }

    @Override
    public void View_comments(Student x,Student y,Student z,Instructor a, Instructor b){
        Comment.show_comments(x,y,z,a,b);
    }

    @Override
    public void add_comments(){
        new Comment(this);
    }


    public void login(BackPack_Portal backPack_portal, Student student, int student_choice,Student x,Student y,Student z,Instructor a,Instructor b) {
        this._portal=backPack_portal;
        this.id=student_choice;
        this._student = student;
        System.out.println("Welcome S"+_student.id);
        student_portal(_student,x,y,z,a,b);

    }

    private void student_portal(Student st,Student x,Student y, Student z,Instructor a, Instructor b) {
        System.out.println("""
                STUDENT MENU
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout""");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                View_lectures();
                student_portal(st,x,y,z,a,b);
                break;
            case 2:
                View_assessments();
                student_portal(st,x,y,z,a,b);
                break;
            case 3:
                submit_assessment(_student);
                student_portal(st,x,y,z,a,b);
                break;
            case 4:
                view_grades(st);
                student_portal(st,x,y,z,a,b);
                break;
            case 5:
                View_comments(x,y,z,a,b);
                student_portal(st,x,y,z,a,b);
                break;
            case 6:
                add_comments();
                student_portal(st,x,y,z,a,b);
                break;
            case 7:
                _portal.login();
                break;
        }

    }
}
