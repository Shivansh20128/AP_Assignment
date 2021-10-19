package com.brickBracker;

import java.util.Date;
import java.util.Scanner;


public class Videos {
    public String topic;
    public String filename;
    public Date date_time;
    public int giver;
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public Videos(Instructor ins){ this.add_video(ins);}

    public Date set_upload_date(){
        date_time=java.util.Calendar.getInstance().getTime();
        return date_time;
    }

    private void add_video(Instructor instructor) {
        boolean temp = true;
        System.out.print("Enter topic of video: ");
        this.topic = scan.next();
        while(temp) {
            System.out.print("Enter filename of video: ");
            String filename = scan.next();
            if (filename.endsWith(".mp4")) {
                this.filename = filename;
                this.giver=instructor.id;
                this.date_time=set_upload_date();
                temp=false;
                Instructor.video_list.add(this);
            } else {
                System.out.println("Wrong file type!");
            }
        }
    }
}
