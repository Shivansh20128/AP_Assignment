package com.brickBracker;

public class Normal_snake_floor extends Floor{
    public Normal_snake_floor(){ }
    private Player my_player;
    private int floor_no;

    public void normal_snake(Player p, Floor f){
        my_player=p;
        floor_no=p.getFloor_no();
        f.set_floor_no(floor_no);
        System.out.println(my_player.name + " has reached normal snake floor");
        my_player.setScore(my_player.getScore() - 2);
        System.out.println("Total points: " + my_player.getScore());
        my_player.setFloor_no(1);
        System.out.println("Player position Floor- " + my_player.getFloor_no());
    }

}
