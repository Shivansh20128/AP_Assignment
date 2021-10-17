package com.brickBracker;

import java.util.Scanner;

public class Quiz {
    private String question;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public Quiz(){ this.add_quiz();}

    private void add_quiz() {
        System.out.print("Enter quiz question: ");
        this.question = scan.next();
        Instructor.quiz_array.add(this);
    }
}
