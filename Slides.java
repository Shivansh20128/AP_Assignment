package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Slides {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    private Slides _slide;
    private String _topic;
    private int no_of_slides;

    public Slides() {
        this.add_slide();
    }

    private void add_slide() {
        ArrayList<String> ver_list = new ArrayList<>();
        Instructor.slides_array.add(ver_list);
        System.out.print("Enter topic of slides: ");
        this._topic = scan.next();
        System.out.print("Enter number of slides: ");
        this.no_of_slides = scan.nextInt();
        System.out.println("Enter content of slides");
        for(int i=0;i<this.no_of_slides;i++){
            System.out.print("Enter content of slide "+ (i+1)+": ");
            String content = scan.next();
            ver_list.add(content);
        }

    }
}
