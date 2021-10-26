package com.brickBracker;

public class Floor {
    public Floor(){}
    private Player _player;

    public void normal(Player p){
        _player=p;
        System.out.println(_player.name + " has reached an empty floor");
        _player.score++;
        System.out.println("Total points: " + _player.score);
    }
}
