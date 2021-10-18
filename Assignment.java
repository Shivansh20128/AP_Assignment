package com.brickBracker;

import java.util.Scanner;

public class Assignment {
    public String problem;
    public String filename;
    public int serial_no;
    public boolean pending=true;
    public boolean open = true;
    public int max_marks;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public Assignment(Student x,Student y,Student z){ this.add_assignemnt(x,y,z);}

    private void add_assignemnt(Student x,Student y,Student z) {
        System.out.print("Enter problem Statement: ");
        this.problem = scan.next();
        System.out.print("Enter maximum marks: ");
        this.max_marks = scan.nextInt();
        Instructor.assignment_array.add(this);
        x._add_assign_to_list(this,x);
        y._add_assign_to_list(this,y);
        z._add_assign_to_list(this,z);

    }
}
