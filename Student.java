package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Student implements User{
    ArrayList<Assignment> _stu_assign_list ;

    ArrayList<Quiz> _stu_quiz_list;

    public int id;
    private BackPack_Portal _portal;
    private Student _student;

    Scanner scan = new Scanner(System.in);

    public Student(){
        _stu_assign_list = new ArrayList<>();
        _stu_quiz_list = new ArrayList<>();
    }

    public void _add_assign_to_list(Assignment assign,Student stu){
        stu._stu_assign_list.add(assign);
    }
    public void _add_quiz_to_list(Quiz quiz,Student stu){
        stu._stu_quiz_list.add(quiz);
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
        int ID=0;
        boolean empty=true;
        System.out.println("Pending assessments");

        for(int i=0;i<student._stu_assign_list.size();i++){
            if(student._stu_assign_list.get(i).pending && student._stu_assign_list.get(i).open) {
                System.out.println("ID: " + ID + " Assignment: " + student._stu_assign_list.get(i).problem + " Max marks: " + student._stu_assign_list.get(i).max_marks);
                student._stu_assign_list.get(i).serial_no=ID;
                empty=false;
                ID++;
            }
        }
        for(int i=0;i<student._stu_quiz_list.size();i++){
            if(student._stu_quiz_list.get(i).pending && student._stu_quiz_list.get(i).open) {
                System.out.println("ID: " + ID + " Question: " + student._stu_quiz_list.get(i).question);
                student._stu_quiz_list.get(i).serial_no=ID;
                empty=false;
                ID++;
            }
        }

        if(!empty) {
            System.out.print("Enter ID of assessment: ");
            int id_no = scan.nextInt();
            boolean temp = true;
            for (int i = 0; i < student._stu_assign_list.size(); i++) {
                if (student._stu_assign_list.get(i).serial_no == id_no && student._stu_assign_list.get(i).pending && student._stu_assign_list.get(i).open) {
                    System.out.print("Enter filename of assignment: ");
                    String fn;
                    while (true) {
                        fn = scan.next();
                        if (fn.endsWith(".zip")) {
                            student._stu_assign_list.get(i).filename = fn;
                            student._stu_assign_list.get(i).pending = false;
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
                for (int i = 0; i < student._stu_quiz_list.size(); i++) {
                    if (student._stu_quiz_list.get(i).serial_no == id_no && student._stu_quiz_list.get(i).pending && student._stu_quiz_list.get(i).open) {
                        System.out.print(student._stu_quiz_list.get(i).question + ": ");
                        student._stu_quiz_list.get(i).answer = scan.next();
                        student._stu_quiz_list.get(i).pending = false;
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("No pending assignments!");
        }

    }

    private void view_grades(){

    }

    @Override
    public void View_comments(){
        Comment.show_comments();
    }

    @Override
    public void add_comments(){
        new Comment(this);
    }


    public void login(BackPack_Portal backPack_portal, Student student, int student_choice) {
        this._portal=backPack_portal;
        this.id=student_choice;
        this._student = student;
        System.out.println("Welcome S"+_student.id);
        student_portal(_student);

    }

    private void student_portal(Student st) {
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
                student_portal(st);
                break;
            case 2:
                View_assessments();
                student_portal(st);
                break;
            case 3:
                submit_assessment(_student);
                student_portal(st);
                break;
            case 4:
                view_grades();
                student_portal(st);
                break;
            case 5:
                View_comments();
                student_portal(st);
                break;
            case 6:
                add_comments();
                student_portal(st);
                break;
            case 7:
                _portal.login();
                break;
        }

    }
}
