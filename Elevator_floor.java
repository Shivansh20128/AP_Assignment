package com.brickBracker;

public class Elevator_floor extends Floor{
    public Elevator_floor(){ }
    private Player my_player;
    private int floor_no;

    public void elevator(Player p, Floor f){
        my_player=p;
        floor_no=p.getFloor_no();
        f.set_floor_no(floor_no);
        System.out.println(my_player.name + " has reached an elevator floor");
        my_player.setScore(my_player.getScore() + 4);
        System.out.println("Total points: " + my_player.getScore());
        my_player.setFloor_no(10);
        System.out.println("Player position Floor- " + my_player.getFloor_no());
    }
}
