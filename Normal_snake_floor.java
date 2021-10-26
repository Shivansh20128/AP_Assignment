package com.brickBracker;

public class Normal_snake_floor extends Floor{
    public Normal_snake_floor(){ }
    private Player my_player;

    public void normal_snake(Player p){
        my_player=p;
        System.out.println(my_player.name + " has reached normal snake floor");
        my_player.score = my_player.score - 2;
        System.out.println("Total points: " + my_player.score);
        my_player.floor_no = 1;
        System.out.println("Player position Floor- " + my_player.floor_no);
    }

}
