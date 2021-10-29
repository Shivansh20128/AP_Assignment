package com.brickBracker;

public class Ladder_floor extends Floor{
    public Ladder_floor(){ }
    private Player my_player;
    private int floor_no;

    public void ladder(Player p, Floor f){
        my_player=p;
        floor_no=p.getFloor_no();
        f.set_floor_no(floor_no);
        System.out.println(my_player.name + " has reached a ladder floor");
        my_player.setScore(my_player.getScore() + 2);
        System.out.println("Total points: " + my_player.getScore());
        my_player.setFloor_no(12);
        System.out.println("Player position Floor- " + my_player.getFloor_no());
    }
}
