package com.brickBracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Slides {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    private Slides _slide;
    public String _topic;
    public String _content;
    public Date date_time;
    private int no_of_slides;
    public Instructor _giver;

    public Slides(Instructor ins) {
        this.add_slide(ins);
    }
    private Slides(){ }
    public Date set_upload_date(){
        date_time=java.util.Calendar.getInstance().getTime();
        return date_time;
    }
    private void add_slide(Instructor giver) {
        ArrayList<Slides> ver_list = new ArrayList<>();
        Instructor.slides_array.add(ver_list);
        System.out.print("Enter topic of slides: ");
        String name = scan.next();
        System.out.print("Enter number of slides: ");
        this.no_of_slides = scan.nextInt();
        this.date_time=set_upload_date();
        System.out.println("Enter content of slides");
        for(int i=0;i<this.no_of_slides;i++){
            Slides new_slide = new Slides();
            new_slide._topic=name;
            System.out.print("Enter content of slide "+ (i+1)+": ");
            new_slide._content= scan.next();
            ver_list.add(new_slide);
            new_slide._giver=giver;
        }




    }
}
