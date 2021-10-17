package com.brickBracker;

import java.util.Scanner;

public class Videos {
    private String topic;
    private String filename;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public Videos(){ this.add_video();}

    private void add_video() {
        boolean temp = true;
        System.out.print("Enter topic of video: ");
        this.topic = scan.next();
        while(temp) {
            System.out.print("Enter filename of video: ");
            String filename = scan.next();
            if (filename.endsWith(".mp4")) {
                this.filename = filename;
                temp=false;
                Instructor.video_list.add(this);
            } else {
                System.out.println("Wrong file type!");
            }
        }
    }
}
