package com.brickBracker;

public class Elevator_floor extends Floor{
    public Elevator_floor(){ }
    private Player my_player;

    public void elevator(Player p){
        my_player=p;
        System.out.println(my_player.name + " has reached an elevator floor");
        my_player.score = my_player.score + 4;
        System.out.println("Total points: " + my_player.score);
        my_player.floor_no = 10;
        System.out.println("Player position Floor- " + my_player.floor_no);
    }
}
