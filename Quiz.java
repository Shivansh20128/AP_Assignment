package com.brickBracker;

import java.util.Scanner;

public class Quiz {
    public String question;
    public int serial_no;
    public String answer;
    public boolean pending=true;
    public boolean open=true;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public Quiz(Student x,Student y,Student z){ this.add_quiz(x,y,z);}

    private void add_quiz(Student x,Student y,Student z) {
        System.out.print("Enter quiz question: ");
        this.question = scan.next();
        Instructor.quiz_array.add(this);
        x._add_quiz_to_list(this,x);
        y._add_quiz_to_list(this,y);
        z._add_quiz_to_list(this,z);
    }
}
