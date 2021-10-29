package com.brickBracker;

public class Cobra_snake_floor extends Floor{
    public Cobra_snake_floor(){ }
    private Player my_player;

    public void cobra_floor(Player p, Floor f){
        my_player=p;
        System.out.println(my_player.name + " has reached king cobra");
        my_player.setScore(my_player.getScore()-4);
        System.out.println("Total points: " + my_player.getScore());
        my_player.setFloor_no(3);
        System.out.println("Player position Floor- " + my_player.getFloor_no());
    }
}
