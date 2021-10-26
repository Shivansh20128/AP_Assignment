package com.brickBracker;

public class Ladder_floor extends Floor{
    public Ladder_floor(){ }
    private Player my_player;

    public void ladder(Player p){
        my_player=p;
        System.out.println(my_player.name + " has reached a ladder floor");
        my_player.score = my_player.score + 2;
        System.out.println("Total points: " + my_player.score);
        my_player.floor_no = 12;
        System.out.println("Player position Floor- " + my_player.floor_no);
    }
}
