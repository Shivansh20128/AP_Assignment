package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Slides {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    private Slides _slide;
    public String _topic;
    public String _content;
    public String date_time;
    private int no_of_slides;
    public Instructor _giver;

    public Slides(Instructor ins) {
        this.add_slide(ins);
    }
    private Slides(){ }
    private void add_slide(Instructor giver) {
        ArrayList<Slides> ver_list = new ArrayList<>();
        Instructor.slides_array.add(ver_list);
        System.out.print("Enter topic of slides: ");
        String name = scan.next();
        System.out.print("Enter number of slides: ");
        this.no_of_slides = scan.nextInt();
        System.out.println("Enter content of slides");
        LocalDateTime now = LocalDateTime.now();
        for(int i=0;i<this.no_of_slides;i++){
            Slides new_slide = new Slides();
            new_slide._topic=name;
            System.out.print("Enter content of slide "+ (i+1)+": ");
            new_slide._content= scan.next();
            ver_list.add(new_slide);
            new_slide._giver=giver;
            new_slide.date_time = dtf.format(now);
        }




    }
}
