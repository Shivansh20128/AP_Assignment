package com.brickBracker;

import java.util.Scanner;

public class Assignment {
    private String problem;
    private int max_marks;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public Assignment(){ this.add_assignemnt();}

    private void add_assignemnt() {
        System.out.print("Enter problem Statement: ");
        this.problem = scan.next();
        System.out.print("Enter maximum marks: ");
        this.max_marks = scan.nextInt();
        Instructor.assignment_array.add(this);
    }
}
