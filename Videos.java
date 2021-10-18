package com.brickBracker;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Videos {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public String topic;
    public String filename;
    public String date_time;
    public int giver;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public Videos(Instructor ins){ this.add_video(ins);}

    private void add_video(Instructor instructor) {
        boolean temp = true;
        System.out.print("Enter topic of video: ");
        this.topic = scan.next();
        while(temp) {
            System.out.print("Enter filename of video: ");
            String filename = scan.next();
            LocalDateTime now = LocalDateTime.now();
            if (filename.endsWith(".mp4")) {
                this.filename = filename;
                this.giver=instructor.id;
                temp=false;
                Instructor.video_list.add(this);
                this.date_time = dtf.format(now);
            } else {
                System.out.println("Wrong file type!");
            }
        }
    }
}
