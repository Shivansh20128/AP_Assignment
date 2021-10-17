package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Comment {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    private String comment;
    ArrayList<Comment> comments_array = new ArrayList<>();

    public Comment(){ this.add_comment();}

    private void add_comment() {
        System.out.print("Enter comment: ");
        String comm = scan.next();
        this.comment=comm;
        comments_array.add(this);
    }
}
