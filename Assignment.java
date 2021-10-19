package com.brickBracker;

import java.util.Scanner;

public class Assignment {
    public String problem;
    public String filename_S0;
    public String filename_S1;
    public String filename_S2;
    public int serial_no;
    public boolean pending_S0=true;
    public boolean pending_S1=true;
    public boolean pending_S2=true;

    public boolean open = true;
    public int max_marks;
    public int score;
    public Instructor teacher;
    public boolean graded=false;
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
