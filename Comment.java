package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Comment {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private String comment;
    private String date_time;
    private boolean temp;
    private Instructor writer_t;
    private Student writer_s;
    static ArrayList<Comment> comments_array = new ArrayList<>();

    public Comment(Instructor teacher){ this.add_teacher_comment(teacher);}
    public Comment(Student student){ this.add_student_comment(student);}

    private void add_student_comment(Student s) {
        System.out.print("Enter comment: ");
        String comm = scan.next();
        LocalDateTime now = LocalDateTime.now();
        this.date_time = dtf.format(now);
        this.temp=true;
        this.writer_s=s;
        this.comment=comm;
        comments_array.add(this);
    }

    private void add_teacher_comment(Instructor t) {
        System.out.print("Enter comment: ");
        String comm = scan.next();
        LocalDateTime now = LocalDateTime.now();
        this.date_time = dtf.format(now);
        this.temp=false;
        this.writer_t=t;
        this.comment=comm;
        comments_array.add(this);
    }

    public static void show_comments(){
        for(int i=0;i<comments_array.size();i++){
            if(!comments_array.get(i).temp) {
                System.out.println(comments_array.get(i).comment + " - I" + comments_array.get(i).writer_t.id);
                System.out.println(comments_array.get(i).date_time+"\n");

            }
            else{
                System.out.println(comments_array.get(i).comment + " - S" + comments_array.get(i).writer_s.id);
                System.out.println(comments_array.get(i).date_time+"\n");

            }
        }
    }
}
