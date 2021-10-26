package com.brickBracker;

public class Cobra_snake_floor extends Floor{
    public Cobra_snake_floor(){ }
    private Player my_player;

    public void cobra_floor(Player p){
        my_player=p;
        System.out.println(my_player.name + " has reached king cobra");
        my_player.score=my_player.score-4;
        System.out.println("Total points: " + my_player.score);
        my_player.floor_no=3;
        System.out.println("Player position Floor- " + my_player.floor_no);
    }
}
