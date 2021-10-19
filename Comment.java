package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Comment {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    Date date_of_upload;
    public Date set_upload_date(){
        date_of_upload=java.util.Calendar.getInstance().getTime();
        return date_of_upload;
    }

    private String comment;
    private Date xyz;
    private boolean temp;
    private User writer;
    static ArrayList<Comment> comments_array = new ArrayList<>();

    public Comment (User user){ this.add_comment(user);}

    private void add_comment(User u) {
        System.out.print("Enter comment: ");
        String comm = scan.next();
        this.xyz=set_upload_date();

        this.temp=true;
        this.writer=u;
        this.comment=comm;
        comments_array.add(this);
    }

    public static void show_comments(Student x,Student y,Student z,Instructor a, Instructor b){
        for(int i=0;i<comments_array.size();i++){
            if(comments_array.get(i).writer.equals(x)){
                System.out.println(comments_array.get(i).comment + " - S0");
                System.out.println(comments_array.get(i).xyz+"\n");
            }
            else if(comments_array.get(i).writer.equals(y)){
                System.out.println(comments_array.get(i).comment + " - S1");
                System.out.println(comments_array.get(i).xyz+"\n");
            }
            else if(comments_array.get(i).writer.equals(z)){
                System.out.println(comments_array.get(i).comment + " - S2");
                System.out.println(comments_array.get(i).xyz+"\n");
            }
            else if(comments_array.get(i).writer.equals(a)){
                System.out.println(comments_array.get(i).comment + " - I0");
                System.out.println(comments_array.get(i).xyz+"\n");
            }
            else if(comments_array.get(i).writer.equals(b)){
                System.out.println(comments_array.get(i).comment + " - I1");
                System.out.println(comments_array.get(i).xyz+"\n");
            }
        }
    }
}
